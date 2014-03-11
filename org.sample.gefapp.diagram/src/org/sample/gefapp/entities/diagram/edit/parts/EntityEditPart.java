package org.sample.gefapp.entities.diagram.edit.parts;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.eclipse.gef.handles.AbstractHandle;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.gwt.client.ClientFactory;
import org.eclipse.gmf.runtime.gwt.commands.CreateNotationalEdgeCommand;
import org.eclipse.gmf.runtime.gwt.commands.CreateNotationalElementCommand;
import org.eclipse.gmf.runtime.gwt.edit.parts.BaseNodeEditPart;
import org.eclipse.gmf.runtime.gwt.edit.parts.OwnedLinksNotationModelRefresher;
import org.eclipse.gmf.runtime.gwt.edit.parts.decorations.IDecorationManager;
import org.eclipse.gmf.runtime.gwt.edit.parts.decorations.PaneDecorationManager;
import org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.EditPartRegistryBasedViewService;
import org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.ElementDescriptor;
import org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.IViewService;
import org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.LinkDescriptor;
import org.eclipse.gmf.runtime.gwt.edit.policies.DelegatingDirectEditPolicy;
import org.eclipse.gmf.runtime.gwt.events.DeselectEditPartEvent;
import org.eclipse.gmf.runtime.gwt.events.SelectEditPartEvent;
import org.eclipse.gmf.runtime.gwt.services.IViewDecorator;
import org.eclipse.gmf.runtime.notation.CanonicalStyle;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.sample.gefapp.entities.EntitiesPackage;
import org.sample.gefapp.entities.Entity;
import org.sample.gefapp.entities.diagram.edit.policies.EntityComponentEditPolicy;
import org.sample.gefapp.entities.diagram.edit.policies.EntityGraphicalNodeEditPolicy;
import org.sample.gefapp.entities.diagram.part.EntitiesVisualIDRegistry;
import org.sample.gefapp.entities.diagram.view.factories.EntitySuperTypeViewFactory;

/**
 * @generated
 */
