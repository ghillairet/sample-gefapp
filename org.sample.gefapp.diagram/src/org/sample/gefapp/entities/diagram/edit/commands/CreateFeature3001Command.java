package org.sample.gefapp.entities.diagram.edit.commands;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.gwt.commands.CreateNotationalNodeCommand;
import org.eclipse.gmf.runtime.gwt.requests.CreateRequestEx;
import org.eclipse.gmf.runtime.notation.View;
import org.sample.gefapp.entities.EntitiesFactory;
import org.sample.gefapp.entities.EntitiesPackage;
import org.sample.gefapp.entities.Feature;
import org.sample.gefapp.entities.diagram.view.factories.FeatureViewFactory;

/**
 * @generated
 */
public class CreateFeature3001Command extends AbstractCommand {

	/**
	 * @generated
	 */
	private final CreateNotationalNodeCommand notationAddCommand;

	/**
	 * @generated
	 */
	private final Command domainModelAddCommand;

	/**
	 * @generated
	 */
	public CreateFeature3001Command(View parent, CreateRequestEx request) {
		this(parent, request, null);
	}

	/**
	 * @generated
	 */
	public CreateFeature3001Command(View parent, CreateRequestEx request,
			Rectangle constraint) {
		Feature createdDomainElement = EntitiesFactory.eINSTANCE
				.createFeature();
		EditingDomain editingDomain = AdapterFactoryEditingDomain
				.getEditingDomainFor(parent.getDiagram().getElement());
		domainModelAddCommand = AddCommand.create(editingDomain,
				parent.getElement(),
				EntitiesPackage.eINSTANCE.getEntity_Features(),
				createdDomainElement);
		if (constraint != null) {
			constraint.union(new Dimension(40, 40));
		}
		this.notationAddCommand = new CreateNotationalNodeCommand(parent,
				createdDomainElement, constraint, FeatureViewFactory.INSTANCE);
		request.setCreatedObject(notationAddCommand.getCreatedView());
	}

	/**
	 * @generated
	 */
	protected boolean prepare() {
		return domainModelAddCommand != null
				&& domainModelAddCommand.canExecute()
				&& notationAddCommand != null
				&& notationAddCommand.canExecute();
	}

	/**
	 * @generated
	 */
	public boolean canUndo() {
		return domainModelAddCommand != null && domainModelAddCommand.canUndo()
				&& notationAddCommand != null && notationAddCommand.canUndo();
	}

	/**
	 * @generated
	 */
	public void execute() {
		domainModelAddCommand.execute();
		notationAddCommand.execute();
	}

	/**
	 * @generated
	 */
	public void undo() {
		notationAddCommand.undo();
		domainModelAddCommand.undo();
	}

	/**
	 * @generated
	 */
	public void redo() {
		execute();
	}
}
