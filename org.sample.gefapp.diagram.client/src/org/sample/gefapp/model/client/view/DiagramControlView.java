package org.sample.gefapp.model.client.view;

import org.sample.gefapp.model.client.presenter.AppController;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @generated
 */
public  class DiagramControlView extends Composite implements AppController.ControlView {

	interface Binder extends UiBinder<Widget, DiagramControlView> {}
	
	private static Binder uiBinder = GWT.create(Binder.class);
	
//	@UiField HTMLPanel menuButton;
	@UiField HTMLPanel paletteButton;
	@UiField HTMLPanel propertyButton;

	@UiField HTMLPanel deleteButton;
	@UiField HTMLPanel undoButton;
	@UiField HTMLPanel redoButton;

	@UiField HTMLPanel zoomInButton;
	@UiField HTMLPanel zoomOutButton;
	
	public DiagramControlView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public void addControlViewHandler(final AppController.ControlViewHandler handler) {
		paletteButton.addDomHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				handler.onClickPalette();
			}
		}, ClickEvent.getType());
		
		propertyButton.addDomHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				handler.onClickProperty();
			}
		}, ClickEvent.getType());

		deleteButton.addDomHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				handler.onDelete();
			}
		}, ClickEvent.getType());

		undoButton.addDomHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				handler.onUndo();
			}
		}, ClickEvent.getType());

		redoButton.addDomHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				handler.onRedo();
			}
		}, ClickEvent.getType());

		zoomInButton.addDomHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				handler.onZoomIn();
			}
		}, ClickEvent.getType());

		zoomOutButton.addDomHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				handler.onZoomOut();
			}
		}, ClickEvent.getType());
	}

}
