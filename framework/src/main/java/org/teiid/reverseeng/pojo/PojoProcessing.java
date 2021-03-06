/*
 * JBoss, Home of Professional Open Source.
 * See the COPYRIGHT.txt file distributed with this work for information
 * regarding copyright ownership.  Some portions may be licensed
 * to Red Hat, Inc. under one or more contributor license agreements.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301 USA.
 */
package org.teiid.reverseeng.pojo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.teiid.core.TeiidException;
import org.teiid.core.util.StringUtil;
import org.teiid.reverseeng.Options;
import org.teiid.reverseeng.ReverseEngineerPlugin;
import org.teiid.reverseeng.api.AnnotationType;
import org.teiid.reverseeng.api.Column;
import org.teiid.reverseeng.api.MetadataProcessor;
import org.teiid.reverseeng.api.Table;

/**
 * @author vanhalbert
 *
 */
public class PojoProcessing {
	
	private static final String LICENSE_TEMPLATE = "org/teiid/reverseeng/license_template.txt";

	private Options options;
	private String path;
	private String packageName;
	private String pojoJarName;
	private String suffixClassName;
	private String moduleZipFileName;
	private AnnotationType annotationType;
	private ModulePackaging module = null;
	private Collection<Exception> errors = new ArrayList<Exception>();
	
	public PojoProcessing() {
	}

	public PojoProcessing(Options options) {
		this.options = options;
		
		this.path = options.getProperty(Options.Parms.BUILD_LOCATION);
		
		ReverseEngineerPlugin.LOGGER.debug("[ReverseEngineering] " + Options.Parms.BUILD_LOCATION + " property is: " + (path == null ? "NotSet" : path));
		
		annotationType = options.getAnnotationTypeInstance();
		
		packageName = options.getProperty(Options.Parms.POJO_PACKAGE_NAME);

		ReverseEngineerPlugin.LOGGER.debug("[ReverseEngineering] " + Options.Parms.POJO_PACKAGE_NAME + " property is: " + (packageName == null ? "NotSet" : packageName));

		pojoJarName = options.getProperty(Options.Parms.POJO_JAR_FILE);

		ReverseEngineerPlugin.LOGGER.debug("[ReverseEngineering] " + Options.Parms.POJO_JAR_FILE + " property is: " + (pojoJarName == null ? "NotSet" : pojoJarName));

		this.suffixClassName = options.getProperty(Options.Parms.CLASS_NAME_SUFFIX);
		
		ReverseEngineerPlugin.LOGGER.debug("[ReverseEngineering] " + Options.Parms.CLASS_NAME_SUFFIX + " property is: " + (this.suffixClassName == null ? "NotSet" : path));
		
		moduleZipFileName =  options.getProperty(Options.Parms.MODULE_ZIP_FILE);
		if (moduleZipFileName != null) {
			module = new ModulePackaging();
			ReverseEngineerPlugin.LOGGER.debug("[ReverseEngineering] " + Options.Parms.MODULE_ZIP_FILE + " property is: " + moduleZipFileName);
		}

	}
	
	public Collection<Exception> getExceptions() {
		return errors;
	}

	/**
	 * Called to perform the project processing of the metadata.  Will return <code>true</code> if it 
	 * was successful, with no exceptions.  If it returns <code>false</code>, then should call
	 * {@link #getExceptions()} to obtain the errors that occurred.
	 * @param metadata
	 * @return boolean true if successful
	 */
	public boolean processTables(MetadataProcessor metadata) {
		ReverseEngineerPlugin.LOGGER.info("[ReverseEngineering] Start reverse engineering process");

		try {

			performProcess(metadata);

		} catch (Exception e) {
			errors.add(e);
		}
		
		ReverseEngineerPlugin.LOGGER.info("[ReverseEngineering] Finished reverse engineering process");
		
		if (errors.isEmpty()) return true;
		
		return false;
	}
	
