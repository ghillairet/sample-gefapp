package org.sample.gefapp.entities.client.presenter;

import java.io.IOException;

import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.gmf.runtime.gwt.client.ClientFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.sample.gefapp.entities.DomainModel;
import org.sample.gefapp.entities.diagram.edit.parts.DomainModelEditPart;
import org.sample.gefapp.entities.diagram.edit.parts.EntitiesEditPartFactory;
import org.sample.gefapp.entities.impl.EntitiesFactoryImpl;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;



/**
 * @generated
 */
public  class DiagramPresenter implements Presenter {

	
	/**
	 * @generated
	 */
	public interface View {
	
		
		/**
		 * @generated
		 */
		void setGraphicalViewer(GraphicalViewer viewer);
		
		
		/**
		 * @generated
		 */
		Widget asWidget();
	
	}
	
	
	
	/**
	 * @generated
	 */
	private final ClientFactory clientFactory;
	
	
	/**
	 * @generated
	 */
	private final View view;
	
	
	/**
	 * @generated
	 */
	private final Resource diagram;
	
	
	/**
	 * @generated
	 */
	private final GraphicalViewer viewer;
	
	public DiagramPresenter(HandlerManager eventBus, ClientFactory clientFactory, View view, Resource diagram) {
		this.clientFactory = clientFactory;
		this.view = view;
		this.diagram = diagram;
		this.viewer = createGraphicalViewer(clientFactory.getEditDomain());
		
		view.setGraphicalViewer(viewer);
		
		bind();
	}
	
	
	/**
	 * @generated
	 */
	private void bind() {
	}
	
	
	/**
	 * @generated
	 */
	public GraphicalViewer getViewer() {
		return viewer;
	}
	
	
	/**
	 * @generated
	 */
	private GraphicalViewer createGraphicalViewer(EditDomain editDomain) {
		GraphicalViewer viewer = new ScrollingGraphicalViewer();
		ScalableFreeformRootEditPart root = new ScalableFreeformRootEditPart();
	
		viewer.setRootEditPart(root);
		viewer.setEditPartFactory(new EntitiesEditPartFactory(clientFactory));
		viewer.setEditDomain(editDomain);
		viewer.setContents(createOrLoadDiagram(diagram));
	
		return viewer;
	}
	
	
	/**
	 * @generated
	 */
	private Diagram createOrLoadDiagram(Resource resource) {
		Diagram diagram = null;
	
		if (resource.getContents().isEmpty()) {
			diagram = NotationFactory.eINSTANCE.createDiagram();
			diagram.setType(DomainModelEditPart.MODEL_ID);
			DomainModel model = EntitiesFactoryImpl.eINSTANCE.createDomainModel();
			diagram.setElement(model);
	
			Resource domain = clientFactory.getResourceSet().createResource(
					resource.getURI().trimFileExtension().appendFileExtension("entities"));
	
			domain.getContents().add(model);
			resource.getContents().add(diagram);
	
			try {
				domain.save(null, new Callback<Resource>() {
					@Override public void onSuccess(Resource result) {}
					@Override public void onFailure(Throwable caught) {}
				});
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				resource.save(null, new Callback<Resource>() {
					@Override public void onSuccess(Resource result) {}
					@Override public void onFailure(Throwable caught) {}
				});
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			diagram = (Diagram) resource.getContents().get(0);
		}
	
		return diagram;
	}
	
	
	
	/**
	 * @generated
	 */
	@Override
	public void goTo(HasWidgets container) {
		container.clear();
		container.add(view.asWidget());
	}

}
