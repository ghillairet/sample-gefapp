package org.sample.gefapp.entities.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;

import org.sample.gefapp.entities.client.presenter.PropertySheetPresenter;
import org.sample.gefapp.entities.client.presenter.PropertySheetPresenter.SectionView;


/**
 * @generated
 */
public  class PropertySheetView extends Composite implements PropertySheetPresenter.View {

	interface Binder extends UiBinder<Widget, PropertySheetView> {}
	
	private static Binder uiBinder = GWT.create(Binder.class);
	
	@UiField HTMLPanel panel;
	
	public PropertySheetView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public void add(SectionView section) {
		panel.add(section.asWidget());
	}
	
	@Override
	public void clear() {
		panel.clear();
	}

}