	private void performProcess(MetadataProcessor metadata) throws Exception {
		
	
		// remove if already exist
		File buildLocation = new File(path);
		if (buildLocation.exists()) {
			buildLocation.delete();
		}
		buildLocation.mkdir();
			
		// Location for the .java and .class files
		File classFileLocaton = new File(buildLocation, "class");
		classFileLocaton.mkdir();
		
		// location for created kits, example: .jar or .zip
		File kitLocation = new File(buildLocation, "kit"); 
		kitLocation.mkdir();
		
		// parse the package name to use to create the folder structure
		List<String> nodes = StringUtil.getTokens(packageName, ".");
		
		// create a file path structure of only the package name, used for creating path structure for artifacts
		StringBuffer packageFilePath = new StringBuffer();
			
		for (String n : nodes) {
			packageFilePath.append(n).append(File.separator);
		}
		
		File javaFileLoc = new File(classFileLocaton.getAbsolutePath() + File.separator + packageFilePath.toString());
		javaFileLoc.mkdirs();
		
		File pojoJarFile = null;
		if (pojoJarName != null && pojoJarName.trim().length() > 0) {
			pojoJarFile = new File(pojoJarName);
		} else {
			
			pojoJarFile = new File(kitLocation, Options.Parms_Defaults.DEFAULT_POJO_JAR_FILE); 
		}
		
		File parentPojoJar = pojoJarFile.getParentFile();
		if (!parentPojoJar.exists()) {
			parentPojoJar.mkdirs();
		}

		List<Table> tables = metadata.getTableMetadata();
		for (Table t : tables) {
			
			if (!t.hasRequiredColumn()) {
				String msg = "*** Table {" + t.getName() + "} doesn't have a required key column (i.e., no primary or unique key defined on the source table).  Will not be processed";
				
				ReverseEngineerPlugin.LOGGER.warn("[ReverseEngineering] " + msg);

				this.errors.add( new TeiidException(msg));
				continue;
			}
			
			String className = t.getClassName();
		    className = className + (this.suffixClassName != null ? this.suffixClassName : "");
			String javaFileName = className + ".java";
			
			File outputFile = new File(javaFileLoc.getAbsolutePath(), javaFileName);
						
			FileOutputStream fileOutput = new FileOutputStream(outputFile);

			PrintWriter outputStream = new PrintWriter(fileOutput);

			printPackage(outputStream, packageName);
			printHeader(outputStream, t);
			printImports(outputStream, t);
			
			printClass(outputStream, t, className);
			printAttributes(outputStream, t);
			printGetterSetters(outputStream, t);
			printToString(outputStream, t);
			printFooter(outputStream, t);
			
			fileOutput.close();
			
			ReverseEngineerPlugin.LOGGER.debug("[ReverseEngineering] Created java file: " + outputFile.getAbsolutePath());

		}
		
		PojoCompilation.compile(javaFileLoc, packageFilePath.toString(), pojoJarFile);	
		
		if (module != null) {
			try {
				module.performPackaging(options, packageName, pojoJarFile, moduleZipFileName, buildLocation, packageFilePath.toString(), kitLocation);

//				ReverseEngineerPlugin.LOGGER.info("[ReverseEngineering] Created module zip: " + pojoJarName);

			} catch(Exception e) {
				errors.add(e);
			}
		}

		
	}
	
	protected void printPackage(PrintWriter outputStream, String packageName) throws IOException {
		
		InputStream is = getClass().getClassLoader().getResourceAsStream(LICENSE_TEMPLATE);
		if (is != null) { 
			for( int c = is.read(); c != -1; c = is.read() ) {
				outputStream.print((char) c);
			}
		}
		
		outputStream.println("package " + packageName + ";");
		
	}

	/**
	 * prints standard source file header to outputStream
	 * 
	 * @param outputStream
	 *            where to print the header
	 * @param t
	 *            the Table representing the class
	 */
	protected void printHeader(PrintWriter outputStream, Table t) {

		outputStream.println("/**");
		outputStream.println("* Maps a relational database table "
				+ t.getName() + " to a java object, " + t.getClassName());
		outputStream.println("*");
		outputStream.println("* " + (t.getRemarks() != null ? t.getRemarks() : ""));
		outputStream.println("*");
		outputStream.println("* @author	ReverseEngineer");
		outputStream.println("*/");


	} // printHeader()

