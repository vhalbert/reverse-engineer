/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.metamodels.relational;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#getNativeType <em>Native Type</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#getLength <em>Length</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#isFixedLength <em>Fixed Length</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#getPrecision <em>Precision</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#getScale <em>Scale</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#getNullable <em>Nullable</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#isAutoIncremented <em>Auto Incremented</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#getMinimumValue <em>Minimum Value</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#getMaximumValue <em>Maximum Value</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#getFormat <em>Format</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#getCharacterSetName <em>Character Set Name</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#getCollationName <em>Collation Name</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#isSelectable <em>Selectable</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#isUpdateable <em>Updateable</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#isCaseSensitive <em>Case Sensitive</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#getSearchability <em>Searchability</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#isCurrency <em>Currency</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#getRadix <em>Radix</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#isSigned <em>Signed</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#getDistinctValueCount <em>Distinct Value Count</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#getNullValueCount <em>Null Value Count</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#getUniqueKeys <em>Unique Keys</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#getIndexes <em>Indexes</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#getForeignKeys <em>Foreign Keys</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#getAccessPatterns <em>Access Patterns</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.teiid.designer.metamodels.relational.Column#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @model
 * @generated
 *
 * @since 8.0
 */
public interface Column extends RelationalEntity{
    /**
     * Returns the value of the '<em><b>Native Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Native Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Native Type</em>' attribute.
     * @see #isSetNativeType()
     * @see #unsetNativeType()
     * @see #setNativeType(String)
     * @model unsettable="true"
     * @generated
     */
    String getNativeType();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#getNativeType <em>Native Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Native Type</em>' attribute.
     * @see #isSetNativeType()
     * @see #unsetNativeType()
     * @see #getNativeType()
     * @generated
     */
    void setNativeType(String value);

    /**
     * Unsets the value of the '{@link org.teiid.designer.metamodels.relational.Column#getNativeType <em>Native Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetNativeType()
     * @see #getNativeType()
     * @see #setNativeType(String)
     * @generated
     */
    void unsetNativeType();

    /**
     * Returns whether the value of the '{@link org.teiid.designer.metamodels.relational.Column#getNativeType <em>Native Type</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Native Type</em>' attribute is set.
     * @see #unsetNativeType()
     * @see #getNativeType()
     * @see #setNativeType(String)
     * @generated
     */
    boolean isSetNativeType();

    /**
     * Returns the value of the '<em><b>Length</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Length</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Length</em>' attribute.
     * @see #setLength(int)
     * @model
     * @generated
     */
    int getLength();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#getLength <em>Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Length</em>' attribute.
     * @see #getLength()
     * @generated
     */
    void setLength(int value);

    /**
     * Returns the value of the '<em><b>Fixed Length</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Fixed Length</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Fixed Length</em>' attribute.
     * @see #setFixedLength(boolean)
     * @model
     * @generated
     */
    boolean isFixedLength();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#isFixedLength <em>Fixed Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Fixed Length</em>' attribute.
     * @see #isFixedLength()
     * @generated
     */
    void setFixedLength(boolean value);

    /**
     * Returns the value of the '<em><b>Precision</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Precision</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Precision</em>' attribute.
     * @see #setPrecision(int)
     * @model
     * @generated
     */
    int getPrecision();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#getPrecision <em>Precision</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Precision</em>' attribute.
     * @see #getPrecision()
     * @generated
     */
    void setPrecision(int value);

    /**
     * Returns the value of the '<em><b>Scale</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Scale</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Scale</em>' attribute.
     * @see #setScale(int)
     * @model
     * @generated
     */
    int getScale();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#getScale <em>Scale</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Scale</em>' attribute.
     * @see #getScale()
     * @generated
     */
    void setScale(int value);

    /**
     * Returns the value of the '<em><b>Nullable</b></em>' attribute.
     * The default value is <code>"NULLABLE"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Nullable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Nullable</em>' attribute.
     * @model default="NULLABLE"
     * @generated
     */
    NullableType getNullable();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#getNullable <em>Nullable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Nullable</em>' attribute.
     * @see #getNullable()
     * @generated
     */
    void setNullable(NullableType value);

