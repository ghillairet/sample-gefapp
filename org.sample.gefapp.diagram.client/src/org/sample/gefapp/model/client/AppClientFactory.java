package org.sample.gefapp.model.client;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.gmf.runtime.gwt.client.DefaultClientFactory;
import org.eclipselabs.emfjson.gwt.handlers.LocalStorageHandler;
import org.sample.gefapp.entities.provider.EntitiesItemProviderAdapterFactory;

/**
 * @generated
 */
public class AppClientFactory extends DefaultClientFactory {
	/**
	 * @generated
	 */
	@Override
	public ComposedAdapterFactory getComposedAdapterFactory() {
		ComposedAdapterFactory factory = super.getComposedAdapterFactory();
		factory.addAdapterFactory(new EntitiesItemProviderAdapterFactory());
		return factory;
	}

	/**
	 * @generated
	 */
	@Override
	public ResourceSet getResourceSet() {
		ResourceSet rs = super.getResourceSet();
		rs.getURIConverter().getURIHandlers().add(0, new LocalStorageHandler());
		return rs;
	}

}
