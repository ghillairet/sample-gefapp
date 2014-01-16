package org.sample.gefapp.model.client.view;

import org.sample.gefapp.model.client.presenter.FeatureEditPresenter.View;
import org.sample.gefapp.model.client.presenter.FeatureEditPresenter.ViewEventHandler;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * @generated
 */
public  class TextView extends Composite implements View {

	interface Binder extends UiBinder<Widget, TextView> {}
	
	private static Binder uiBinder = GWT.create(Binder.class);
	
	@UiField Label label;
	
	@UiField TextBox text;
	
	public TextView() {
		initWidget(uiBinder.createAndBindUi(this));
		label.setWordWrap(false);
	}
	
	@Override
	public void addEventHandler(final ViewEventHandler handler) {
		text.addValueChangeHandler(new ValueChangeHandler<String>() {
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				handler.update(event.getValue());
			}
		});
	}
	
	@Override
	public void setValue(Object value) {
		if (value instanceof String)
			text.setValue((String) value);
	}
	
	@Override
	public Label getLabel() {
		return label;
	}
	
	@Override
	public int getColSpan() {
		return 1;
	}
	
	@Override
	public Widget getEditWidget() {
		return text;
	}

}