    /**
     * Returns the value of the '<em><b>Auto Incremented</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Auto Incremented</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Auto Incremented</em>' attribute.
     * @see #setAutoIncremented(boolean)
     * @model default="false"
     * @generated
     */
    boolean isAutoIncremented();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#isAutoIncremented <em>Auto Incremented</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Auto Incremented</em>' attribute.
     * @see #isAutoIncremented()
     * @generated
     */
    void setAutoIncremented(boolean value);

    /**
     * Returns the value of the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Value</em>' attribute.
     * @see #setDefaultValue(String)
     * @model
     * @generated
     */
    String getDefaultValue();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#getDefaultValue <em>Default Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Value</em>' attribute.
     * @see #getDefaultValue()
     * @generated
     */
    void setDefaultValue(String value);

    /**
     * Returns the value of the '<em><b>Minimum Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Minimum Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Minimum Value</em>' attribute.
     * @see #setMinimumValue(String)
     * @model
     * @generated
     */
    String getMinimumValue();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#getMinimumValue <em>Minimum Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Minimum Value</em>' attribute.
     * @see #getMinimumValue()
     * @generated
     */
    void setMinimumValue(String value);

    /**
     * Returns the value of the '<em><b>Maximum Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Maximum Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Maximum Value</em>' attribute.
     * @see #setMaximumValue(String)
     * @model
     * @generated
     */
    String getMaximumValue();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#getMaximumValue <em>Maximum Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Maximum Value</em>' attribute.
     * @see #getMaximumValue()
     * @generated
     */
    void setMaximumValue(String value);

    /**
     * Returns the value of the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Format</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Format</em>' attribute.
     * @see #setFormat(String)
     * @model
     * @generated
     */
    String getFormat();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#getFormat <em>Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Format</em>' attribute.
     * @see #getFormat()
     * @generated
     */
    void setFormat(String value);

    /**
     * Returns the value of the '<em><b>Character Set Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Character Set Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Character Set Name</em>' attribute.
     * @see #setCharacterSetName(String)
     * @model
     * @generated
     */
    String getCharacterSetName();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#getCharacterSetName <em>Character Set Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Character Set Name</em>' attribute.
     * @see #getCharacterSetName()
     * @generated
     */
    void setCharacterSetName(String value);

    /**
     * Returns the value of the '<em><b>Collation Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Collation Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Collation Name</em>' attribute.
     * @see #setCollationName(String)
     * @model
     * @generated
     */
    String getCollationName();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#getCollationName <em>Collation Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Collation Name</em>' attribute.
     * @see #getCollationName()
     * @generated
     */
    void setCollationName(String value);

    /**
     * Returns the value of the '<em><b>Selectable</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Selectable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Selectable</em>' attribute.
     * @see #setSelectable(boolean)
     * @model default="true"
     * @generated
     */
    boolean isSelectable();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#isSelectable <em>Selectable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Selectable</em>' attribute.
     * @see #isSelectable()
     * @generated
     */
    void setSelectable(boolean value);

    /**
     * Returns the value of the '<em><b>Updateable</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Updateable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Updateable</em>' attribute.
     * @see #setUpdateable(boolean)
     * @model default="true"
     * @generated
     */
    boolean isUpdateable();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#isUpdateable <em>Updateable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Updateable</em>' attribute.
     * @see #isUpdateable()
     * @generated
     */
    void setUpdateable(boolean value);

    /**
     * Returns the value of the '<em><b>Case Sensitive</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Case Sensitive</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Case Sensitive</em>' attribute.
     * @see #setCaseSensitive(boolean)
     * @model default="true"
     * @generated
     */
    boolean isCaseSensitive();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#isCaseSensitive <em>Case Sensitive</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Case Sensitive</em>' attribute.
     * @see #isCaseSensitive()
     * @generated
     */
    void setCaseSensitive(boolean value);

    /**
     * Returns the value of the '<em><b>Searchability</b></em>' attribute.
     * The default value is <code>"SEARCHABLE"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Searchability</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Searchability</em>' attribute.
     * @model default="SEARCHABLE"
     * @generated
     */
    SearchabilityType getSearchability();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#getSearchability <em>Searchability</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Searchability</em>' attribute.
     * @see #getSearchability()
     * @generated
     */
    void setSearchability(SearchabilityType value);

    /**
     * Returns the value of the '<em><b>Currency</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Currency</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Currency</em>' attribute.
     * @see #setCurrency(boolean)
     * @model
     * @generated
     */
    boolean isCurrency();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#isCurrency <em>Currency</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Currency</em>' attribute.
     * @see #isCurrency()
     * @generated
     */
    void setCurrency(boolean value);