public class EntityEditPart extends BaseNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2001;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	private final ClientFactory clientFactory;

	/**
	 * @generated
	 */
	public EntityEditPart(View model, ClientFactory clientFactory) {
		assert model instanceof Node;
		setModel(model);
		this.clientFactory = clientFactory;
	}

	/**
	 * @generated
	 */
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new EntityComponentEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new EntityGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new DelegatingDirectEditPolicy());
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new SelectionEditPolicy() {
			@Override
			protected void showSelection() {
				clientFactory.getEventBus().fireEvent(new SelectEditPartEvent(org.sample.gefapp.entities.diagram.edit.parts.EntityEditPart.this));
			}
			@Override
			protected void hideSelection() {
				clientFactory.getEventBus().fireEvent(new DeselectEditPartEvent(org.sample.gefapp.entities.diagram.edit.parts.EntityEditPart.this));
			}
		});
	}

	/**
	 * @generated
	 */
	protected EditPolicy getPrimaryDragEditPolicy() {
		ResizableEditPolicy result = new ResizableEditPolicy() {
			
			/**
			 * @generated
			 */
			@SuppressWarnings("unchecked")
			protected List<AbstractHandle> createSelectionHandles() {
				List<AbstractHandle> result = super.createSelectionHandles();
				for(Iterator<?> it = getChildren().iterator(); it.hasNext(); ) {
					EditPart next = (EditPart) it.next();
					View nextView = (View) next.getModel();
					switch (EntitiesVisualIDRegistry.getVisualID(nextView)) {
					case EntityFeaturesEditPart.VISUAL_ID:
						result.addAll(((EntityFeaturesEditPart) next).createSelectionHandles());
						break;
					}
				}
				return result;
			}
		};
		return result;
	}

	/**
	 * @generated
	 */
	protected IFigure createFigure() {
		IFigure invisibleRectangle = new Figure();
		invisibleRectangle.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		invisibleRectangle.add(shape);
		contentPane = setupContentPane(shape);
		IFigure decorationShape = createDecorationPane();
		if (decorationShape != null) {
			myDecorationManager = createDecorationManager(decorationShape);
			invisibleRectangle.add(decorationShape);
		}
		return invisibleRectangle;
	}

	/**
	 * @generated
	 */
	private IFigure createDecorationPane() {
		return new Layer();
	}

	/**
	 * @generated
	 */
	private IDecorationManager myDecorationManager;

	/**
	 * @generated
	 */
	public IDecorationManager getDecorationManager() {
		return myDecorationManager;
	}

	/**
	 * @generated
	 */
	protected IDecorationManager createDecorationManager(IFigure decorationShape) {
		PaneDecorationManager result = new PaneDecorationManager(
				decorationShape);
		return result;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		EntityFigure figure = new EntityFigure();
		primaryShape = figure;
		return primaryShape;
	}

	/**
	 * @generated
	 */
	public EntityFigure getPrimaryShape() {
		return (EntityFigure) primaryShape;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ToolbarLayout layout = new ToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane == null) {
			return super.getContentPane();
		}
		return contentPane;
	}

	/**
	 * @generated
	 */
	public Node getDiagramNode() {
		return (Node) getModel();
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof EntityNameEditPart) {
			((EntityNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureEntityNameFigure());
			return true;
		}
		if (childEditPart instanceof EntityFeaturesEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigurefeaturesCompartmentFigure();
			((EntityFeaturesEditPart) childEditPart)
					.setupCompartmentHolder(pane);
			pane.add(((GraphicalEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof EntityFeaturesEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigurefeaturesCompartmentFigure();
			pane.remove(((GraphicalEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * Returns the label which should be direct-edited by default.
	 * @generated
	 */
	private EditPart getPrimaryLabelEditPart() {
		for(Iterator<?> it = getDiagramNode().getChildren().iterator(); it.hasNext(); ) {
			View nextChild = (View)it.next();
			if (EntitiesVisualIDRegistry.getVisualID(nextChild) == EntityNameEditPart.VISUAL_ID) {
				return (EditPart) getViewer().getEditPartRegistry().get(nextChild);
			}
		}
		return null;
	}
	/**
	 * @generated
	 */
	public void performRequest(Request req) {
		if (RequestConstants.REQ_OPEN.equals(req.getType())) {
			Command command = getCommand(req);
			if (command != null && command.canExecute()) {
				getViewer().getEditDomain().getCommandStack().execute(command);
			}
			return;
		}
		if (RequestConstants.REQ_DIRECT_EDIT.equals(req.getType())) {
			EditPart labelToEdit;
			if (req instanceof DirectEditRequest) {
				labelToEdit = getLabelEditPart((DirectEditRequest) req);
			} else {
				labelToEdit = getPrimaryLabelEditPart();
			}
			if (labelToEdit != null) {
				labelToEdit.performRequest(req);
			}
		}
		super.performRequest(req);
	}

	/**
	 * @generated
	 */
	private EditPart getLabelEditPart(DirectEditRequest req) {
		EditPart result = getViewer().findObjectAt(req.getLocation());
		if (result != null) {
			if (getDiagramNode().getChildren().contains(result.getModel())) {
				View view = (View) result.getModel();
				int visualId = EntitiesVisualIDRegistry.getVisualID(view);
				switch (visualId) {
					case EntityNameEditPart.VISUAL_ID :
						return result;
				}
			}
		}
		return getPrimaryLabelEditPart();
	}

	/**
	 * @generated
	 */
	public boolean isDirectChild(EditPart childEditPart) {
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	public void activate() {
		super.activate();
	}

	/**
	 * @generated
	 */
	public class EntityFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private Label fFigureEntityNameFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fFigurefeaturesCompartmentFigure;

		/**
		 * @generated
		 */
		public EntityFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);

			layoutThis.setSpacing(5);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(6, 6));
			this.setLineWidth(2);
			this.setForegroundColor(THIS_FORE);
			this.setBackgroundColor(THIS_BACK);
			this.setMinimumSize(new Dimension(200, 150));

			this.setBorder(new MarginBorder(5, 3, 3, 3));
			createContents();
		}
		/**
		 * @generated
		 */
		private void createContents() {

			fFigureEntityNameFigure = new Label();

			fFigureEntityNameFigure.setText("<..>");
			fFigureEntityNameFigure
					.setForegroundColor(FFIGUREENTITYNAMEFIGURE_FORE);

			fFigureEntityNameFigure.setFont(FFIGUREENTITYNAMEFIGURE_FONT);

			this.add(fFigureEntityNameFigure);

			fFigurefeaturesCompartmentFigure = new RectangleFigure();

			fFigurefeaturesCompartmentFigure.setOutline(false);
			fFigurefeaturesCompartmentFigure
					.setForegroundColor(FFIGUREFEATURESCOMPARTMENTFIGURE_FORE);
			fFigurefeaturesCompartmentFigure
					.setBackgroundColor(FFIGUREFEATURESCOMPARTMENTFIGURE_BACK);
			fFigurefeaturesCompartmentFigure.setMinimumSize(new Dimension(200,
					150));

			fFigurefeaturesCompartmentFigure.setBorder(new MarginBorder(5, 5,
					5, 5));

			this.add(fFigurefeaturesCompartmentFigure);

		}

		/**
		 * @generated
		 */
		public Label getFigureEntityNameFigure() {
			return fFigureEntityNameFigure;
		}
		/**
		 * @generated
		 */
		public RectangleFigure getFigurefeaturesCompartmentFigure() {
			return fFigurefeaturesCompartmentFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 0, 0, 0);

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 255, 250, 230);

	/**
	 * @generated
	 */
	static final Color FFIGUREENTITYNAMEFIGURE_FORE = new Color(null, 0, 0, 0);

	/**
	 * @generated
	 */
	static final Font FFIGUREENTITYNAMEFIGURE_FONT = new Font(
			Display.getCurrent(), "Verdana", 14, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Color FFIGUREFEATURESCOMPARTMENTFIGURE_FORE = new Color(null,
			100, 100, 100);

	/**
	 * @generated
	 */
	static final Color FFIGUREFEATURESCOMPARTMENTFIGURE_BACK = new Color(null,
			255, 250, 230);

}
