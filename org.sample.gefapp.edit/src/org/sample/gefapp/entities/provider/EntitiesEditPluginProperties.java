/**
 */
package org.sample.gefapp.entities.provider;

import com.google.gwt.i18n.client.Messages;

/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public interface EntitiesEditPluginProperties extends Messages {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_CreateChild_text")
	@DefaultMessage("{0}")
	String createChildText(Object type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_CreateChild_text2")
	@DefaultMessage("{1} {0}")
	String createChildText2(Object type, Object feature);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_CreateChild_text3")
	@DefaultMessage("{0}")
	String createChildText3(Object feature);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_CreateChild_tooltip")
	@DefaultMessage("Create New {0} Under {1} Feature")
	String createChildTooltip(Object type, Object feature);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_CreateChild_description")
	@DefaultMessage("Create a new child of type {0} for the {1} feature of the selected {2}.")
	String createChildDescripition(Object type, Object feature, Object selection);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_CreateSibling_description")
	@DefaultMessage("Create a new sibling of type {0} for the selected {2}, under the {1} feature of their parent.")
	String createSiblingDescription(Object type, Object feature, Object selection);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_PropertyDescriptor_description")
	@DefaultMessage("The {0} of the {1}")
	String propertyDescriptorDescription(Object feature, Object type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_DomainModel_type")
	@DefaultMessage("Domain Model")
	String domainModelType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Entity_type")
	@DefaultMessage("Entity")
	String entityType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Feature_type")
	@DefaultMessage("Feature")
	String featureType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Unknown_type")
	@DefaultMessage("Object")
	String unknownType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Unknown_datatype")
	@DefaultMessage("Value")
	String unknownDatatype();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_DomainModel_entities_feature")
	@DefaultMessage("Entities")
	String domainModel_EntitiesFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Entity_name_feature")
	@DefaultMessage("Name")
	String entity_NameFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Entity_superType_feature")
	@DefaultMessage("Super Type")
	String entity_SuperTypeFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Entity_features_feature")
	@DefaultMessage("Features")
	String entity_FeaturesFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Feature_name_feature")
	@DefaultMessage("Name")
	String feature_NameFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Feature_many_feature")
	@DefaultMessage("Many")
	String feature_ManyFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Feature_type_feature")
	@DefaultMessage("Type")
	String feature_TypeFeature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Key("_UI_Unknown_feature")
	@DefaultMessage("Unspecified")
	String unknownFeature();

}
