/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.metamodels.relational;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.teiid.designer.metamodels.relational.RelationalEntity#getName <em>Name</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.RelationalEntity#getNameInSource <em>Name In Source</em>}</li>
 * </ul>
 * </p>
 *
 * @model abstract="true"
 * @generated
 *
 * @since 8.0
 */
public interface RelationalEntity extends EObject{
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.RelationalEntity#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Name In Source</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name In Source</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name In Source</em>' attribute.
     * @see #setNameInSource(String)
     * @model
     * @generated
     */
    String getNameInSource();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.RelationalEntity#getNameInSource <em>Name In Source</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name In Source</em>' attribute.
     * @see #getNameInSource()
     * @generated
     */
    void setNameInSource(String value);

} // RelationalEntity
