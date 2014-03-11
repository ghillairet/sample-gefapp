package org.sample.gefapp.entities.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gmf.runtime.gwt.client.ClientFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.sample.gefapp.entities.diagram.part.EntitiesVisualIDRegistry;

/**
 * @generated
 */
public class EntitiesEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public static final String EXTERNAL_NODE_LABELS_LAYER = "External Node Labels";

	/**
	 * @generated
	 */
	private final ClientFactory clientFactory;

	/**
	 * @generated
	 */
	public EntitiesEditPartFactory(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			String modelID = EntitiesVisualIDRegistry.getModelID(view);
			if (!DomainModelEditPart.MODEL_ID.equals(modelID)) {
				return null;
			}
			int viewVisualID = EntitiesVisualIDRegistry.getVisualID(view);
			switch (viewVisualID) {
				case DomainModelEditPart.VISUAL_ID :
					return new DomainModelEditPart((Diagram) view,
							clientFactory);
				case EntityEditPart.VISUAL_ID :
					return new EntityEditPart(view, clientFactory);
				case EntityNameEditPart.VISUAL_ID :
					return new EntityNameEditPart(view, clientFactory);
				case FeatureEditPart.VISUAL_ID :
					return new FeatureEditPart(view, clientFactory);
				case FeatureNameEditPart.VISUAL_ID :
					return new FeatureNameEditPart(view, clientFactory);
				case EntityFeaturesEditPart.VISUAL_ID :
					return new EntityFeaturesEditPart(view, clientFactory);
				case EntitySuperTypeEditPart.VISUAL_ID :
					return new EntitySuperTypeEditPart(view, clientFactory);
				case SuperTypeConnectionLabelEditPart.VISUAL_ID :
					return new SuperTypeConnectionLabelEditPart(view,
							clientFactory);
			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}
}