    /**
     * Returns the value of the '<em><b>Radix</b></em>' attribute.
     * The default value is <code>"10"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Radix</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Radix</em>' attribute.
     * @see #setRadix(int)
     * @model default="10"
     * @generated
     */
    int getRadix();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#getRadix <em>Radix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Radix</em>' attribute.
     * @see #getRadix()
     * @generated
     */
    void setRadix(int value);

    /**
     * Returns the value of the '<em><b>Signed</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Signed</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Signed</em>' attribute.
     * @see #setSigned(boolean)
     * @model default="true"
     * @generated
     */
    boolean isSigned();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#isSigned <em>Signed</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Signed</em>' attribute.
     * @see #isSigned()
     * @generated
     */
    void setSigned(boolean value);

    /**
     * Returns the value of the '<em><b>Distinct Value Count</b></em>' attribute.
     * The default value is <code>"-1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Distinct Value Count</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Distinct Value Count</em>' attribute.
     * @see #setDistinctValueCount(int)
     * @model default="-1"
     * @generated
     */
    int getDistinctValueCount();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#getDistinctValueCount <em>Distinct Value Count</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Distinct Value Count</em>' attribute.
     * @see #getDistinctValueCount()
     * @generated
     */
    void setDistinctValueCount(int value);

    /**
     * Returns the value of the '<em><b>Null Value Count</b></em>' attribute.
     * The default value is <code>"-1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Null Value Count</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Null Value Count</em>' attribute.
     * @see #setNullValueCount(int)
     * @model default="-1"
     * @generated
     */
    int getNullValueCount();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#getNullValueCount <em>Null Value Count</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Null Value Count</em>' attribute.
     * @see #getNullValueCount()
     * @generated
     */
    void setNullValueCount(int value);

    /**
     * Returns the value of the '<em><b>Unique Keys</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Unique Keys</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Unique Keys</em>' reference list.
     * @model type="org.teiid.designer.metamodels.relational.UniqueKey" opposite="columns"
     * @generated
     */
    EList getUniqueKeys();

    /**
     * Returns the value of the '<em><b>Indexes</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Indexes</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Indexes</em>' reference list.
     * @model type="org.teiid.designer.metamodels.relational.Index" opposite="columns"
     * @generated
     */
    EList getIndexes();

    /**
     * Returns the value of the '<em><b>Foreign Keys</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Foreign Keys</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Foreign Keys</em>' reference list.
     * @model type="org.teiid.designer.metamodels.relational.ForeignKey" opposite="columns"
     * @generated
     */
    EList getForeignKeys();

    /**
     * Returns the value of the '<em><b>Access Patterns</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Access Patterns</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Access Patterns</em>' reference list.
     * @model type="org.teiid.designer.metamodels.relational.AccessPattern" opposite="columns"
     * @generated
     */
    EList getAccessPatterns();

    /**
     * Returns the value of the '<em><b>Owner</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.teiid.designer.metamodels.relational.ColumnSet#getColumns <em>Columns</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Owner</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Owner</em>' container reference.
     * @see #setOwner(ColumnSet)
     * @see org.teiid.designer.metamodels.relational.ColumnSet#getColumns
     * @model opposite="columns"
     * @generated
     */
    ColumnSet getOwner();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#getOwner <em>Owner</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Owner</em>' container reference.
     * @see #getOwner()
     * @generated
     */
    void setOwner(ColumnSet value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' reference.
     * @see #isSetType()
     * @see #unsetType()
     * @model unsettable="true" required="true"
     * @generated
     */
    EObject getType();

    /**
     * Sets the value of the '{@link org.teiid.designer.metamodels.relational.Column#getType <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' reference.
     * @see #isSetType()
     * @see #unsetType()
     * @see #getType()
     * @generated
     */
    void setType(EObject value);

    /**
     * Unsets the value of the '{@link org.teiid.designer.metamodels.relational.Column#getType <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetType()
     * @see #getType()
     * @generated
     */
    void unsetType();

    /**
     * Returns whether the value of the '{@link org.teiid.designer.metamodels.relational.Column#getType <em>Type</em>}' reference is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Type</em>' reference is set.
     * @see #unsetType()
     * @see #getType()
     * @generated
     */
    boolean isSetType();

} // Column
