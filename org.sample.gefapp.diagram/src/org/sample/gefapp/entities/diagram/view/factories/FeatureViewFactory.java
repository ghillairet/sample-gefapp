package org.sample.gefapp.entities.diagram.view.factories;

import org.eclipse.gmf.runtime.gwt.services.IViewDecorator;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.sample.gefapp.entities.diagram.edit.parts.FeatureEditPart;
import org.sample.gefapp.entities.diagram.part.EntitiesVisualIDRegistry;

/**
 * @generated
 */
public class FeatureViewFactory implements IViewDecorator {
	/**
	 * @generated
	 */
	public static FeatureViewFactory INSTANCE = new FeatureViewFactory();
	/**
	 * @generated
	 */
	public void decorateView(View view) {
		if (view.eIsSet(NotationPackage.eINSTANCE.getView_Type())) {
			return;
		}
		view.setType(EntitiesVisualIDRegistry
				.getType(FeatureEditPart.VISUAL_ID));
		FontStyle fontStyle = NotationFactory.eINSTANCE.createFontStyle();
		FontData defaultFontData = new FontData();
		fontStyle.setFontName(defaultFontData.getName());
		fontStyle.setFontHeight(defaultFontData.getHeight());
		fontStyle.setBold((defaultFontData.getStyle() & SWT.BOLD) != 0);
		fontStyle.setItalic((defaultFontData.getStyle() & SWT.ITALIC) != 0);

		org.eclipse.swt.graphics.RGB defaultFontColor = new org.eclipse.swt.graphics.RGB(
				100, 100, 100);
		fontStyle.setFontColor((defaultFontColor.blue << 16)
				| (defaultFontColor.green << 8) | defaultFontColor.red);
		view.getStyles().add(fontStyle);
		create5002Label(view);
	}
	/**
	 * @generated
	 */
	private void create5002Label(View view) {
		Node label = NotationFactory.eINSTANCE.createNode();
		view.getPersistedChildren().add(label);
		FeatureNameViewFactory.INSTANCE.decorateView(label);
	}
}
