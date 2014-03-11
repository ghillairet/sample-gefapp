package org.sample.gefapp.entities.client.events;

import org.eclipse.emf.ecore.resource.Resource;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;



/**
 * @generated
 */
public  class OpenDiagramEvent extends GwtEvent<org.sample.gefapp.entities.client.events.OpenDiagramEvent.OpenDiagramEventHandler> {

	
	/**
	 * @generated
	 */
	public interface OpenDiagramEventHandler extends EventHandler {
		
		/**
		 * @generated
		 */
		void onOpen(org.sample.gefapp.entities.client.events.OpenDiagramEvent event);
	}
	
	
	/**
	 * @generated
	 */
	public static Type<org.sample.gefapp.entities.client.events.OpenDiagramEvent.OpenDiagramEventHandler> TYPE = new Type<org.sample.gefapp.entities.client.events.OpenDiagramEvent.OpenDiagramEventHandler>();
	
	
	/**
	 * @generated
	 */
	public final Resource resource;
	
	
	/**
	 * @generated
	 */
	public OpenDiagramEvent(Resource resource) {
		this.resource = resource;
	}
	
	
	/**
	 * @generated
	 */
	@Override
	public GwtEvent.Type<org.sample.gefapp.entities.client.events.OpenDiagramEvent.OpenDiagramEventHandler> getAssociatedType() {
		return TYPE;
	}
	
	
	/**
	 * @generated
	 */
	@Override
	protected void dispatch(org.sample.gefapp.entities.client.events.OpenDiagramEvent.OpenDiagramEventHandler handler) {
		handler.onOpen(this);
	}

}
