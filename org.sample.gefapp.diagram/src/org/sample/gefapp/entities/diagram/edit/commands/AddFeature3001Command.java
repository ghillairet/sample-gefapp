package org.sample.gefapp.entities.diagram.edit.commands;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.gwt.commands.CreateNotationalNodeCommand;
import org.eclipse.gmf.runtime.gwt.commands.ExpandDrawerCommand;
import org.eclipse.gmf.runtime.gwt.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.sample.gefapp.entities.EntitiesPackage;
import org.sample.gefapp.entities.diagram.edit.parts.EntityEditPart;
import org.sample.gefapp.entities.diagram.edit.parts.FeatureEditPart;
import org.sample.gefapp.entities.diagram.part.EntitiesVisualIDRegistry;
import org.sample.gefapp.entities.diagram.view.factories.FeatureViewFactory;

/**
 * @generated
 */
public class AddFeature3001Command extends CommandWrapper {

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
	private final int oldVisualID;

	/**
	 * @generated
	 */
	private final int newVisualID;

	/**
	 * @generated
	 */
	private final Rectangle constraint;

	/**
	 * @generated
	 */
	public AddFeature3001Command(View parentView, Node childNode,
			int newVisualID, Rectangle constraint) {
		this.parentView = parentView;
		this.childNode = childNode;
		this.oldVisualID = EntitiesVisualIDRegistry.getVisualID(childNode);
		this.newVisualID = newVisualID;
		this.constraint = constraint;
	}

	/**
	 * @generated
	 */
	protected Command createCommand() {
		CompoundCommand result = new CompoundCommand();
		EObject element = childNode.getElement();
		EditingDomain editingDomain = AdapterFactoryEditingDomain
				.getEditingDomainFor(parentView.getDiagram().getElement());
		switch (oldVisualID) {
			case EntityEditPart.VISUAL_ID :
				result.append(RemoveCommand.create(editingDomain,
						element.eContainer(),
						EntitiesPackage.eINSTANCE.getDomainModel_Entities(),
						element));
				break;
			case FeatureEditPart.VISUAL_ID :
				result.append(RemoveCommand.create(editingDomain,
						element.eContainer(),
						EntitiesPackage.eINSTANCE.getEntity_Features(), element));
				break;
		}
		result.append(AddCommand.create(editingDomain, parentView.getElement(),
				EntitiesPackage.eINSTANCE.getEntity_Features(), element));
		result.append(RemoveCommand.create(editingDomain,
				childNode.eContainer(), childNode.eContainmentFeature(),
				childNode));
		if (newVisualID == oldVisualID) {
			result.append(new ExpandDrawerCommand(parentView));
			result.append(AddCommand.create(editingDomain, parentView,
					NotationPackage.eINSTANCE.getView_PersistedChildren(),
					childNode));
			result.append(new SetBoundsCommand(childNode, constraint));
		} else {
			if (constraint != null) {
				constraint.union(new Dimension(40, 40));
			}
			result.append(new CreateNotationalNodeCommand(parentView, element,
					constraint, FeatureViewFactory.INSTANCE));
		}
		return result;
	}
}
