package org.sample.gefapp.entities.client;

import org.eclipse.gmf.runtime.gwt.client.ClientFactory;
import org.sample.gefapp.entities.client.presenter.AppController;
import org.sample.gefapp.entities.client.view.AppView;

import com.google.gwt.user.client.ui.RootPanel;

/**
 * @generated
 */
public class AppEntryPoint {

	/**
	 * @generated
	 */
	public void onModuleLoad() {
		ClientFactory clientFactory = com.google.gwt.core.client.GWT
				.create(ClientFactory.class);
		AppView view = new AppView();

		new AppController(clientFactory.getEventBus(), clientFactory, view)
				.goTo(RootPanel.get());
	}

}
