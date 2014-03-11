package org.sample.gefapp.entities.diagram.edit.commands;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.gwt.commands.ReconnectNotationalEdgeSourceCommand;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.sample.gefapp.entities.EntitiesPackage;
import org.sample.gefapp.entities.Entity;

/**
 * @generated
 */
public class ReconnectEntity_SuperType4001SourceCommand extends CommandWrapper {

	/**
	 * @generated
	 */
	private Edge edge;

	/**
	 * @generated
	 */
	private View newSource;

	/**
	 * @generated
	 */
	private View oldSource;

	/**
	 * @generated
	 */
	public ReconnectEntity_SuperType4001SourceCommand(ReconnectRequest request) {
		this((Edge) request.getConnectionEditPart().getModel(), (View) request
				.getTarget().getModel());
	}

	/**
	 * @generated
	 */
	public ReconnectEntity_SuperType4001SourceCommand(Edge edge, View newSource) {
		this.edge = edge;
		this.newSource = newSource;
		this.oldSource = edge.getSource();
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
		if (((Entity) newSource.getElement()).getSuperType() != null) {
			return false;
		}
		return true;
	}

	/**
	 * @generated
	 */
	protected Command createCommand() {
		final EditingDomain editingDomain = AdapterFactoryEditingDomain
				.getEditingDomainFor(oldSource.getDiagram().getElement());
		CompoundCommand result = new CompoundCommand();
		result.append(new ReconnectNotationalEdgeSourceCommand(edge, newSource));
		result.append(SetCommand.create(editingDomain, oldSource.getElement(),
				EntitiesPackage.eINSTANCE.getEntity_SuperType(),
				SetCommand.UNSET_VALUE));
		result.append(SetCommand.create(editingDomain, newSource.getElement(),
				EntitiesPackage.eINSTANCE.getEntity_SuperType(), edge
						.getTarget().getElement()));
		return result;
	}
}
