package org.sample.gefapp.model.client.view;

import java.util.List;

import org.sample.gefapp.model.client.presenter.FeatureEditPresenter;
import org.sample.gefapp.model.client.presenter.PropertySheetPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @generated
 */
public  class PropertySheetSectionView extends Composite implements PropertySheetPresenter.SectionView {

	interface Binder extends UiBinder<Widget, PropertySheetSectionView> {}
	
	private static Binder uiBinder = GWT.create(Binder.class);
	
	@UiField HTMLPanel layout;
	
	public PropertySheetSectionView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public void setContent(List<FeatureEditPresenter.View> items) {
		layout.clear();
	
		for (FeatureEditPresenter.View item: items) {
			layout.add(item.asWidget());
		}
	}

}
