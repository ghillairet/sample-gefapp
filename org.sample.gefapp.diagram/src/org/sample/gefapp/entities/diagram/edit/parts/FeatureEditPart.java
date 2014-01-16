package org.sample.gefapp.entities.diagram.edit.parts;

import java.util.Iterator;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.gwt.client.ClientFactory;
import org.eclipse.gmf.runtime.gwt.edit.parts.BaseNodeEditPart;
import org.eclipse.gmf.runtime.gwt.edit.parts.decorations.IDecorationManager;
import org.eclipse.gmf.runtime.gwt.edit.parts.decorations.PaneDecorationManager;
import org.eclipse.gmf.runtime.gwt.edit.policies.DelegatingDirectEditPolicy;
import org.eclipse.gmf.runtime.gwt.events.DeselectEditPartEvent;
import org.eclipse.gmf.runtime.gwt.events.SelectEditPartEvent;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.sample.gefapp.entities.diagram.edit.policies.FeatureComponentEditPolicy;
import org.sample.gefapp.entities.diagram.edit.policies.FeatureGraphicalNodeEditPolicy;
import org.sample.gefapp.entities.diagram.part.EntitiesVisualIDRegistry;

/**
 * @generated
 */
public class FeatureEditPart extends BaseNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3001;
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
	public FeatureEditPart(View model, ClientFactory clientFactory) {
		assert model instanceof Node;
		setModel(model);
		this.clientFactory = clientFactory;
	}
	/**
	 * @generated
	 */
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new FeatureComponentEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new FeatureGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new DelegatingDirectEditPolicy());
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new SelectionEditPolicy() {
			@Override
			protected void showSelection() {
				clientFactory.getEventBus().fireEvent(new SelectEditPartEvent(org.sample.gefapp.entities.diagram.edit.parts.FeatureEditPart.this));
			}
			@Override
			protected void hideSelection() {
				clientFactory.getEventBus().fireEvent(new DeselectEditPartEvent(org.sample.gefapp.entities.diagram.edit.parts.FeatureEditPart.this));
			}
		});
	}
	/**
	 * @generated
	 */
	protected EditPolicy getPrimaryDragEditPolicy() {
		ResizableEditPolicy result = new ResizableEditPolicy();
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
		FeatureFigure figure = new FeatureFigure();
		primaryShape = figure;
		return primaryShape;
	}
	/**
	 * @generated
	 */
	public FeatureFigure getPrimaryShape() {
		return (FeatureFigure) primaryShape;
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
		if (childEditPart instanceof FeatureNameEditPart) {
			((FeatureNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureFeatureNameFigure());
			return true;
		}
		return false;
	}
	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		return false;
	}
	/**
	 * Returns the label which should be direct-edited by default.
	 * @generated
	 */
	private EditPart getPrimaryLabelEditPart() {
		for (Iterator it = getDiagramNode().getChildren().iterator(); it
				.hasNext();) {
			View nextChild = (View) it.next();
			if (EntitiesVisualIDRegistry.getVisualID(nextChild) == FeatureNameEditPart.VISUAL_ID) {
				return (EditPart) getViewer().getEditPartRegistry().get(
						nextChild);
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
					case FeatureNameEditPart.VISUAL_ID :
						return result;
				}
			}
		}
		return getPrimaryLabelEditPart();
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
	public class FeatureFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private Label fFigureFeatureNameFigure;

		/**
		 * @generated
		 */
		public FeatureFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);

			layoutThis.setSpacing(5);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(8, 8));
			this.setFillXOR(true);
			this.setForegroundColor(THIS_FORE);
			this.setBackgroundColor(THIS_BACK);

			this.setBorder(new MarginBorder(5, 5, 5, 5));
			createContents();
		}
		/**
		 * @generated
		 */
		private void createContents() {

			fFigureFeatureNameFigure = new Label();

			fFigureFeatureNameFigure.setText("<..>");

			fFigureFeatureNameFigure.setFont(FFIGUREFEATURENAMEFIGURE_FONT);

			this.add(fFigureFeatureNameFigure);

		}

		/**
		 * @generated
		 */
		public Label getFigureFeatureNameFigure() {
			return fFigureFeatureNameFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 111, 142, 194);

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 242, 245, 252);

	/**
	 * @generated
	 */
	static final Font FFIGUREFEATURENAMEFIGURE_FONT = new Font(
			Display.getCurrent(), "Verdana", 8, SWT.BOLD);

}
