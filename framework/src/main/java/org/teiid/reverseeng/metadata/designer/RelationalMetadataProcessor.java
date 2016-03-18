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
package org.teiid.reverseeng.metadata.designer;

import java.util.ArrayList;
import java.util.List;

import org.teiid.core.TeiidException;
import org.teiid.reverseeng.Options;
import org.teiid.reverseeng.api.Column;
import org.teiid.reverseeng.api.MetadataProcessor;
import org.teiid.reverseeng.api.Table;
/**
 * @author vanhalbert
 *
 */
public final class RelationalMetadataProcessor implements MetadataProcessor {

	private List<Table> tableMetadata = new ArrayList<Table>();
	
	@Override
	public List<org.teiid.reverseeng.api.Table> getTableMetadata() {
		return this.tableMetadata;
	}
	
	
	@Override
	public void loadMetadata( Object metadataSource, Options options) throws TeiidException {
		performLoad( (org.teiid.designer.metamodels.relational.Table) metadataSource, options);
	}
		
	private void performLoad(org.teiid.designer.metamodels.relational.Table table, Options options) throws TeiidException {
		
		Table reltable = new Table(table.getName());
		
		List<Column> columns = table.getColumns();
		for( Column col : columns ) {
			addColumn(col, reltable);
		}		
			
	}
	
	
	/**
	 * Add a column to the given table based upon the current Column
	 * @param column
	 * @param reltable 
	 */
	private void addColumn(Column column, Table reltable)  {

		Column relcolumn = reltable.createColumn(column.getName());
		
		relcolumn.setType(column.getType());
		relcolumn.setTypeName(column.getTypeName());
		relcolumn.setOrder(column.getOrder());
		relcolumn.setPrecision(column.getPrecision());
		relcolumn.setMaxLength(column.getMaxLength());
		relcolumn.setScale(column.getScale());
		
		relcolumn.setNullType(column.getNullType());
			
		relcolumn.setRemarks(column.getRemarks());
		
		relcolumn.setDefaultValue(column.getDefaultValue());
		relcolumn.setIsIndexed(column.isIndexed());
		
		relcolumn.setIsRequired( column.isRequired()  ); 
		
	}

}
