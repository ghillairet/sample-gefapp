package org.sample.gefapp.entities.diagram.view.factories;

import org.eclipse.gmf.runtime.gwt.services.IViewDecorator;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.sample.gefapp.entities.diagram.edit.parts.SuperTypeConnectionLabelEditPart;
import org.sample.gefapp.entities.diagram.part.EntitiesVisualIDRegistry;

/**
 * @generated
 */
public class EntitySuperTypeLabelViewFactory implements IViewDecorator {
	/**
	 * @generated
	 */
	public static EntitySuperTypeLabelViewFactory INSTANCE = new EntitySuperTypeLabelViewFactory();
	/**
	 * @generated
	 */
	public void decorateView(View view) {
		if (view.eIsSet(NotationPackage.eINSTANCE.getView_Type())) {
			return;
		}
		view.setType(EntitiesVisualIDRegistry
				.getType(SuperTypeConnectionLabelEditPart.VISUAL_ID));
		Location location = NotationFactory.eINSTANCE.createLocation();

		location.setY(40);
		((Node) view).setLayoutConstraint(location);
	}
}
