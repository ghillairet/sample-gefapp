package org.sample.gefapp.entities.diagram.edit.policies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.gwt.commands.WrappingCommand;
import org.eclipse.gmf.runtime.gwt.edit.policies.XYLayoutEditPolicyEx;
import org.eclipse.gmf.runtime.gwt.requests.CreateRequestEx;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.sample.gefapp.entities.diagram.edit.commands.AddEntity2001Command;
import org.sample.gefapp.entities.diagram.edit.commands.CloneEntity2001Command;
import org.sample.gefapp.entities.diagram.edit.commands.CreateEntity2001Command;
import org.sample.gefapp.entities.diagram.edit.parts.DomainModelEditPart;
import org.sample.gefapp.entities.diagram.edit.parts.EntityEditPart;
import org.sample.gefapp.entities.diagram.part.EntitiesVisualIDRegistry;

/**
 * @generated
 */
public class DomainModelLayoutEditPolicy extends XYLayoutEditPolicyEx {
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
					case EntityEditPart.VISUAL_ID :
						result.append(new CreateEntity2001Command(
								(Diagram) getHost().getModel(), requestEx,
								(Rectangle) getConstraintFor(request)));
						break;
				}
			}

			EObject element = ((Diagram) getHost().getModel()).getElement();
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
						(Diagram) getHost().getModel(), childNode.getElement());
				org.eclipse.emf.common.command.Command command = null;
				switch (newVisualID) {
					case EntityEditPart.VISUAL_ID :
						command = new AddEntity2001Command((Diagram) getHost()
								.getModel(), childNode, newVisualID,
								(Rectangle) constraint);
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
						(Diagram) getHost().getModel(), childNode.getElement());
				org.eclipse.emf.common.command.Command command = null;
				switch (newVisualID) {
					case EntityEditPart.VISUAL_ID :
						command = new CloneEntity2001Command(
								(Diagram) getHost().getModel(), childNode,
								(Rectangle) constraint);
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
	protected void showSizeOnDropFeedback(CreateRequest request) {
		IFigure feedback = getSizeOnDropFeedback(request);
		Rectangle rect = new Rectangle(request.getLocation(), request.getSize());
		getLayoutContainer().translateToRelative(rect);
		adjustConstraint(request, rect);
		getLayoutContainer().translateToAbsolute(rect);
		feedback.translateToRelative(rect);
		feedback.setBounds(rect.expand(getCreationFeedbackOffset(request)));
	}
	/**
	 * @generated
	 */
	protected void adjustConstraint(CreateRequest request, Rectangle constraint) {
		if (request instanceof CreateRequestEx) {
			CreateRequestEx requestEx = (CreateRequestEx) request;
			if (DomainModelEditPart.MODEL_ID.equals(requestEx.getModelID())) {
				int[] visualIds = requestEx.getVisualIds();
				boolean adjusted = false;
				for (int i = 0; i < visualIds.length && !adjusted; i++) {
					int nextVisualId = visualIds[i];
					switch (nextVisualId) {
						case EntityEditPart.VISUAL_ID : {
							if (constraint != null) {
								constraint.union(new Dimension(40, 40));
							}
							adjusted = true;
							break;
						}
					}
				}
			}
		}
	}
}
