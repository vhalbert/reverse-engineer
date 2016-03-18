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
package org.teiid.reverseeng;

import java.sql.Connection;
import java.util.Collection;

import org.teiid.reverseeng.api.MetadataProcessor;
import org.teiid.reverseeng.metadata.db.DBMetadataProcessor;
import org.teiid.reverseeng.metadata.db.DBOptions;
import org.teiid.reverseeng.metadata.designer.RelationalMetadataProcessor;
import org.teiid.reverseeng.pojo.PojoProcessing;

/**
 * @author vanhalbert
 *
 */
public class ReverseEngineerFactory {
	
	private static Collection<Exception> errors;

	/** 
	 * Call to reverse engineer from a database connection
	 * @param connection
	 * @param options
	 * @return boolean indicator if the process was success, return <code>false</code> then check for errors
	 * @throws Exception
	 */
	public static boolean perform(Connection connection, DBOptions options) throws Exception {
		    
		errors = null;
	
		
	  MetadataProcessor metadata = new DBMetadataProcessor(); 
			  
	  metadata.loadMetadata(connection, options);
  	
	  PojoProcessing tp = new PojoProcessing(options);
	  boolean success = tp.processTables(metadata);
	  
	  if (!success) checkErrors(tp);
	  
	  return success;
	} 
	
	/**
	 * Call to reverse engineer from a Teiid Designer table metadata object
	 * @param table
	 * @param options
	 * @return boolean indicator if the process was success, return <code>false</code> then check for errors
	 * @throws Exception
	 */
	public static boolean perform(org.teiid.designer.metamodels.relational.Table table, Options options) throws Exception {
	    errors = null;
	    
		  MetadataProcessor metadata = new RelationalMetadataProcessor();
		  metadata.loadMetadata(table, options);
	  	
		  PojoProcessing tp = new PojoProcessing(options);
		  boolean success = tp.processTables(metadata);

		  if (!success) checkErrors(tp);
		  
		  return success;

	} 
	
	public static Collection<Exception> getErrors() {
		return errors;
	}

	
	private static void checkErrors(PojoProcessing pp) {
		  errors = pp.getExceptions();
//		  for (Exception e : errors) {
//			  System.err.println("***********************************");
//			  System.err.println(e);
//			  System.err.println("***********************************");
//		  }
	}

}
