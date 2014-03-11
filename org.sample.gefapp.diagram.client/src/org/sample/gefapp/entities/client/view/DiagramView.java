package org.sample.gefapp.entities.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.swt.SWT;
import org.sample.gefapp.entities.client.presenter.DiagramPresenter;


/**
 * @generated
 */
public  class DiagramView extends Composite implements DiagramPresenter.View {

	interface Binder extends UiBinder<Widget, DiagramView> {}
	
	private static Binder uiBinder = GWT.create(Binder.class);
	
	
	/**
	 * @generated
	 */
	@UiField HTMLPanel diagramOutterPanel;
	
	
	/**
	 * @generated
	 */
	@UiField HTMLPanel diagramPanel;
	
	
	/**
	 * @generated
	 */
	private final org.eclipse.swt.widgets.Composite viewerComposite;
	
	
	/**
	 * @generated
	 */
	private GraphicalViewer viewer;
	
	public DiagramView() {
		initWidget(uiBinder.createAndBindUi(this));
		viewerComposite = new org.eclipse.swt.widgets.Composite(null, SWT.NONE);
	}
	
	
	/**
	 * @generated
	 */
	@Override
	public void setGraphicalViewer(GraphicalViewer viewer) {
		diagramPanel.clear();
	
		this.viewer = viewer;
		this.viewer.createControl(viewerComposite);
	
		viewerComposite.setSize(1200, 1200);
		diagramPanel.add(viewerComposite.getGwtWidget());
	}

}
