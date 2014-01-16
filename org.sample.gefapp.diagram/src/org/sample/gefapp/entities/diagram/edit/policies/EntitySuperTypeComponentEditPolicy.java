package org.sample.gefapp.entities.diagram.edit.policies;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.gwt.commands.RemoveNotationalEdgeCommand;
import org.eclipse.gmf.runtime.gwt.commands.WrappingCommand;
import org.eclipse.gmf.runtime.gwt.edit.policies.ComponentEditPolicyEx;
import org.eclipse.gmf.runtime.notation.Edge;

/**
 * @generated
 */
public class EntitySuperTypeComponentEditPolicy extends ComponentEditPolicyEx {
	/**
	 * @generated
	 */
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		EditingDomain editingDomain = AdapterFactoryEditingDomain
				.getEditingDomainFor(getDiagramEdge().getDiagram().getElement());

		final CompoundCommand cc = new CompoundCommand();
		cc.append(createDomainModelRemoveCommand(editingDomain));
		cc.append(new RemoveNotationalEdgeCommand(
				getDiagramEdge().getDiagram(), getDiagramEdge()));
		return new WrappingCommand(editingDomain, cc);
	}
	/**
	 * @generated
	 */
	protected Command getDeleteViewCommand(GroupRequest deleteRequest,
			boolean isForced) {
		if (!isForced && !canDeleteView()) {
			return UnexecutableCommand.INSTANCE;
		}
		EditingDomain editingDomain = AdapterFactoryEditingDomain
				.getEditingDomainFor(getDiagramEdge().getDiagram().getElement());
		final CompoundCommand cc = new CompoundCommand();
		cc.append(new RemoveNotationalEdgeCommand(
				getDiagramEdge().getDiagram(), getDiagramEdge()));
		return new WrappingCommand(editingDomain, cc);
	}
	/**
	 * @generated
	 */
	private boolean canDeleteView() {
		return false;
	}
	/**
	 * @generated
	 */
	private org.eclipse.emf.common.command.Command createDomainModelRemoveCommand(
			EditingDomain editingDomain) {
		return org.eclipse.emf.common.command.UnexecutableCommand.INSTANCE;
	}
	/**
	 * @generated
	 */
	protected Edge getDiagramEdge() {
		return (Edge) getHost().getModel();
	}
}
