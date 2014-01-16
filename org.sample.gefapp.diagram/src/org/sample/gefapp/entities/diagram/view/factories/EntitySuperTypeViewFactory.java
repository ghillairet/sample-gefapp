package org.sample.gefapp.entities.diagram.view.factories;

import org.eclipse.gmf.runtime.gwt.services.IViewDecorator;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.sample.gefapp.entities.diagram.edit.parts.EntitySuperTypeEditPart;
import org.sample.gefapp.entities.diagram.part.EntitiesVisualIDRegistry;

/**
 * @generated
 */
public class EntitySuperTypeViewFactory implements IViewDecorator {
	/**
	 * @generated
	 */
	public static EntitySuperTypeViewFactory INSTANCE = new EntitySuperTypeViewFactory();
	/**
	 * @generated
	 */
	public void decorateView(View view) {
		if (view.eIsSet(NotationPackage.eINSTANCE.getView_Type())) {
			return;
		}
		view.setType(EntitiesVisualIDRegistry
				.getType(EntitySuperTypeEditPart.VISUAL_ID));
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
		FillStyle fillStyle = NotationFactory.eINSTANCE.createFillStyle();
		org.eclipse.swt.graphics.RGB defaultFillColor = new org.eclipse.swt.graphics.RGB(
				100, 100, 100);
		fillStyle.setFillColor((defaultFillColor.blue << 16)
				| (defaultFillColor.green << 8) | defaultFillColor.red);
		view.getStyles().add(fillStyle);
		create6001Label(view);
	}
	/**
	 * @generated
	 */
	private void create6001Label(View view) {
		Node label = NotationFactory.eINSTANCE.createNode();
		view.getPersistedChildren().add(label);
		EntitySuperTypeLabelViewFactory.INSTANCE.decorateView(label);
	}
}
