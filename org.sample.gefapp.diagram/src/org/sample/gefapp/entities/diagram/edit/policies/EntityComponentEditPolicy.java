package org.sample.gefapp.entities.diagram.edit.policies;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.gwt.commands.CompositeWrappingCommand;
import org.eclipse.gmf.runtime.gwt.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.gwt.commands.RemoveNotationalElementCommand;
import org.eclipse.gmf.runtime.gwt.commands.WrappingCommand;
import org.eclipse.gmf.runtime.gwt.edit.policies.ComponentEditPolicyEx;
import org.eclipse.gmf.runtime.notation.CanonicalStyle;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.sample.gefapp.entities.diagram.edit.parts.EntitySuperTypeEditPart;
import org.sample.gefapp.entities.diagram.part.EntitiesVisualIDRegistry;

/**
 * @generated
 */
public class EntityComponentEditPolicy extends ComponentEditPolicyEx {
	/**
	 * @generated
	 */
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(getDiagramNode().getDiagram().getElement());
		CompositeWrappingCommand result = new CompositeWrappingCommand(editingDomain, "Delete Element");
	
	
		for(Object next: getGraphicalEditPart().getSourceConnections()) {
			EditPart nextEditPart = (EditPart) next;
			Edge nextEdge = (Edge) nextEditPart.getModel();
			int visualID = EntitiesVisualIDRegistry.getVisualID(nextEdge);
			switch (visualID) {
				case EntitySuperTypeEditPart.VISUAL_ID:
				{
					GroupRequest deleteLinkRequest = new GroupRequest(RequestConstants.REQ_DELETE);
					deleteLinkRequest.setEditParts(nextEditPart);
					result.add(nextEditPart.getCommand(deleteLinkRequest));
					break;
				}
			}
		}
	
		final CompoundCommand cc = new CompoundCommand();
		cc.append(createDomainModelRemoveCommand(editingDomain));
		cc.append(new RemoveNotationalElementCommand((View) getDiagramNode().eContainer(), getDiagramNode()));
		result.add(cc);
		return result;
	}
	/**
	 * @generated
	 */
	protected Command getDeleteViewCommand(GroupRequest deleteRequest, boolean isForced) {
		if (!isForced && !canDeleteView()) {
			return UnexecutableCommand.INSTANCE;
		}
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(getDiagramNode().getDiagram().getElement());
		CompositeWrappingCommand result = new CompositeWrappingCommand(editingDomain, null);
		for(Object next: getGraphicalEditPart().getTargetConnections()) {
			EditPart nextEditPart = (EditPart) next;
			Edge nextEdge = (Edge) nextEditPart.getModel();
			int visualID = EntitiesVisualIDRegistry.getVisualID(nextEdge);
			switch (visualID) {
				case EntitySuperTypeEditPart.VISUAL_ID:
				{
					GroupRequest deleteLinkRequest = new GroupRequest(org.eclipse.gmf.runtime.gwt.requests.RequestConstants.REQ_FORCED_DELETE_VIEW);
					deleteLinkRequest.setEditParts(nextEditPart);
					result.add(nextEditPart.getCommand(deleteLinkRequest));
					break;
				}
			}
		}
		for(Object next: getGraphicalEditPart().getSourceConnections()) {
			EditPart nextEditPart = (EditPart) next;
			Edge nextEdge = (Edge) nextEditPart.getModel();
			int visualID = EntitiesVisualIDRegistry.getVisualID(nextEdge);
			switch (visualID) {
				case EntitySuperTypeEditPart.VISUAL_ID:
				{
					GroupRequest deleteLinkRequest = new GroupRequest(org.eclipse.gmf.runtime.gwt.requests.RequestConstants.REQ_FORCED_DELETE_VIEW);
					deleteLinkRequest.setEditParts(nextEditPart);
					result.add(nextEditPart.getCommand(deleteLinkRequest));
					break;
				}
			}
		}
		final CompoundCommand cc = new CompoundCommand();
		cc.append(new RemoveNotationalElementCommand((View) getDiagramNode().eContainer(), getDiagramNode()));
		result.add(cc);
		return result;
	}
	/**
	 * @generated
	 */
	private boolean canDeleteView() {
		if (getDiagramNode().getEAnnotation("Shortcut") != null) {
			return true;
		}
		View parentView = (View) getDiagramNode().eContainer();
		if (parentView == null) {
			return true;
		}
		CanonicalStyle canonicalStyle = (CanonicalStyle) parentView
				.getStyle(NotationPackage.eINSTANCE.getCanonicalStyle());
		if (canonicalStyle != null) {
			return !canonicalStyle.isCanonical();
		}
		return false;
	}
	/**
	 * @generated
	 */
	protected GraphicalEditPart getGraphicalEditPart() {
		return (GraphicalEditPart) getHost();
	}
	/**
	 * @generated
	 */
	private org.eclipse.emf.common.command.Command createDomainModelRemoveCommand(
			EditingDomain editingDomain) {
		return DestroyElementCommand.create(editingDomain, getDiagramNode()
				.getElement());
	}
	/**
	 * @generated
	 */
	protected Node getDiagramNode() {
		return (Node) getHost().getModel();
	}
}
