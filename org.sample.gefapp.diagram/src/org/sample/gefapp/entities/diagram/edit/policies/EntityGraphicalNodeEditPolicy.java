package org.sample.gefapp.entities.diagram.edit.policies;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.gwt.commands.WrappingCommand;
import org.eclipse.gmf.runtime.gwt.requests.CreateConnectionRequestEx;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.sample.gefapp.entities.diagram.edit.commands.CreateEntity_SuperType4001Command;
import org.sample.gefapp.entities.diagram.edit.commands.CreateEntity_SuperType4001StartCommand;
import org.sample.gefapp.entities.diagram.edit.commands.Entity_SuperType4001StartCommand;
import org.sample.gefapp.entities.diagram.edit.commands.ReconnectEntity_SuperType4001SourceCommand;
import org.sample.gefapp.entities.diagram.edit.commands.ReconnectEntity_SuperType4001TargetCommand;
import org.sample.gefapp.entities.diagram.edit.parts.DomainModelEditPart;
import org.sample.gefapp.entities.diagram.edit.parts.EntitySuperTypeEditPart;
import org.sample.gefapp.entities.diagram.part.EntitiesVisualIDRegistry;

/**
 * @generated
 */
public class EntityGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {

	/**
	 * @generated
	 */
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		if (request instanceof CreateConnectionRequestEx) {
			CreateConnectionRequestEx requestEx = (CreateConnectionRequestEx) request;
			if (!DomainModelEditPart.MODEL_ID.equals(requestEx.getModelID())) {
				return null;
			}

			int[] visualIds = requestEx.getVisualIds();
			final CompoundCommand result = new CompoundCommand();
			for (int i = 0; i < visualIds.length; i++) {
				int nextVisualId = visualIds[i];
				switch (nextVisualId) {
					case EntitySuperTypeEditPart.VISUAL_ID :
						result.appendIfCanExecute(new CreateEntity_SuperType4001StartCommand(
								requestEx));
						break;
				}
			}

			if (!result.canExecute()) {
				return null;
			}

			EObject element = ((Node) getHost().getModel()).getDiagram()
					.getElement();
			EditingDomain domain = AdapterFactoryEditingDomain
					.getEditingDomainFor(element);
			Command wrappedResult = new WrappingCommand(domain, result);
			request.setStartCommand(wrappedResult);

			return wrappedResult;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getConnectionCompleteCommand(
			CreateConnectionRequest request) {
		if (request instanceof CreateConnectionRequestEx) {
			if (request.getStartCommand() == null
					|| !request.getStartCommand().canExecute()) {
				return UnexecutableCommand.INSTANCE;
			}

			CreateConnectionRequestEx requestEx = (CreateConnectionRequestEx) request;
			if (!DomainModelEditPart.MODEL_ID.equals(requestEx.getModelID())) {
				return null;
			}

			int[] visualIds = requestEx.getVisualIds();
			final CompoundCommand result = new CompoundCommand();
			for (int i = 0; i < visualIds.length; i++) {
				int nextVisualId = visualIds[i];
				switch (nextVisualId) {
					case EntitySuperTypeEditPart.VISUAL_ID :
						result.appendIfCanExecute(new CreateEntity_SuperType4001Command(
								requestEx));
						break;
				}
			}

			if (result.getCommandList().size() != 1 || !result.canExecute()) {
				//Cannot create several connections at once.
				return UnexecutableCommand.INSTANCE;
			}

			EObject element = ((Node) getHost().getModel()).getDiagram()
					.getElement();
			EditingDomain domain = AdapterFactoryEditingDomain
					.getEditingDomainFor(element);
			Command wrappedResult = new WrappingCommand(domain, result);

			return request.getStartCommand().chain(wrappedResult);
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		ConnectionEditPart connection = request.getConnectionEditPart();
		if (connection.getModel() instanceof Edge == false) {
			return null;
		}

		Edge edge = (Edge) connection.getModel();
		String modelID = EntitiesVisualIDRegistry.getModelID(edge);
		if (!DomainModelEditPart.MODEL_ID.equals(modelID)) {
			return null;
		}

		org.eclipse.emf.common.command.Command result = null;
		int visualID = EntitiesVisualIDRegistry.getVisualID(edge);
		switch (visualID) {
			case EntitySuperTypeEditPart.VISUAL_ID :
				result = new ReconnectEntity_SuperType4001SourceCommand(request);
				break;
		}

		if (result == null || !result.canExecute()) {
			return null;
		}

		EObject element = ((Node) getHost().getModel()).getDiagram()
				.getElement();
		EditingDomain domain = AdapterFactoryEditingDomain
				.getEditingDomainFor(element);
		return new WrappingCommand(domain, result);
	}

	/**
	 * @generated
	 */
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		ConnectionEditPart connection = request.getConnectionEditPart();
		if (connection.getModel() instanceof Edge == false) {
			return null;
		}

		Edge edge = (Edge) connection.getModel();
		String modelID = EntitiesVisualIDRegistry.getModelID(edge);
		if (!DomainModelEditPart.MODEL_ID.equals(modelID)) {
			return null;
		}

		org.eclipse.emf.common.command.Command result = null;
		int visualID = EntitiesVisualIDRegistry.getVisualID(edge);
		switch (visualID) {
			case EntitySuperTypeEditPart.VISUAL_ID :
				result = new ReconnectEntity_SuperType4001TargetCommand(request);
				break;
		}

		if (result == null || !result.canExecute()) {
			return null;
		}

		EObject element = ((Node) getHost().getModel()).getDiagram()
				.getElement();
		EditingDomain domain = AdapterFactoryEditingDomain
				.getEditingDomainFor(element);
		return new WrappingCommand(domain, result);
	}
}