	/**
	 * prints imports to outputStream
	 * 
	 * @param outputStream
	 *            where to print the header
	 * @param t
	 *            the Table representing the class
	 */
	protected void printImports(PrintWriter outputStream, Table t) {

		outputStream.println("import java.io.Serializable;");
		outputStream.println("import java.sql.*;");
		outputStream.println("import java.util.*;");
		
		if (annotationType != null) {
			List<String> imports = annotationType.getImports();
			for(String i : imports) {
				outputStream.println(i);
			}		
		}		
	} // printImports()	
		
	protected void printClass(PrintWriter outputStream, Table t, String className) {
		outputStream.println("\r");
		if (annotationType != null) {
			String a = annotationType.getClassAnnotation(t);
			if (a != null) {
				outputStream.println(a);
			}
		}
		outputStream.println("public class " + className
				+ " implements Serializable {");

		
	} // printClass
	
	protected void printAttributes(PrintWriter outputStream, Table t) {
		List<Column> columns = t.getColumns();

		for (Column c : columns) {
			if (annotationType != null) {
				outputStream.println("\r");

				String a = annotationType.getAttributeAnnotation(c);
				if (a != null) {
					outputStream.println("\t" + a);			
				}
			}

			outputStream.println(buildAttributeStatement(c));
		}
	}

	protected void printGetterSetters(PrintWriter outputStream, Table t) {
		outputStream.println("\r");

		List<Column> columns = t.getColumns();

		for (Column c : columns) {
			if (annotationType != null) {
				outputStream.println("\r");
	
				String a = annotationType.getGetterMethodAnnotation(c);
				if (a != null) {
					outputStream.println("\t" + a);			
				}
			}
			outputStream.println(buildGetStatement(c));

			outputStream.println(buildSetStatement(c));
		}

	}

	protected void printToString(PrintWriter outputStream, Table t) {
		outputStream.println(buildToString(t));
		
	}

	protected void printFooter(PrintWriter outputStream, Table t) {

		outputStream.println("} // class " + t.getClassName());
		outputStream.close();

	}

	/**
	 * Called to build the Attribute statement based on the Column
	 * 
	 * @param column
	 * @return Attribute statement
	 */
	public String buildAttributeStatement(Column column) {

		StringBuffer result = new StringBuffer();

		result.append("\tpublic  ");
		result.append(column.getJavaType());
		result.append(" m_");
		result.append(column.getMemberName());
		result.append(";");

		return result.toString();

	}

	/**
	 * builds a GET statement based on the Column
	 * 
	 * @param column
	 * @return the get statement string
	 */

	public String buildGetStatement(Column column) {

		StringBuffer result = new StringBuffer();

		result.append("\tpublic ");
		result.append(column.getJavaType());
		result.append(" get");
		result.append(column.getMemberName());
		result.append("( ) { \r");
		result.append("\t\treturn this.m_");
		result.append(column.getMemberName());
		result.append(";");
		result.append("\r\t}");

		return result.toString();
	}

	/**
	 * Called to build a SET based on the Column
	 * 
	 * @param column
	 * @return the set statement string
	 */

	public String buildSetStatement(Column column) {

		StringBuffer result = new StringBuffer();

		result.append("\tpublic void set");
		result.append(column.getMemberName());
		result.append("( ");
		result.append(column.getJavaType());
		result.append(" ");
		result.append(column.getName());
		result.append(") { \r\t\t this.m_");
		result.append(column.getMemberName());
		result.append(" = ");
		result.append(column.getName());
		result.append("; \r\t}");

		return result.toString();
	}

	/**
	 * Called to build the toString based on the Table
	 * 
	 * @param table
	 * @return the set statement string
	 */

	public String buildToString(Table table) {

		StringBuffer result = new StringBuffer();
		result.append("\tpublic String toString()  {\n\t\tStringBuffer output = new StringBuffer();\n");

		List<Column> columns = table.getColumns();

		for (Column c : columns) {

			result.append("\t\toutput.append(\"" + c.getName() + ":\");\n");
			result.append("\t\toutput.append(get" + c.getMemberName() + "());\n");
			result.append("\t\toutput.append(\"\\n\");\n");

		}

		result.append("\n\t\treturn output.toString();\n\t}\n");

		return result.toString();
	}
}
