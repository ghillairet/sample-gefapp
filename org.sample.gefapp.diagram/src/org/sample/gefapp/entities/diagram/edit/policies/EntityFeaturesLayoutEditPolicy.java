package org.sample.gefapp.entities.diagram.edit.policies;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.gwt.commands.WrappingCommand;
import org.eclipse.gmf.runtime.gwt.edit.policies.ListLayoutEditPolicy;
import org.eclipse.gmf.runtime.gwt.requests.CreateRequestEx;
import org.eclipse.gmf.runtime.notation.Node;
import org.sample.gefapp.entities.diagram.edit.commands.AddFeature3001Command;
import org.sample.gefapp.entities.diagram.edit.commands.CloneFeature3001Command;
import org.sample.gefapp.entities.diagram.edit.commands.CreateFeature3001Command;
import org.sample.gefapp.entities.diagram.edit.parts.DomainModelEditPart;
import org.sample.gefapp.entities.diagram.edit.parts.FeatureEditPart;
import org.sample.gefapp.entities.diagram.part.EntitiesVisualIDRegistry;

/**
 * @generated
 */
public class EntityFeaturesLayoutEditPolicy extends ListLayoutEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateRequest request) {
		if (request instanceof CreateRequestEx) {
			CreateRequestEx requestEx = (CreateRequestEx) request;
			if (!DomainModelEditPart.MODEL_ID.equals(requestEx.getModelID())) {
				return null;
			}

			int[] visualIds = requestEx.getVisualIds();
			final CompoundCommand result = new CompoundCommand();
			for (int i = 0; i < visualIds.length; i++) {
				int nextVisualId = visualIds[i];
				switch (nextVisualId) {
					case FeatureEditPart.VISUAL_ID :
						result.append(new CreateFeature3001Command(
								(Node) getHost().getModel(), requestEx));
						break;
				}
			}

			EObject element = ((Node) getHost().getModel()).getDiagram()
					.getElement();
			EditingDomain domain = AdapterFactoryEditingDomain
					.getEditingDomainFor(element);
			return new WrappingCommand(domain, result);
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command createAddCommand(EditPart child, Object constraint) {
		if (child.getModel() instanceof Node) {
			Node childNode = (Node) child.getModel();
			String modelID = EntitiesVisualIDRegistry.getModelID(childNode);

			if (DomainModelEditPart.MODEL_ID.equals(modelID)) {
				int newVisualID = EntitiesVisualIDRegistry.getNodeVisualID(
						(Node) getHost().getModel(), childNode.getElement());
				org.eclipse.emf.common.command.Command command = null;
				switch (newVisualID) {
					case FeatureEditPart.VISUAL_ID :
						command = new AddFeature3001Command((Node) getHost()
								.getModel(), childNode, newVisualID, null);
						break;
				}

				if (command != null) {
					EditingDomain domain = AdapterFactoryEditingDomain
							.getEditingDomainFor(childNode.getDiagram()
									.getElement());
					return new WrappingCommand(domain, command);
				}
			}
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command createCloneCommand(EditPart child, Object constraint) {
		if (child.getModel() instanceof Node) {
			Node childNode = (Node) child.getModel();
			String modelID = EntitiesVisualIDRegistry.getModelID(childNode);

			if (DomainModelEditPart.MODEL_ID.equals(modelID)) {
				int newVisualID = EntitiesVisualIDRegistry.getNodeVisualID(
						(Node) getHost().getModel(), childNode.getElement());
				org.eclipse.emf.common.command.Command command = null;
				switch (newVisualID) {
					case FeatureEditPart.VISUAL_ID :
						command = new CloneFeature3001Command((Node) getHost()
								.getModel(), childNode, null);
						break;
				}

				if (command != null) {
					EditingDomain domain = AdapterFactoryEditingDomain
							.getEditingDomainFor(childNode.getDiagram()
									.getElement());
					return new WrappingCommand(domain, command);
				}
			}
		}
		return null;
	}
}
