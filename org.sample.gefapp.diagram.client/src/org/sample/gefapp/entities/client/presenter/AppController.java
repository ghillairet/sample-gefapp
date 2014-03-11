package org.sample.gefapp.entities.client.presenter;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.internal.ui.palette.editparts.GroupEditPart;
import org.eclipse.gef.internal.ui.palette.editparts.SliderPaletteEditPart;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.palette.PaletteEditPartFactory;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.palette.PaletteViewerProvider;
import org.eclipse.gmf.runtime.gwt.client.ClientFactory;
import org.eclipse.gmf.runtime.gwt.commands.RemoveNotationalElementCommand;
import org.eclipse.gmf.runtime.gwt.commands.WrappingCommand;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Color;
import org.sample.gefapp.entities.client.events.ShowPaneEvent.ShowPaneEventHandler;
import org.sample.gefapp.entities.client.events.ShowPaneEvent;
import org.sample.gefapp.entities.client.view.DiagramView;
import org.sample.gefapp.entities.client.view.PaletteView;
import org.sample.gefapp.entities.client.view.PropertySheetView;
import org.sample.gefapp.entities.client.view.SidePaneView;
import org.sample.gefapp.entities.diagram.part.EntitiesPaletteFactory;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;


/**
 * @generated
 */
public  class AppController implements Presenter, ValueChangeHandler<String> {

	
	/**
	 * @generated
	 */
	public interface View {
	
		
		/**
		 * @generated
		 */
		DiagramView getDiagramView();
		
		
		/**
		 * @generated
		 */
		MenuView getMenuView();
		
		
		/**
		 * @generated
		 */
		Widget asWidget();
	
	}
	
	
	/**
	 * @generated
	 */
	public interface MenuView {
		
