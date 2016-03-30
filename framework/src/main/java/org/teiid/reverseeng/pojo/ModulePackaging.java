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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.teiid.core.TeiidProcessingException;
import org.teiid.core.util.FileUtils;
import org.teiid.core.util.ObjectConverterUtil;
import org.teiid.reverseeng.Options;
import org.teiid.reverseeng.ReverseEngineerPlugin;

/**
 * ModulePackaging will package the created pojo jar into a module zip package for deployment
 *  
 * @author vanhalbert
 *
 */
public class ModulePackaging {
	
	private static final String REMOTE_CACHE_TEMPLATE = "org/teiid/reverseeng/remote_cache_module_template.xml";
	private static final String LIBRARY_MODE_TEMPLATE = "org/teiid/reverseeng/library_mode_module_template.xml";
	private static final String UNKNOWN_TEMPLATE = "org/teiid/reverseeng/unknown_module_template.xml";

	private static final String MODULE = "modules";
	
	public void performPackaging(Options options, String packageName, File pojoJarFile, String moduleZipFileName,  File buildLocation, String packageFilePath, File kitLocation) throws Exception {
		ReverseEngineerPlugin.LOGGER.info("[ReverseEngineering] Starting to package module: " + moduleZipFileName);
		
		if (!pojoJarFile.exists()) {
			throw new TeiidProcessingException(ReverseEngineerPlugin.Util.gs(ReverseEngineerPlugin.Event.POJO_DOESNT_EXIST, pojoJarFile));
		}
	
		// location for module related files
		File moduleRootLocation = new File(buildLocation, MODULE); 
		moduleRootLocation.mkdir();
		
		File moduleDirLoc = new File(moduleRootLocation.getAbsolutePath() + File.separator + packageFilePath.toString());
		moduleDirLoc.mkdirs();
		
		File moduleFile = new File(moduleDirLoc, "module.xml");

		
		String template = null;
		if (options.useHibernateAnnotations()) {
			template = LIBRARY_MODE_TEMPLATE;
		} else if (options.useProtobufAnnotations()) {
			template = REMOTE_CACHE_TEMPLATE;
		} else {
			template = UNKNOWN_TEMPLATE;		
		}
		ReverseEngineerPlugin.LOGGER.debug("[ReverseEngineering] Module template: " + template);
	
		String modTemp = getModuleTemplate(template);
		
		/**
		 * Mappings:
		 * 0 - package name
		 * 1 - pojo jar name
		 */
		
		modTemp = MessageFormat.format(modTemp, packageName, pojoJarFile.getName());
		ReverseEngineerPlugin.LOGGER.debug("[ReverseEngineering] package and pojo jar: " + packageName + "," + pojoJarFile.getName());
		
		ObjectConverterUtil.write(modTemp.getBytes(), moduleFile.getAbsolutePath());
		
		File pojoDest = new File(moduleFile.getParent(), pojoJarFile.getName());

		FileUtils.copy(pojoJarFile.getAbsolutePath(), pojoDest.getAbsolutePath());

		File[] filesInModule = new File[2];  // jar and module files
		filesInModule[0]=pojoDest;
		filesInModule[1]=moduleFile;
		
		
		createZip(filesInModule,moduleZipFileName, MODULE + File.separator + packageFilePath);
		
		ReverseEngineerPlugin.LOGGER.info("[ReverseEngineering] Completed packaging module: " + moduleZipFileName);

		
	}
	
	private String getModuleTemplate(String module_template) throws IOException {
		
		InputStream is = getClass().getClassLoader().getResourceAsStream(module_template);
		
		String modString = ObjectConverterUtil.convertToString(is);
		
		return modString;
		
	}
	
	final static int BUFFER = 2048;
	private void createZip(File[] files, String targetZip, String packageName) {
        byte[] buffer = new byte[BUFFER];

        try{
            
            FileOutputStream    fos = new FileOutputStream(new File(targetZip));
            ZipOutputStream zos = new ZipOutputStream(fos);

			for (int i = 0; i < files.length; i++) {
				if (files[i] == null || !files[i].exists()
						|| files[i].isDirectory())
					continue; // Just in case..

				String fname = packageName + files[i].getName();
				ZipEntry ze= new ZipEntry(fname);
				ze.setTime(files[i].lastModified());
				
				
		        zos.putNextEntry(ze);
		        
		        FileInputStream in = new FileInputStream(files[i].getAbsolutePath());
		        
				while (true) {
					int nRead = in.read(buffer, 0, buffer.length);
					if (nRead <= 0)
						break;
					zos.write(buffer, 0, nRead);
					zos.flush();
				}
                
				in.close();	
				zos.closeEntry();

			}
			
			zos.close();
			fos.close();
	
        }catch(IOException ex){
           ex.printStackTrace();
        }
    
	}

}
