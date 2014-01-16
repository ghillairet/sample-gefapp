package org.sample.gefapp.entities.diagram.view.factories;

import org.eclipse.gmf.runtime.gwt.services.IViewDecorator;
import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.sample.gefapp.entities.diagram.edit.parts.EntityFeaturesEditPart;
import org.sample.gefapp.entities.diagram.part.EntitiesVisualIDRegistry;

/**
 * @generated
 */
public class EntityFeaturesViewFactory implements IViewDecorator {
	/**
	 * @generated
	 */
	public static EntityFeaturesViewFactory INSTANCE = new EntityFeaturesViewFactory();
	/**
	 * @generated
	 */
	public void decorateView(View view) {
		if (view.eIsSet(NotationPackage.eINSTANCE.getView_Type())) {
			return;
		}
		view.setType(EntitiesVisualIDRegistry
				.getType(EntityFeaturesEditPart.VISUAL_ID));
		DrawerStyle drawerStyle = NotationFactory.eINSTANCE.createDrawerStyle();
		view.getStyles().add(drawerStyle);
		TitleStyle titleStyle = NotationFactory.eINSTANCE.createTitleStyle();
		view.getStyles().add(titleStyle);
	}
}
