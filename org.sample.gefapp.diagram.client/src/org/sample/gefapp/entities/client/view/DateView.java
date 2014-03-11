package org.sample.gefapp.entities.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import java.util.Date;

import org.sample.gefapp.entities.client.presenter.FeatureEditPresenter.View;
import org.sample.gefapp.entities.client.presenter.FeatureEditPresenter.ViewEventHandler;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.Label;


/**
 * @generated
 */
public  class DateView extends Composite implements View {

	interface Binder extends UiBinder<Widget, DateView> {}
	
	private static Binder uiBinder = GWT.create(Binder.class);
	
	@UiField Label label;
	
	@UiField DateBox date;
	
	public DateView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public void addEventHandler(final ViewEventHandler handler) {
		date.addValueChangeHandler(new ValueChangeHandler<Date>() {
			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				handler.update(event.getValue());
			}
		});
	}
	
	@Override
	public void setValue(Object value) {
		if (value instanceof Date) {
			date.setValue((Date) value);
		}
	}
	
	@Override
	public Label getLabel() {
		return label;
	}
	
	@Override
	public Widget getEditWidget() {
		return date;
	}
	
	@Override
	public int getColSpan() {
		return 1;
	}

}
