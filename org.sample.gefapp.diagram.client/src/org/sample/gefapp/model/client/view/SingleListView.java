package org.sample.gefapp.model.client.view;

import org.sample.gefapp.model.client.presenter.FeatureEditPresenter.ViewEventHandler;
import org.sample.gefapp.model.client.presenter.FeatureListEditPresenter.View;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * @generated
 */
public  class SingleListView extends Composite implements View {

	interface Binder extends UiBinder<Widget, SingleListView> {}
	
	private static Binder uiBinder = GWT.create(Binder.class);
	
	@UiField Label label;
	
	@UiField ListBox list;
	
	public SingleListView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public void addEventHandler(final ViewEventHandler handler) {
		getListBox().addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				handler.update(getListBox().getSelectedIndex());
			}
		});
	}
	
	@Override
	public Label getLabel() {
		return label;
	}
	
	@Override
	public Widget getEditWidget() {
		return list;
	}
	
	@Override
	public int getColSpan() {
		return 1;
	}
	
	@Override
	public ListBox getListBox() {
		return list;
	}
	
	@Override
	public void setValue(Object value) {
		// TODO Auto-generated method stub
		
	}

}
