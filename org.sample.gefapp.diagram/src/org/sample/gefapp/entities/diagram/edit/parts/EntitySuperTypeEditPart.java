package org.sample.gefapp.entities.diagram.edit.parts;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.BendpointConnectionRouter;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.gwt.client.ClientFactory;
import org.eclipse.gmf.runtime.gwt.edit.parts.BaseConnectionNodeEditPart;
import org.eclipse.gmf.runtime.gwt.edit.parts.decorations.ConnectionDecorationManager;
import org.eclipse.gmf.runtime.gwt.edit.parts.decorations.IDecorationManager;
import org.eclipse.gmf.runtime.gwt.edit.policies.BendpointEditPolicy;
import org.eclipse.gmf.runtime.gwt.edit.policies.DelegatingDirectEditPolicy;
import org.eclipse.gmf.runtime.gwt.figures.ConnectionConnectionAnchor;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.sample.gefapp.entities.diagram.edit.policies.EntitySuperTypeComponentEditPolicy;
import org.sample.gefapp.entities.diagram.edit.policies.EntitySuperTypeEndpointEditPolicy;
import org.sample.gefapp.entities.diagram.edit.policies.EntitySuperTypeGraphicalNodeEditPolicy;
import org.sample.gefapp.entities.diagram.part.EntitiesVisualIDRegistry;


/**
 * @generated
 */
public class EntitySuperTypeEditPart extends BaseConnectionNodeEditPart {

	
	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4001;
	
	/**
	 * @generated
	 */
	private final ClientFactory clientFactory;
	
	/**
	 * @generated
	 */
	public EntitySuperTypeEditPart(View model, ClientFactory clientFactory) {
		assert model instanceof Edge;
		setModel(model);
		this.clientFactory = clientFactory;
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
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new EntitySuperTypeComponentEditPolicy());
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new EntitySuperTypeEndpointEditPolicy());
		installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new BendpointEditPolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new DelegatingDirectEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new EntitySuperTypeGraphicalNodeEditPolicy());
	}
	
	/**
	 * Returns the label which should be direct-edited by default.
	 * @generated
	 */
	private EditPart getPrimaryLabelEditPart() {
		for(Iterator<?> it = getDiagramEdge().getChildren().iterator(); it.hasNext(); ) {
			View nextChild = (View)it.next();
			if (EntitiesVisualIDRegistry.getVisualID(nextChild) == SuperTypeConnectionLabelEditPart.VISUAL_ID) {
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
			if (getDiagramEdge().getChildren().contains(result.getModel())) {
				View view = (View) result.getModel();
				int visualId = EntitiesVisualIDRegistry.getVisualID(view);
				switch (visualId) {
				case SuperTypeConnectionLabelEditPart.VISUAL_ID:
					return result;
				}
			}
		}
		return getPrimaryLabelEditPart();
	}
	
	/**
	 * @generated
	 */
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class key) {
		return super.getAdapter(key);
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
	public void deactivate() {
		super.deactivate();
	}
	
	/**
	 * @generated
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshVisibility();
		refreshBendpoints();
	refreshBackgroundColor();
	}
	
	/**
	 * @generated
	 */
	public void addNotify() {
		super.addNotify();
		getConnectionFigure().setConnectionRouter(new BendpointConnectionRouter());
	}
	
	/**
	 * @generated
	 */
	protected IFigure createFigure() {
		Connection result = primCreateFigure();
		myDecorationManager = createDecorationManager(result);
		return result;
	}
	
	/**
	 * @generated
	 */
	protected IDecorationManager createDecorationManager(Connection connection) {
		return new ConnectionDecorationManager(connection);
	}
	private Connection primCreateFigure() {
		return new SuperTypeConnectionFigure();
	}
	
	/**
	 * @generated
	 */
	public class SuperTypeConnectionFigure extends PolylineConnection {
	
	
	
	
		/**
		 * @generated
		 */
		public SuperTypeConnectionFigure() {
				this.setForegroundColor(THIS_FORE
	);
	
			setTargetDecoration(createTargetDecoration());
		}
	
		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			PolygonDecoration df = new PolygonDecoration();
	df.setFill(true);
	df.setLineWidth(2);
		df.setForegroundColor(DF_FORE
	);
	PointList pl = new PointList();
	pl.addPoint(-1, 1);
	pl.addPoint(-1, -1);
	pl.addPoint(0, 0);
	df.setTemplate(pl);
	df.setScale(
	7, 
	3);
			return df;
		}
	
	
	
	
	}
	
	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 0, 0, 0);
	
	/**
	 * @generated
	 */
	static final Color DF_FORE = new Color(null, 0, 0, 0);
	

}
