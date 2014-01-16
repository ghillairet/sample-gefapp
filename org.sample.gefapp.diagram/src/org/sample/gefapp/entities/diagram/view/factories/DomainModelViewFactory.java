package org.sample.gefapp.entities.diagram.view.factories;

import org.eclipse.gmf.runtime.gwt.services.IViewDecorator;
import org.eclipse.gmf.runtime.notation.DiagramStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.sample.gefapp.entities.diagram.edit.parts.DomainModelEditPart;

/**
 * @generated
 */
public class DomainModelViewFactory implements IViewDecorator {
	/**
	 * @generated
	 */
	public static DomainModelViewFactory INSTANCE = new DomainModelViewFactory();
	/**
	 * @generated
	 */
	public void decorateView(View view) {
		if (view.eIsSet(NotationPackage.eINSTANCE.getView_Type())) {
			return;
		}
		view.setType(DomainModelEditPart.MODEL_ID);
		DiagramStyle style = NotationFactory.eINSTANCE.createDiagramStyle();
		view.getStyles().add(style);
	}
}
