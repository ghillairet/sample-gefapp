package org.sample.gefapp.entities.diagram.edit.commands;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.gwt.commands.ReconnectNotationalEdgeTargetCommand;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.sample.gefapp.entities.EntitiesPackage;

/**
 * @generated
 */
public class ReconnectEntity_SuperType4001TargetCommand extends CommandWrapper {

	/**
	 * @generated
	 */
	private Edge edge;

	/**
	 * @generated
	 */
	private View newTarget;

	/**
	 * @generated
	 */
	private View oldTarget;

	/**
	 * @generated
	 */
	public ReconnectEntity_SuperType4001TargetCommand(ReconnectRequest request) {
		this((Edge) request.getConnectionEditPart().getModel(), (View) request
				.getTarget().getModel());
	}

	/**
	 * @generated
	 */
	public ReconnectEntity_SuperType4001TargetCommand(Edge edge, View newTarget) {
		this.edge = edge;
		this.newTarget = newTarget;
		this.oldTarget = edge.getTarget();
	}

	/**
	 * @generated
	 */
	protected boolean prepare() {
		if (!canReconnect()) {
			return false;
		}
		return super.prepare();
	}

	/**
	 * @generated
	 */
	private boolean canReconnect() {
		return true;
	}

	/**
	 * @generated
	 */
	protected Command createCommand() {
		EditingDomain editingDomain = AdapterFactoryEditingDomain
				.getEditingDomainFor(oldTarget.getDiagram().getElement());
		CompoundCommand result = new CompoundCommand();
		result.append(new ReconnectNotationalEdgeTargetCommand(edge, newTarget));
		result.append(SetCommand.create(editingDomain, edge.getSource()
				.getElement(), EntitiesPackage.eINSTANCE.getEntity_SuperType(),
				newTarget.getElement()));
		return result;
	}
}
