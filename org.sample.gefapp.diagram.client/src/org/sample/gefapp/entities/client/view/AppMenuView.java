package org.sample.gefapp.entities.client.view;

import org.sample.gefapp.entities.client.presenter.AppController;

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
public  class AppMenuView extends Composite implements AppController.MenuView {

	interface Binder extends UiBinder<Widget, AppMenuView> {}
	
	private static Binder uiBinder = GWT.create(Binder.class);
	
	
	/**
	 * @generated
	 */
	@UiField HTMLPanel menuButton;
	
	
	/**
	 * @generated
	 */
	@UiField HTMLPanel paletteButton;
	
	
	/**
	 * @generated
	 */
	@UiField HTMLPanel propertyButton;
	
	
	/**
	 * @generated
	 */
	@UiField HTMLPanel deleteButton;
	
	
	/**
	 * @generated
	 */
	@UiField HTMLPanel undoButton;
	
	
	/**
	 * @generated
	 */
	@UiField HTMLPanel redoButton;
	
	
	/**
	 * @generated
	 */
	@UiField HTMLPanel zoomInButton;
	
	
	/**
	 * @generated
	 */
	@UiField HTMLPanel zoomOutButton;
	
	public AppMenuView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	
	/**
	 * @generated
	 */
	@Override
	public void addControlViewHandler(final AppController.MenuViewHandler handler) {
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
