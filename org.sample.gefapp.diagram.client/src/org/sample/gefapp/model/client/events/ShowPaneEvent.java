package org.sample.gefapp.model.client.events;

import org.sample.gefapp.model.client.presenter.AppController.Panes;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;


/**
 * @generated
 */
public  class ShowPaneEvent extends GwtEvent<org.sample.gefapp.model.client.events.ShowPaneEvent.ShowPaneEventHandler> {

	/**
	 * @generated
	 */
	public final Panes pane;
	
	/**
	 * @generated
	 */
	public ShowPaneEvent(Panes pane) {
		this.pane = pane;
	}
	
	/**
	 * @generated
	 */
	public interface ShowPaneEventHandler extends EventHandler {
		/**
		 * @generated
		 */
		void show(org.sample.gefapp.model.client.events.ShowPaneEvent event);
	}
	
	/**
	 * @generated
	 */
	public static Type<org.sample.gefapp.model.client.events.ShowPaneEvent.ShowPaneEventHandler> TYPE = new Type<org.sample.gefapp.model.client.events.ShowPaneEvent.ShowPaneEventHandler>();
	
	/**
	 * @generated
	 */
	@Override
	public GwtEvent.Type<org.sample.gefapp.model.client.events.ShowPaneEvent.ShowPaneEventHandler> getAssociatedType() {
		return TYPE;
	}
	
	/**
	 * @generated
	 */
	@Override
	protected void dispatch(org.sample.gefapp.model.client.events.ShowPaneEvent.ShowPaneEventHandler handler) {
		handler.show(this);
	}

}
