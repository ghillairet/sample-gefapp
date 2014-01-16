package org.sample.gefapp.model.client.view;

import org.sample.gefapp.model.client.presenter.AppController;
import org.sample.gefapp.model.client.presenter.AppController.ControlView;

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
	
//	@UiField SidebarView sideBarPanel;
	
	@UiField DiagramView diagramPanel;
	
	@UiField DiagramControlView controlPanel;
	
	public AppView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public DiagramView getDiagramView() {
		return diagramPanel;
	}
	
//	@Override
//	public SidebarView getSidebarView() {
//		return sideBarPanel;
//	}

	public ControlView getControlView() {
		return controlPanel;
	}

}
