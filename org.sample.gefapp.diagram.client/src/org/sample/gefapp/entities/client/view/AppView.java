package org.sample.gefapp.entities.client.view;

import org.sample.gefapp.entities.client.presenter.AppController;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;


/**
 * @generated
 */
public  class AppView extends Composite implements AppController.View {

	interface Binder extends UiBinder<Widget, AppView> {}
	
	private static Binder uiBinder = GWT.create(Binder.class);
	
	@UiField AppController.MenuView controlPanel;
	
	@UiField DiagramView diagramPanel;
	
	public AppView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public DiagramView getDiagramView() {
		return diagramPanel;
	}
	
	@Override
	public AppController.MenuView getMenuView() {
		return controlPanel;
	}

}
