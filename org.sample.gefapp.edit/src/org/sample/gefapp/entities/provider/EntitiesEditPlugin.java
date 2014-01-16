/**
 */
package org.sample.gefapp.entities.provider;

import com.google.gwt.core.client.GWT;

import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.util.ResourceLocator;

/**
 * This is the central singleton for the Entities edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class EntitiesEditPlugin extends EMFPlugin {
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final EntitiesEditPlugin INSTANCE = new EntitiesEditPlugin();

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitiesEditPlugin() {
		super
		  (new ResourceLocator [] {
		   });
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final EntitiesEditPluginProperties PROPERTIES = GWT.create(EntitiesEditPluginProperties.class);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getString(String key, boolean translate) {
		if ("_UI_DomainModel_type".equals(key)) return PROPERTIES.domainModelType();
		else if ("_UI_Entity_type".equals(key)) return PROPERTIES.entityType();
		else if ("_UI_Feature_type".equals(key)) return PROPERTIES.featureType();
		else  if ("_UI_Unknown_type".equals(key)) return PROPERTIES.unknownType();
		else if ("_UI_Unknown_datatype".equals(key)) return PROPERTIES.unknownDatatype();
		else if ("_UI_DomainModel_entities_feature".equals(key)) return PROPERTIES.domainModel_EntitiesFeature();
		else if ("_UI_Entity_name_feature".equals(key)) return PROPERTIES.entity_NameFeature();
		else if ("_UI_Entity_superType_feature".equals(key)) return PROPERTIES.entity_SuperTypeFeature();
		else if ("_UI_Entity_features_feature".equals(key)) return PROPERTIES.entity_FeaturesFeature();
		else if ("_UI_Feature_name_feature".equals(key)) return PROPERTIES.feature_NameFeature();
		else if ("_UI_Feature_many_feature".equals(key)) return PROPERTIES.feature_ManyFeature();
		else if ("_UI_Feature_type_feature".equals(key)) return PROPERTIES.feature_TypeFeature();
		else if ("_UI_Unknown_feature".equals(key)) return PROPERTIES.unknownFeature();
		else return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getString(String key, Object [] substitutions, boolean translate) {
		if ("_UI_CreateChild_text".equals(key)) return PROPERTIES.createChildText(substitutions[0]);
		else if ("_UI_CreateChild_text2".equals(key)) return PROPERTIES.createChildText2(substitutions[0], substitutions[1]);
		else if ("_UI_CreateChild_text3".equals(key)) return PROPERTIES.createChildText3(substitutions[1]);
		else if ("_UI_CreateChild_tooltip".equals(key)) return PROPERTIES.createChildTooltip(substitutions[0], substitutions[1]);
		else if ("_UI_CreateChild_description".equals(key)) return PROPERTIES.createChildDescripition(substitutions[0], substitutions[1], substitutions[2]);
		else if ("_UI_CreateSibling_description".equals(key)) return PROPERTIES.createSiblingDescription(substitutions[0], substitutions[1], substitutions[2]);
		if ("_UI_PropertyDescriptor_description".equals(key)) return PROPERTIES.propertyDescriptorDescription(substitutions[0], substitutions[1]);
		else return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final EntitiesEditPluginImages IMAGES = GWT.create(EntitiesEditPluginImages.class);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(String key) {
		if ("full/obj16/DomainModel".equals(key)) return IMAGES.domainModel();
		else if ("full/obj16/Entity".equals(key)) return IMAGES.entity();
		else if ("full/obj16/Feature".equals(key)) return IMAGES.feature();
		else return key;
	}

}
