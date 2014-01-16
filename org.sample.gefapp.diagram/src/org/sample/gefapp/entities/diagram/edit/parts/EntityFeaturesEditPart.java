package org.sample.gefapp.entities.diagram.edit.parts;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.Viewport;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.gwt.client.ClientFactory;
import org.eclipse.gmf.runtime.gwt.commands.CreateNotationalElementCommand;
import org.eclipse.gmf.runtime.gwt.commands.CreateNotationalNodeCommand;
import org.eclipse.gmf.runtime.gwt.edit.parts.BaseNodeEditPart;
import org.eclipse.gmf.runtime.gwt.edit.parts.ChildNotationModelRefresher;
import org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.ElementDescriptor;
import org.eclipse.gmf.runtime.gwt.figures.CompartmentFigure;
import org.eclipse.gmf.runtime.gwt.handles.CompartmentCollapseHandle;
import org.eclipse.gmf.runtime.notation.CanonicalStyle;
import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.sample.gefapp.entities.EntitiesPackage;
import org.sample.gefapp.entities.Entity;
import org.sample.gefapp.entities.Feature;
import org.sample.gefapp.entities.diagram.edit.policies.EntityFeaturesLayoutEditPolicy;
import org.sample.gefapp.entities.diagram.part.EntitiesVisualIDRegistry;
import org.sample.gefapp.entities.diagram.view.factories.FeatureViewFactory;

/**
 * @generated
 */
public class EntityFeaturesEditPart extends BaseNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 7001;
	
	private ClientFactory clientFactory;

	/**
	 * @generated
	 */
	public EntityFeaturesEditPart(View model, ClientFactory clientFactory) {
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
	protected List getModelChildren() {
		DrawerStyle style = (DrawerStyle) getDiagramNode().getStyle(NotationPackage.eINSTANCE.getDrawerStyle());
		if (style != null && style.isCollapsed()) {
			return Collections.EMPTY_LIST;
		}
		return getDiagramNode().getVisibleChildren();
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
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new EntityFeaturesLayoutEditPolicy());
	}
	/**
	 * Returns the selection handles that should be contributed to the parent when it becomes selected.
	 * @generated
	 */
	public List createSelectionHandles() {
	return Collections.singletonList(new CompartmentCollapseHandle(this, getTitleName()));
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
		super.performRequest(req);
	}
	/**
	 * @generated
	 */
	protected String getTitleName() {
	return "";	
	}
	/**
	 * @generated
	 */
	public IFigure createFigure() {
		Figure result = new CompartmentFigure();
		result.setLayoutManager(new StackLayout());
		ScrollPane scrollPane = new ScrollPane();
		result.add(scrollPane);
		Viewport viewport = new Viewport();
		contentPane = new Figure();
		contentPane.setLayoutManager(new ToolbarLayout());
		viewport.setContents(contentPane);
		scrollPane.setViewport(viewport);
		return result;
	}
	/**
	 * @generated
	 */
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class key) {
		return super.getAdapter(key);
	}
	/**
	 * @generated
	 */
	protected IFigure contentPane;
	
	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane == null) {
			return super.getContentPane();
		}
		return contentPane;
	}
	/**
	 * @generated
	 */
	public void setupCompartmentHolder(IFigure shape) {
		if (shape.getLayoutManager() == null) {
			shape.setLayoutManager(new StackLayout());
		}
	}
	/**
	 * @generated
	 */
	public void activate() {
		super.activate();
		installRefresher(getNotationModelRefresher());
	}
	/**
	 * @generated
	 */
	public void deactivate() {
		super.deactivate();
	}
	/**
	 * @generated
	 */
	private ChildNotationModelRefresher notationModelRefresher;
	
	/**
	 * @generated
	 */
	private ChildNotationModelRefresher getNotationModelRefresher() {
		if (notationModelRefresher == null) {
			notationModelRefresher = new NotationModelRefresher(this);
		}
		return notationModelRefresher;
	}
	/**
	 * @generated
	 */
	private class NotationModelRefresher extends ChildNotationModelRefresher {
	
		public NotationModelRefresher(AbstractGraphicalEditPart part) {
			super(part);
		}
		/**
		 * @generated
		 */
		@Override
		public boolean shouldRefresh(Notification notification) {
			boolean result = true;
			if (EntitiesPackage.eINSTANCE.getEntity_Features().equals(notification.getFeature())) {
				result = result || true;
			}
			result = result && notification.getNotifier().equals(getDiagramNode().getElement());
			return result;
		}
		/**
		 * @generated
		 */
		protected CreateNotationalElementCommand getCreateNotationalElementCommand(ElementDescriptor descriptor) {
			EObject domainElement = descriptor.getElement();
			int nodeVisualID = descriptor.getVisualID();
			switch (nodeVisualID) {
				case FeatureEditPart.VISUAL_ID:
					if (domainElement instanceof Feature) {
						return new CreateNotationalNodeCommand(getHost(), domainElement, null
						, FeatureViewFactory.INSTANCE, false);
					}
					return null;
				default:
					return null;
			}
		}
		/**
		 * @generated
		 */
		protected List getSemanticChildNodes() {
			List result = new LinkedList();
			View viewObject = getHost();
			EObject modelObject = viewObject.getElement();
			EObject nextValue;
			int nodeVID;
			for(Iterator it = ((Entity)modelObject).getFeatures()
			.iterator(); it.hasNext(); ) {
				nextValue = (EObject) it.next();
				nodeVID = EntitiesVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
				if (FeatureEditPart.VISUAL_ID == nodeVID) {
					result.add(new ElementDescriptor(nextValue, nodeVID));
				}
				}
			return result;
		}
		/**
		 * Returns whether a notational element should be created for the given domain element. 
		 * The generated code respects canonical style. If the canonycal style is not present, true is always returned. 
		 * User can change implementation of this method to handle a more sophisticated logic.
		 * @generated
		 */
		protected boolean shouldCreateView(ElementDescriptor descriptor) {
			CanonicalStyle style = (CanonicalStyle) getDiagramNode().getStyle(NotationPackage.eINSTANCE.getCanonicalStyle());
			if (style == null) {
				return true;
			}
			return style.isCanonical();
		}
	
	}

}
