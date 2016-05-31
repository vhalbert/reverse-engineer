/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.core.types;

import org.eclipse.emf.ecore.EObject;
import org.teiid.core.designer.ModelerCoreException;

/**
 * DatatypeManager
 *
 * @since 8.0
 */
public interface DatatypeManager {

    /**
     * Return the runtime type java class name associated with the datatype having the specified identifier or null if no datatype
     * with this identifier exists. The identifier may be in the form of a URI reference constructed as follows:
     * <p>
     * 1. the base URI of the XML Schema namespace 2. the fragment identifier defining the name of the datatype
     * </p>
     * or may represent the string form of an <code>ObjectID</code>
     * 
     * @param the unique identifier of the datatype; may not be null.
     * @return the name of the java class or null if the it does not exist.
     */
    String getRuntimeTypeJavaClassName( String id ) throws ModelerCoreException;

    /**import org.teiid.core.designer.id.ObjectID;
     * Return the name of the runtime type associated with the datatype having the specified identifier or null if no datatype
     * with this identifier exists. The identifier may be in the form of a URI reference constructed as follows:
     * <p>
     * 1. the base URI of the XML Schema namespace 2. the fragment identifier defining the name of the datatype
     * </p>
     * or may represent the string form of an <code>ObjectID</code>
     * 
     * @param the unique identifier of the datatype; may not be null.
     * @return the name of the runtime type or null if the runtime type does not exist.
     */
    String getRuntimeTypeName( String id ) throws ModelerCoreException;

    /**
     * Return the name of the runtime type associated with the specified datatype.
     * 
     * @param the datatype whose runtime type is requested; may not be null
     * @return the name of the runtime data access or null if the runtime type does not exist.
     */
    String getRuntimeTypeName( EObject datatype );

 
}