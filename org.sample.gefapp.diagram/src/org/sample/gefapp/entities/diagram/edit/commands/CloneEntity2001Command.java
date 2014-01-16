package org.sample.gefapp.entities.diagram.edit.commands;

import java.util.Collection;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.gwt.commands.CreateNotationalNodeCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.sample.gefapp.entities.EntitiesPackage;
import org.sample.gefapp.entities.diagram.view.factories.EntityViewFactory;

/**
 * @generated
 */
public class CloneEntity2001Command extends CommandWrapper {
	/**
	 * @generated
	 */
	private final View parentView;

	/**
	 * @generated
	 */
	private final Node childNode;

	/**
	 * @generated
	 */
	private final Rectangle constraint;

	/**
	 * @generated
	 */
	private final EditingDomain editingDomain;

	/**
	 * @generated
	 */
	private Command afterCopyCommand;
	/**
	 * @generated
	 */
	public CloneEntity2001Command(View parentView, Node childNode,
			Rectangle constraint) {
		this.parentView = parentView;
		this.childNode = childNode;
		this.constraint = constraint;
		this.editingDomain = AdapterFactoryEditingDomain
				.getEditingDomainFor(childNode.getDiagram().getElement());
	}
	/**
	 * @generated
	 */
	protected Command createCommand() {
		EObject element = childNode.getElement();
		//We are being optimistic here about whether further commands can be executed.
		//Otherwise, we would have to execute the CopyCommand on every mouse move, which could be much too expensive.
		return CopyCommand.create(editingDomain, element);
	}
	/**
	 * @generated
	 */
	private Command createAfterCopyCommand() {
		final Collection copyResults = super.getResult();
		assert copyResults.size() == 1;
		EObject copyResult = (EObject) copyResults.iterator().next();
		CompoundCommand result = new CompoundCommand();
		result.append(AddCommand.create(editingDomain, parentView.getElement(), EntitiesPackage.eINSTANCE.getDomainModel_Entities(), copyResult));
		if (constraint != null) {
			constraint.union(new Dimension(40, 40));
		}
		result.append(new CreateNotationalNodeCommand(parentView, copyResult, constraint, EntityViewFactory.INSTANCE));
		return result;
	}
	/**
	 * @generated
	 */
	public void execute() {
		super.execute();
		afterCopyCommand = createAfterCopyCommand();
		if (afterCopyCommand.canExecute()) {
			afterCopyCommand.execute();
		} else {
			assert false;
		}
	}
	/**
	 * @generated
	 */
	public boolean canUndo() {
		return super.canUndo() && afterCopyCommand != null
				&& afterCopyCommand.canUndo();
	}
	/**
	 * @generated
	 */
	public void undo() {
		afterCopyCommand.undo();
		super.undo();
	}
	/**
	 * @generated
	 */
	public void redo() {
		super.redo();
		afterCopyCommand.redo();
	}
	/**
	 * @generated
	 */
	public void dispose() {
		super.dispose();
		if (afterCopyCommand != null) {
			afterCopyCommand.dispose();
		}
	}
}
