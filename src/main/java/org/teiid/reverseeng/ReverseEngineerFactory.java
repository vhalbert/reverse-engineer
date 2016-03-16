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
	
	/** 
	 * Call to reverse engineer from a database connection
	 * @param connection
	 * @param options
	 * @throws Exception
	 */
	public static void perform(Connection connection, DBOptions options) throws Exception {
		    
	  MetadataProcessor metadata = DBMetadataProcessor.loadMetadata(connection, options);
  	
	  PojoProcessing tp = new PojoProcessing(options);
	  boolean success = tp.processTables(metadata);
	  
	  if (!success) checkErrors(tp);
	  
	} 
	
	/**
	 * Call to reverse engineer from a Teiid Designer table metadata object
	 * @param table
	 * @param options
	 * @throws Exception
	 */
	public static void perform(org.teiid.designer.metamodels.relational.Table table, Options options) throws Exception {
	    
		  MetadataProcessor metadata = RelationalMetadataProcessor.loadMetadata(table, options);
	  	
		  PojoProcessing tp = new PojoProcessing(options);
		  boolean success = tp.processTables(metadata);

		  if (!success) checkErrors(tp);

	} 
	
	private static void checkErrors(PojoProcessing pp) {
		  Collection<Exception> errors = pp.getExceptions();
		  for (Exception e : errors) {
			  System.err.println("***********************************");
			  System.err.println(e);
			  System.err.println("***********************************");
		  }
	}

}
