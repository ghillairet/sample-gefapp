package org.sample.gefapp.entities.diagram.edit.policies;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.sample.gefapp.entities.diagram.edit.parts.SuperTypeConnectionLabelEditPart;
import org.sample.gefapp.entities.diagram.part.EntitiesVisualIDRegistry;

/**
 * @generated
 */
public class EntitySuperTypeEndpointEditPolicy extends ConnectionEndpointEditPolicy {
	/**
	 * @generated
	 */
	protected List<Handle> createSelectionHandles() {
		@SuppressWarnings("unchecked")
		List<Handle> result = super.createSelectionHandles();
	
		for(Object next: getHost().getChildren()) {
			View nextView = (View) ((EditPart) next).getModel();
			switch (EntitiesVisualIDRegistry.getVisualID(nextView)) {
				case SuperTypeConnectionLabelEditPart.VISUAL_ID:
				result.addAll(((SuperTypeConnectionLabelEditPart) next).createSelectionHandles());
				break;
			}
		}
	
		return result;
	}
}
