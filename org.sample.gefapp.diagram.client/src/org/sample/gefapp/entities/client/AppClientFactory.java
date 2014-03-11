package org.sample.gefapp.entities.client;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.gmf.runtime.gwt.client.DefaultClientFactory;
import org.eclipselabs.emfjson.gwt.handlers.LocalStorageHandler;
import org.eclipselabs.emfjson.gwt.resource.JsResourceImpl;
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
	public void setupResourceSet(ResourceSet resourceSet) {
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new ResourceFactoryImpl() {
			@Override
			public Resource createResource(URI uri) {
				return new JsResourceImpl(uri);
			}
		});
		resourceSet.getURIConverter().getURIHandlers().add(0, new LocalStorageHandler());
	}
}
