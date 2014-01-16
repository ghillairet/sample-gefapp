package org.sample.gefapp.entities.diagram.view.factories;

import org.eclipse.gmf.runtime.gwt.services.IViewDecorator;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.sample.gefapp.entities.diagram.edit.parts.FeatureNameEditPart;
import org.sample.gefapp.entities.diagram.part.EntitiesVisualIDRegistry;

/**
 * @generated
 */
public class FeatureNameViewFactory implements IViewDecorator {
	/**
	 * @generated
	 */
	public static FeatureNameViewFactory INSTANCE = new FeatureNameViewFactory();
	/**
	 * @generated
	 */
	public void decorateView(View view) {
		if (view.eIsSet(NotationPackage.eINSTANCE.getView_Type())) {
			return;
		}
		view.setType(EntitiesVisualIDRegistry
				.getType(FeatureNameEditPart.VISUAL_ID));
	}
}
