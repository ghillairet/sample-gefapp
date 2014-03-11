package org.sample.gefapp.entities.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.gwt.client.ClientFactory;
import org.eclipse.gmf.runtime.gwt.edit.parts.EditPartRefresher;
import org.eclipse.gmf.runtime.gwt.edit.parts.labels.ILabelController;
import org.eclipse.gmf.runtime.gwt.edit.parts.labels.ILabelTextDisplayer;
import org.eclipse.gmf.runtime.gwt.edit.parts.labels.MessageFormatLabelTextDisplayer;
import org.eclipse.gmf.runtime.gwt.edit.policies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.gwt.services.LabelCellEditorLocator;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.graphics.Image;
import org.sample.gefapp.entities.EntitiesPackage;

/**
 * @generated
 */
public class FeatureNameEditPart extends AbstractGraphicalEditPart
		implements
			ILabelController {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 5002;

	/**
	 * @generated
	 */
	private final ClientFactory clientFactory;

	/**
	 * @generated
	 */
	public FeatureNameEditPart(View model, ClientFactory clientFactory) {
		assert model instanceof Node;
		setModel(model);
		this.clientFactory = clientFactory;
	}

	/**
	 * @generated
	 */
	public boolean isSelectable() {
		return false;
	}

	/**
	 * @generated
	 */
	public Node getDiagramNode() {
		return (Node) getModel();
	}

	/**
	 * @generated
	 */
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
				new LabelDirectEditPolicy());
	}

	/**
	 * @generated
	 */
	private EditPartRefresher labelRefresher;

	/**
	 * @generated
	 */
	protected EditPartRefresher getLabelRefresher() {
		if (labelRefresher == null && getDiagramNode() != null) {
			labelRefresher = new ILabelController.LabelRefresher(this,
					getDiagramNode().getElement());
		}
		return labelRefresher;
	}

	/**
	 * @generated
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshLabel();
	}

	/**
	 * @generated
	 */
	protected void refreshLabel() {
		getLabel().setText(getLabelText());
		getLabel().setIcon(getLabelIcon());
	}

	/**
	 * @generated
	 */
	public void performRequest(Request req) {
		if (RequestConstants.REQ_OPEN.equals(req.getType())) {
			Command command = getCommand(req);
			if (command != null && command.canExecute()) {
				getViewer().getEditDomain().getCommandStack().execute(command);
			}
			return;
		}
		if (RequestConstants.REQ_DIRECT_EDIT.equals(req.getType())
				&& understandsRequest(req)) {
			performDirectEdit();
			return;
		}
		super.performRequest(req);
	}

	/**
	 * @generated
	 */
	private DirectEditManager manager;

	/**
	 * @generated
	 */
	protected DirectEditManager getManager() {
		if (manager == null) {
			manager = new DirectEditManager(this, TextCellEditor.class,
					new LabelCellEditorLocator(getViewer(), getLabel())) {
				protected void initCellEditor() {
					getCellEditor().setValue(
							getLabelTextDisplayer().getEditText(
									getDiagramNode().getElement()));
				}
			};
		}
		return manager;
	}

	/**
	 * @generated
	 */
	protected void performDirectEdit() {
		if (getLabelTextDisplayer() == null) {
			return;
		}
		getManager().show();
	}

	/**
	 * @generated
	 */
	public static final ILabelTextDisplayer LABEL_DISPLAYER = createLabelTextDisplayer();

	/**
	 * @generated
	 */
	public ILabelTextDisplayer getLabelTextDisplayer() {
		return LABEL_DISPLAYER;
	}

	/**
	 * @generated
	 */
	private static ILabelTextDisplayer createLabelTextDisplayer() {
		return new MessageFormatLabelTextDisplayer(null, null, null,
				new EAttribute[]{EntitiesPackage.eINSTANCE.getFeature_Name()});
	}

	/**
	 * @generated
	 */
	private String defaultText;

	/**
	 * @generated
	 */
	public void setLabelText(String text) {
		if (text == null || text.length() == 0) {
			text = defaultText;
		}
		getLabel().setText(text);
	}

	/**
	 * @generated
	 */
	protected String getLabelText() {
		if (getLabelTextDisplayer() == null) {
			return defaultText;
		}
		EObject element = getDiagramNode().getElement();
		if (element == null) {
			return defaultText;
		}
		String result = getLabelTextDisplayer().getDisplayText(element);
		if (result == null || result.length() == 0) {
			return defaultText;
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected Image getLabelIcon() {
		Image image = null;
		try {
			image = clientFactory.getImageProvider().getImage(
					getDiagramNode().getElement().eClass());
		} catch (Exception e) {
			// 
		}
		return image;
	}

	/**
	 * @generated
	 */
	protected IFigure createFigure() {
		// Parent should assign one using setLabel method
		return null;
	}

	public Label getLabel() {
		return (Label) getFigure();
	}

	/**
	 * @generated
	 */
	public void setLabel(Label label) {
		unregisterVisuals();
		setFigure(label);
		defaultText = label.getText();
		registerVisuals();
		refreshVisuals();
	}

	/**
	 * @generated
	 */
	private FeatureEditPart getUpdatableParent() {
		assert getParent() instanceof FeatureEditPart;
		return (FeatureEditPart) getParent();
	}
	/**
	 * @generated
	 */
	public void activate() {
		super.activate();
		FeatureEditPart updatableParent = getUpdatableParent();
		if (updatableParent != null) {
			updatableParent.installRefresher(getLabelRefresher());
			updatableParent.addNotifier(getDiagramNode());
			updatableParent.addNotifier(getDiagramNode().getElement());
		}
	}

	/**
	 * @generated
	 */
	public void deactivate() {
		FeatureEditPart updatableParent = getUpdatableParent();
		if (updatableParent != null) {
			updatableParent.uninstallRefresher(getLabelRefresher());
			updatableParent.removeNotifier(getDiagramNode());
			updatableParent.removeNotifier(getDiagramNode().getElement());
		}
		super.deactivate();
	}

}
