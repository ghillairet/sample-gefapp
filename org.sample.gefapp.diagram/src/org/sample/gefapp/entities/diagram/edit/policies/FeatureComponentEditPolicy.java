package org.sample.gefapp.entities.diagram.edit.policies;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.gwt.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.gwt.commands.RemoveNotationalElementCommand;
import org.eclipse.gmf.runtime.gwt.commands.WrappingCommand;
import org.eclipse.gmf.runtime.gwt.edit.policies.ComponentEditPolicyEx;
import org.eclipse.gmf.runtime.notation.CanonicalStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class FeatureComponentEditPolicy extends ComponentEditPolicyEx {

	/**
	 * @generated
	 */
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		EditingDomain editingDomain = AdapterFactoryEditingDomain
				.getEditingDomainFor(getDiagramNode().getDiagram().getElement());

		final CompoundCommand cc = new CompoundCommand();
		cc.append(createDomainModelRemoveCommand(editingDomain));
		cc.append(new RemoveNotationalElementCommand((View) getDiagramNode()
				.eContainer(), getDiagramNode()));
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
				.getEditingDomainFor(getDiagramNode().getDiagram().getElement());
		final CompoundCommand cc = new CompoundCommand();
		cc.append(new RemoveNotationalElementCommand((View) getDiagramNode()
				.eContainer(), getDiagramNode()));
		return new WrappingCommand(editingDomain, cc);
	}

	/**
	 * @generated
	 */
	private boolean canDeleteView() {
		if (getDiagramNode().getEAnnotation("Shortcut") != null) {
			return true;
		}
		View parentView = (View) getDiagramNode().eContainer();
		if (parentView == null) {
			return true;
		}
		CanonicalStyle canonicalStyle = (CanonicalStyle) parentView
				.getStyle(NotationPackage.eINSTANCE.getCanonicalStyle());
		if (canonicalStyle != null) {
			return !canonicalStyle.isCanonical();
		}
		return false;
	}

	/**
	 * @generated
	 */
	private org.eclipse.emf.common.command.Command createDomainModelRemoveCommand(
			EditingDomain editingDomain) {
		return DestroyElementCommand.create(editingDomain, getDiagramNode()
				.getElement());
	}

	/**
	 * @generated
	 */
	protected Node getDiagramNode() {
		return (Node) getHost().getModel();
	}
}