		/**
		 * @generated
		 */
		void addControlViewHandler(MenuViewHandler handler);
	}
	
	
	/**
	 * @generated
	 */
	public interface MenuViewHandler {
	
		
		/**
		 * @generated
		 */
		void onClickCreate();
	
		
		/**
		 * @generated
		 */
		void onClickPalette();
	
		
		/**
		 * @generated
		 */
		void onClickProperty();
	
		
		/**
		 * @generated
		 */
		void onDelete();
	
		
		/**
		 * @generated
		 */
		void onRedo();
	
		
		/**
		 * @generated
		 */
		void onUndo();
	
		
		/**
		 * @generated
		 */
		void onZoomIn();
	
		
		/**
		 * @generated
		 */
		void onZoomOut();
	}
	
	
	/**
	 * @generated
	 */
	private final HandlerManager eventBus;
	
	
	/**
	 * @generated
	 */
	private final ClientFactory clientFactory;
	
	
	/**
	 * @generated
	 */
	private final View view;
	
	
	/**
	 * @generated
	 */
	private org.sample.gefapp.entities.client.presenter.DiagramPresenter diagramPresenter = null;
	
	
	/**
	 * @generated
	 */
	private Panes currentPane = null;
	
	
	/**
	 * @generated
	 */
	private SidePaneView currentPaneView = null;
	
	
	/**
	 * @generated
	 */
	private final MenuViewHandler handler = new MenuViewHandler() {
	
		
		/**
		 * @generated
		 */
		@Override
		public void onClickCreate() {
		}
	
		
		/**
		 * @generated
		 */
		@Override
		public void onClickPalette() {
			clientFactory.getEventBus().fireEvent(new ShowPaneEvent(Panes.PALETTE));
		}
	
		
		/**
		 * @generated
		 */
		@Override
		public void onClickProperty() {
			clientFactory.getEventBus().fireEvent(new ShowPaneEvent(Panes.PROPERTY));
		}
	
		
		/**
		 * @generated
		 */
		@Override
		public void onDelete() {
			ISelection selection = diagramPresenter.getViewer().getSelection();
			if (selection instanceof IStructuredSelection) {
				final Object element = ((IStructuredSelection) selection).getFirstElement();
	
				if (element instanceof EditPart) {
					final org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) ((EditPart) element).getModel();
					Command command = new RemoveNotationalElementCommand((org.eclipse.gmf.runtime.notation.View) view.eContainer(), view);
					WrappingCommand gefCommand = new WrappingCommand(clientFactory.getEditingDomain(), command);
					diagramPresenter.getViewer().getEditDomain().getCommandStack().execute(gefCommand);
				}
			}
		}
	
		
		/**
		 * @generated
		 */
		@Override
		public void onRedo() {
			CommandStack stack = diagramPresenter.getViewer().getEditDomain().getCommandStack();
			if (stack.canRedo())
				stack.redo();
		}
	
		
		/**
		 * @generated
		 */
		@Override
		public void onUndo() {
			CommandStack stack = diagramPresenter.getViewer().getEditDomain().getCommandStack();
			if (stack.canUndo())
				stack.undo();
		}
	
		
		/**
		 * @generated
		 */
		@Override
		public void onZoomIn() {
			EditPart part = diagramPresenter.getViewer().getRootEditPart();
			if (part instanceof ScalableFreeformRootEditPart) {
				((ScalableFreeformRootEditPart) part).getZoomManager().zoomIn();
			}
		}
	
		
		/**
		 * @generated
		 */
		@Override
		public void onZoomOut() {
			EditPart part = diagramPresenter.getViewer().getRootEditPart();
			if (part instanceof ScalableFreeformRootEditPart) {
				((ScalableFreeformRootEditPart) part).getZoomManager().zoomOut();
			}
		}
	};
	
	public AppController(HandlerManager eventBus, ClientFactory clientFactory, View view) {
		this.eventBus = eventBus;
		this.clientFactory = clientFactory;
		this.view = view;
		this.view.getMenuView().addControlViewHandler(handler);
		
		bind();
	}
	
	
	/**
	 * @generated
	 */
	private void bind() {
		History.addValueChangeHandler(this);
		
		eventBus.addHandler(ShowPaneEvent.TYPE, new ShowPaneEventHandler() {
			
			/**
			 * @generated
			 */
			@Override
			public void show(ShowPaneEvent event) {
				if (currentPaneView != null) {
					currentPaneView.removeFromParent();
				}
				if (event.pane.equals(currentPane)) {
					currentPane = null;
					currentPaneView = null;
				} else {
					currentPane = event.pane;
					currentPaneView = event.pane.createView(AppController.this);
					((HasWidgets) view.asWidget().getParent()).add(currentPaneView);
				}
			}
		});
	}
	
	
	/**
	 * @generated
	 */
	private void createDiagram() {
		Resource resource = clientFactory.getResourceSet().createResource(URI.createURI("client://diagram"));
		diagramPresenter = new DiagramPresenter(eventBus, clientFactory, view.getDiagramView(), resource);
	}
	
	
	/**
	 * @generated
	 */
	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();
	
		if (token != null) {
			if (token.equals("diagram")) {
				createDiagram();
				clientFactory.getEventBus().fireEvent(new ShowPaneEvent(Panes.PALETTE));
			}
		}
	}
	
	
	/**
	 * @generated
	 */
	protected PaletteViewerProvider createPaletteProvider() {
		return new PaletteViewerProvider(clientFactory.getEditDomain()) {
			
			/**
			 * @generated
			 */
			@Override
			protected void hookPaletteViewer(PaletteViewer viewer) {
				super.hookPaletteViewer(viewer);
				viewer.setEditPartFactory(new PaletteEditPartFactory() {
	
					
					/**
					 * @generated
					 */
					@Override
					protected EditPart createGroupEditPart(EditPart parentEditPart, Object model) {
						return new GroupEditPart((PaletteContainer) model) {
							
							/**
							 * @generated
							 */
							@Override
							public IFigure createFigure() {
								IFigure figure = super.createFigure();
								figure.setBackgroundColor(new Color(null, 250, 250, 250));
								return figure;
							}
						};
					}
	
					
					/**
					 * @generated
					 */
					@Override
					protected EditPart createMainPaletteEditPart(EditPart parentEditPart, Object model) {
						return new SliderPaletteEditPart((PaletteRoot) model) {
							
							/**
							 * @generated
							 */
							@Override
							public IFigure createFigure() {
								IFigure figure = super.createFigure();
								figure.setOpaque(true);
								figure.setBackgroundColor(new Color(null, 250, 250, 250));
								figure.setForegroundColor(ColorConstants.black);
								return figure;
							}
						};
					}
				});
			}
		};
	}
	
	
	/**
	 * @generated
	 */
	private PaletteRoot createPalette() {
		PaletteRoot paletteRoot = new PaletteRoot();
		new EntitiesPaletteFactory(clientFactory).contributeToPalette(paletteRoot);
	
		return paletteRoot;
	}
	
	
	/**
	 * @generated
	 */
	public void showPalette() {
		eventBus.fireEvent(new ShowPaneEvent(Panes.PALETTE));
	}
	
	
	/**
	 * @generated
	 */
	public enum Panes {
		PALETTE {
	
			
			/**
			 * @generated
			 */
			@Override
			public int getWidth() {
				return 120;
			}
	
			
			/**
			 * @generated
			 */
			@Override
			public SidePaneView createView(AppController controller) {
				SidePaneView view = new SidePaneView();
				view.setWidth(getWidth() + "px");
	
				PaletteView paletteView = new PaletteView();
				paletteView.setPalette(controller.createPalette(), controller.createPaletteProvider());
				view.setContent(paletteView);
				
				return view;
			}
		}, 
		PROPERTY {
	
			
			/**
			 * @generated
			 */
			@Override
			public int getWidth() {
				return 200;
			}
	
			
			/**
			 * @generated
			 */
			@Override
			public SidePaneView createView(AppController controller) {
				SidePaneView view = new SidePaneView();
				view.setWidth(getWidth() + "px");
	
				PropertySheetView content = new PropertySheetView();
				new PropertySheetPresenter(controller.eventBus, controller.clientFactory, content);
				view.setContent(content);
	
				return view;
			}
		};
	
		
		/**
		 * @generated
		 */
		public abstract int getWidth();
	
		
		/**
		 * @generated
		 */
		public abstract SidePaneView createView(AppController controller);
	}
	
	
	/**
	 * @generated
	 */
	@Override
	public void goTo(HasWidgets container) {
		container.clear();
		container.add(view.asWidget());
		
		if ("".equals(History.getToken())) {
			History.newItem("diagram");
		} else {
			History.fireCurrentHistoryState();
		}
	}

}
