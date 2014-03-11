package org.sample.gefapp.entities.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;

import org.eclipse.swt.SWT;

import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.palette.PaletteViewerProvider;


/**
 * @generated
 */
public  class PaletteView extends Composite {

	interface Binder extends UiBinder<Widget, PaletteView> {}
	
	private static Binder uiBinder = GWT.create(Binder.class);
	
	@UiField HTMLPanel palettePanel;
	
	private final org.eclipse.swt.widgets.Composite paletteComposite;
	
	public PaletteView() {
		initWidget(uiBinder.createAndBindUi(this));
		paletteComposite = new org.eclipse.swt.widgets.Composite(null, SWT.NONE);
	}
	
	public void setPalette(PaletteRoot paletteRoot, PaletteViewerProvider provider) {
		PaletteViewer paletteViewer = provider.createPaletteViewer(paletteComposite);
		paletteViewer.setContents(paletteRoot);
		paletteComposite.setSize(120, 200);
		
		Widget widget = paletteComposite.getGwtWidget();		
		palettePanel.add(widget);
	}

}
