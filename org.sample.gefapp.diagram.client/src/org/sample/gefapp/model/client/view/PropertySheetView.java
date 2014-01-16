package org.sample.gefapp.model.client.view;

import org.sample.gefapp.model.client.presenter.PropertySheetPresenter;
import org.sample.gefapp.model.client.presenter.PropertySheetPresenter.SectionView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

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
