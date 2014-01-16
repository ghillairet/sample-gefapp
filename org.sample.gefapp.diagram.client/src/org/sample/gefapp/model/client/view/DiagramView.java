package org.sample.gefapp.model.client.view;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.swt.SWT;
import org.sample.gefapp.model.client.presenter.DiagramPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @generated
 */
public  class DiagramView extends Composite implements DiagramPresenter.View {

	interface Binder extends UiBinder<Widget, DiagramView> {}
	
	private static Binder uiBinder = GWT.create(Binder.class);
	
	@UiField HTMLPanel diagramOutterPanel;
	
//	@UiField DiagramPresenter.ControlView controlPanel;
	
	@UiField HTMLPanel diagramPanel;
	
	private final org.eclipse.swt.widgets.Composite viewerComposite;
	
	private GraphicalViewer viewer;
	
	public DiagramView() {
		initWidget(uiBinder.createAndBindUi(this));
		viewerComposite = new org.eclipse.swt.widgets.Composite(null, SWT.NONE);
	}
	
	@Override
	public void setGraphicalViewer(GraphicalViewer viewer) {
		diagramPanel.clear();
	
		this.viewer = viewer;
		this.viewer.createControl(viewerComposite);
	
		viewerComposite.setSize(1200, 1200);
		diagramPanel.add(viewerComposite.getGwtWidget());
	}
	
//	@Override
//	public void moveLeft(SidebarPresenter.Panes pane) {
//		Style style = diagramOutterPanel.getElement().getStyle();
//		style.setLeft(40, Unit.PX);
//	}
//	
//	@Override
//	public void moveRight(Panes pane) {
//		Style style = diagramOutterPanel.getElement().getStyle();
//		if (pane.equals(SidebarPresenter.Panes.PALETTE))
//			style.setLeft(pane.getWidth() + 40, Unit.PX);
//		else style.setLeft(pane.getWidth() + 40, Unit.PX);
//	}
	
//	@Override
//	public DiagramPresenter.ControlView getControlView() {
//		return controlPanel;
//	}

}
