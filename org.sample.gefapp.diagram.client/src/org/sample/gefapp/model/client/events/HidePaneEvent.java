package org.sample.gefapp.model.client.events;

import org.sample.gefapp.model.client.presenter.AppController.Panes;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;


/**
 * @generated
 */
public  class HidePaneEvent extends GwtEvent<org.sample.gefapp.model.client.events.HidePaneEvent.HidePaneEventHandler> {

	/**
	 * @generated
	 */
	public final Panes pane;
	
	/**
	 * @generated
	 */
	public HidePaneEvent(Panes pane) {
		this.pane = pane;
	}
	
	/**
	 * @generated
	 */
	public interface HidePaneEventHandler extends EventHandler {
		/**
		 * @generated
		 */
		void hide(org.sample.gefapp.model.client.events.HidePaneEvent e);
	}
	
	/**
	 * @generated
	 */
	public static Type<org.sample.gefapp.model.client.events.HidePaneEvent.HidePaneEventHandler> TYPE = new Type<org.sample.gefapp.model.client.events.HidePaneEvent.HidePaneEventHandler>();
	
	/**
	 * @generated
	 */
	@Override
	public GwtEvent.Type<org.sample.gefapp.model.client.events.HidePaneEvent.HidePaneEventHandler> getAssociatedType() {
		return TYPE;
	}
	
	/**
	 * @generated
	 */
	@Override
	protected void dispatch(org.sample.gefapp.model.client.events.HidePaneEvent.HidePaneEventHandler handler) {
		handler.hide(this);
	}

}
