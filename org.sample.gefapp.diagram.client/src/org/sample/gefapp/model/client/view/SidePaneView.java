package org.sample.gefapp.model.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @generated
 */
public class SidePaneView extends Composite {

	interface Binder extends UiBinder<Widget, SidePaneView> {}
	
	private static Binder uiBinder = GWT.create(Binder.class);
	
	@UiField HTMLPanel contentPanel;
	
	public SidePaneView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setContent(Widget widget) {
		contentPanel.clear();
		contentPanel.add(widget);
	}

}
