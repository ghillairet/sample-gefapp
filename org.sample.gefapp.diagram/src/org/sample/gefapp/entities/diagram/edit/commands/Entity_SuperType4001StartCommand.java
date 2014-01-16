package org.sample.gefapp.entities.diagram.edit.commands;

import org.eclipse.gmf.runtime.gwt.commands.VetoCommand;
import org.eclipse.gmf.runtime.gwt.requests.CreateConnectionRequestEx;
import org.eclipse.gmf.runtime.notation.View;
import org.sample.gefapp.entities.Entity;

/**
 * @generated
 */
public class Entity_SuperType4001StartCommand extends VetoCommand {
	/**
	 * @generated
	 */
	private View source;
	/**
	 * @generated
	 */
	public Entity_SuperType4001StartCommand(CreateConnectionRequestEx requestEx) {
		//Until the mouse button is pressed, the source of the connection is in request.getTargetEditPart(), not in request.getSourceEditPart().
		source = (View) requestEx.getTargetEditPart().getModel();
	}
	/**
	 * @generated
	 */
	protected boolean shouldExecute() {
		if (source == null) {
			return false;
		}
		if (((Entity) source.getElement()).getSuperType() != null) {
			return false;
		}
		return true;
	}
}
