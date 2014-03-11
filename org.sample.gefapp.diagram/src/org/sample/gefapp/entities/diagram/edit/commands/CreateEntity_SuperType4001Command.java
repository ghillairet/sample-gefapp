package org.sample.gefapp.entities.diagram.edit.commands;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.gwt.requests.CreateConnectionRequestEx;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.sample.gefapp.entities.EntitiesPackage;
import org.sample.gefapp.entities.diagram.view.factories.EntitySuperTypeViewFactory;

/**
 * @generated
 */
public class CreateEntity_SuperType4001Command extends AbstractCommand {

	/**
	 * @generated
	 */
	private final View source;

	/**
	 * @generated
	 */
	private final View target;

	/**
	 * @generated
	 */
	private final Edge createdEdge;

	/**
	 * @generated
	 */
	private Command domainModelAddCommand;

	/**
	 * @generated
	 */
	public CreateEntity_SuperType4001Command(CreateConnectionRequestEx requestEx) {
		if (requestEx.getSourceEditPart().getModel() instanceof View) {
			source = (View) requestEx.getSourceEditPart().getModel();
		} else {
			source = null;
		}
		if (requestEx.getTargetEditPart().getModel() instanceof View) {
			target = (View) requestEx.getTargetEditPart().getModel();
		} else {
			target = null;
		}
		if (source == null || target == null) {
			createdEdge = null;
			return;
		}
		createdEdge = NotationFactory.eINSTANCE.createEdge();
		createdEdge.setElement(null);
		EntitySuperTypeViewFactory.INSTANCE.decorateView(createdEdge);
	}

	/**
	 * @generated
	 */
	protected boolean prepare() {
		if (source == null || target == null || createdEdge == null) {
			return false;
		}
		domainModelAddCommand = initializeDomainModelCommand();
		if (domainModelAddCommand == null
				|| !domainModelAddCommand.canExecute()) {
			return false;
		}
		return true;
	}

	/**
	 * @generated
	 */
	private Command initializeDomainModelCommand() {
		EditingDomain domainModelEditDomain = AdapterFactoryEditingDomain
				.getEditingDomainFor(source.getDiagram().getElement());
		return SetCommand.create(domainModelEditDomain, source.getElement(),
				EntitiesPackage.eINSTANCE.getEntity_SuperType(),
				target.getElement());
	}

	/**
	 * @generated
	 */
	public boolean canUndo() {
		return source != null && target != null && createdEdge != null
				&& domainModelAddCommand != null
				&& domainModelAddCommand.canUndo();
	}

	/**
	 * @generated
	 */
	public void execute() {
		domainModelAddCommand.execute();
		source.getDiagram().insertEdge(createdEdge);
		createdEdge.setSource(source);
		createdEdge.setTarget(target);
	}

	/**
	 * @generated
	 */
	public void undo() {
		domainModelAddCommand.undo();
		source.getDiagram().removeEdge(createdEdge);
		createdEdge.setSource(null);
		createdEdge.setTarget(null);
	}

	/**
	 * @generated
	 */
	public void redo() {
		execute();
	}
}
