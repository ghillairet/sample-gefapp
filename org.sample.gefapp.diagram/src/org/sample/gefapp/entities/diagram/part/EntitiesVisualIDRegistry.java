package org.sample.gefapp.entities.diagram.part;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.sample.gefapp.entities.DomainModel;
import org.sample.gefapp.entities.EntitiesPackage;
import org.sample.gefapp.entities.diagram.edit.parts.DomainModelEditPart;
import org.sample.gefapp.entities.diagram.edit.parts.EntityEditPart;
import org.sample.gefapp.entities.diagram.edit.parts.EntityFeaturesEditPart;
import org.sample.gefapp.entities.diagram.edit.parts.FeatureEditPart;

/**
 * @generated
 */
public class EntitiesVisualIDRegistry {
	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut");
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID");
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}
	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (DomainModelEditPart.MODEL_ID.equals(view.getType())) {
				return DomainModelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.sample.gefapp.entities.diagram.part.EntitiesVisualIDRegistry
				.getVisualID(view.getType());
	}
	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return -1;
		}
	}
	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (EntitiesPackage.eINSTANCE.getDomainModel().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((DomainModel) domainElement)) {
			return DomainModelEditPart.VISUAL_ID;
		}
		return -1;
	}
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.sample.gefapp.entities.diagram.part.EntitiesVisualIDRegistry
				.getModelID(containerView);
		if (!DomainModelEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (DomainModelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.sample.gefapp.entities.diagram.part.EntitiesVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = DomainModelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
			case DomainModelEditPart.VISUAL_ID :
				if (EntitiesPackage.eINSTANCE.getEntity().isSuperTypeOf(
						domainElement.eClass())) {
					return EntityEditPart.VISUAL_ID;
				}
				break;
			case EntityFeaturesEditPart.VISUAL_ID :
				if (EntitiesPackage.eINSTANCE.getFeature().isSuperTypeOf(
						domainElement.eClass())) {
					return FeatureEditPart.VISUAL_ID;
				}
				break;
		}
		return -1;
	}
	/**
	 * User can change implementation of this method to handle some specificsituations not covered by default logic.
	 * @generated
	 */
	private static boolean isDiagram(DomainModel element) {
		return true;
	}
}
