package org.sample.gefapp.entities.diagram.edit.parts;

import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.ScalableFreeformLayeredPane;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.gef.tools.MarqueeDragTracker;
import org.eclipse.gmf.runtime.gwt.client.ClientFactory;
import org.eclipse.gmf.runtime.gwt.edit.parts.BaseDiagramEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.graphics.Color;
import org.sample.gefapp.entities.diagram.edit.policies.DomainModelLayoutEditPolicy;

/**
 * @generated
 */
public class DomainModelEditPart extends BaseDiagramEditPart {

	/**
	 * @generated
	 */
	public static String MODEL_ID = "Entities";
	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1000;
	/**
	 * @generated
	 */
	private final ClientFactory clientFactory;
	/**
	 * @generated
	 */
	public DomainModelEditPart(Diagram model, ClientFactory clientFactory) {
		setModel(model);
		this.clientFactory = clientFactory;
	}
	/**
	 * @generated
	 */
	public Diagram getDiagram() {
		return (Diagram) getModel();
	}
	/**
	 * @generated
	 */
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new DomainModelLayoutEditPolicy());
	}
	/**
	 * @generated
	 */
	protected IFigure createFigure() {
		IFigure f = new ScalableFreeformLayeredPane();
		f.setBorder(new MarginBorder(5));
		f.setOpaque(true);
		f.setBackgroundColor(new Color(null, 254, 254, 254));
		f.setLayoutManager(new FreeformLayout());
		return f;
	}
	/**
	 * @generated
	 */
	public DragTracker getDragTracker(Request request) {
		return new MarqueeDragTracker() {
			protected boolean handleButtonDown(int button) {
				if (super.handleButtonDown(button)) {
					getViewer().setSelection(StructuredSelection.EMPTY);
					getViewer().setFocus(null);
					return true;
				}
				return false;
			}
		};
	}
	/**
	 * @generated
	 */
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class key) {
		if (SnapToHelper.class == key) {
			return new SnapToGrid(this);
		}
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

}
