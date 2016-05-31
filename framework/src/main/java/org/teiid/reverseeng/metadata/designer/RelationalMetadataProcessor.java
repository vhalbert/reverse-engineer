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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.EList;
import org.teiid.core.TeiidException;
import org.teiid.reverseeng.Options;
import org.teiid.reverseeng.api.Column;
import org.teiid.reverseeng.api.MetadataProcessor;
import org.teiid.reverseeng.api.Table;
import org.teiid.designer.core.types.*;
import org.teiid.designer.metamodels.relational.NullableType;
/**
 * @author vanhalbert
 *
 */
public final class RelationalMetadataProcessor implements MetadataProcessor {

	private DatatypeManager dataTypeMgr = null;
	private List<Table> tableMetadata = new ArrayList<Table>();
	
	public RelationalMetadataProcessor(DatatypeManager dataTypeMgr) {
		super();
		this.dataTypeMgr = dataTypeMgr;
	}
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
		
		@SuppressWarnings("unchecked")
		EList<org.teiid.designer.metamodels.relational.Column> columns = table.getColumns();
		for( org.teiid.designer.metamodels.relational.Column col : columns ) {
			if (col.isSelectable()) {
				addColumn(col, reltable);
			}
		}		
			
	}
	
	
	/**
	 * Add a column to the given table based upon the current Column
	 * @param column
	 * @param reltable 
	 */
	private void addColumn(org.teiid.designer.metamodels.relational.Column column, Table reltable)  {

		Column relcolumn = reltable.createColumn(column.getName());
		
//		relcolumn.setType(column.getType().);
		relcolumn.setTypeName(dataTypeMgr.getRuntimeTypeName(column.getType()));
//		relcolumn.setOrder(column.getOrder());
		relcolumn.setPrecision(column.getPrecision());
		relcolumn.setMaxLength(column.getLength());
		relcolumn.setScale(column.getScale());
		
//		NullType nt = new NullType(column.getNullable().getValue());
//		relcolumn.setNullType(new NullType());
			
//		relcolumn.setRemarks(column.getRemarks());
		
		relcolumn.setDefaultValue(column.getDefaultValue());
//		relcolumn.setIsIndexed(column.isIndexed());
		
		relcolumn.setIsRequired( column.getNullable().equals(NullableType.NO_NULLS_LITERAL)  ); 
		
	}
	
	private void getRuntimeTypeName(EObject o) {
		String runtimeTypeName = dataTypeMgr.getRuntimeTypeName(o);
	}

}
