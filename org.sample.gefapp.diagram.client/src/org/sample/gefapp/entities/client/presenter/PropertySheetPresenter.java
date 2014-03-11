package org.sample.gefapp.entities.client.presenter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.gmf.runtime.gwt.client.ClientFactory;
import org.eclipse.gmf.runtime.gwt.edit.parts.BaseNodeEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.gwt.events.DeselectEditPartEvent;
import org.eclipse.gmf.runtime.gwt.events.DeselectEditPartEvent.DeselectEditPartEventHandler;
import org.eclipse.gmf.runtime.gwt.events.SelectEditPartEvent;
import org.eclipse.gmf.runtime.gwt.events.SelectEditPartEvent.SelectEditPartEventHandler;
import org.sample.gefapp.entities.client.view.CheckBoxView;
import org.sample.gefapp.entities.client.view.DateView;
import org.sample.gefapp.entities.client.view.MultipleListView;
import org.sample.gefapp.entities.client.view.PropertySheetSectionView;
import org.sample.gefapp.entities.client.view.SingleListView;
import org.sample.gefapp.entities.client.view.TextAreaView;
import org.sample.gefapp.entities.client.view.TextView;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;


/**
 * @generated
 */
public  class PropertySheetPresenter implements Presenter {

	
	/**
	 * @generated
	 */
	public interface View {
	
		void add(SectionView section);
		
		void clear();
		
		Widget asWidget();
	
	}
	
	public interface SectionView {
	
		void setContent(List<FeatureEditPresenter.View> items);
	
		Widget asWidget();
	
	}
	
	
	
	/**
	 * @generated
	 */
	private final HandlerManager eventBus;
	
	
	/**
	 * @generated
	 */
	private final ClientFactory clientFactory;
	
	
	/**
	 * @generated
	 */
	private final View view;
	
	public PropertySheetPresenter(HandlerManager eventBus, ClientFactory clientFactory, View view) {
		this.eventBus = eventBus;
		this.clientFactory = clientFactory;
		this.view = view;
		
		bind();
	}
	
	
	/**
	 * @generated
	 */
	private void bind() {
		eventBus.addHandler(DeselectEditPartEvent.TYPE, new DeselectEditPartEventHandler() {
			@Override
			public void onDeselect(DeselectEditPartEvent event) {
				view.clear();
			}
		});
		eventBus.addHandler(SelectEditPartEvent.TYPE, new SelectEditPartEventHandler() {
			@Override
			public void onSelect(SelectEditPartEvent event) {
				BaseNodeEditPart part = event.part;
				Object model = part != null ? part.getModel() : null;
		
				if (model instanceof Node) {
					SectionView section = initializeSection(
							((org.eclipse.gmf.runtime.notation.View) model).getElement(), 
							new PropertySheetSectionView());
					view.add(section);
				}
			}
		});
	}
	
	private SectionView initializeSection(EObject selected, SectionView section) {
		List<IItemPropertyDescriptor> descriptors = clientFactory.getItemDelegator().getPropertyDescriptors(selected);
		List<FeatureEditPresenter> presenters = new ArrayList<FeatureEditPresenter>();
		List<FeatureEditPresenter.View> views = new ArrayList<FeatureEditPresenter.View>();
		FeaturePresenterFactory factory = new FeaturePresenterFactory();
	
		for (IItemPropertyDescriptor descriptor: descriptors) {
			FeatureEditPresenter presenter = factory.create(selected, descriptor);
			if (presenter != null) {
				presenters.add(presenter);
				views.add(presenter.getView());
			}
		}
	
		section.setContent(views);
	
		return section;
	}
	
	protected class FeaturePresenterFactory {
		private EObject data;
		private IItemPropertyDescriptor descriptor;
		private Object feature;
	
		public FeatureEditPresenter create(EObject data, IItemPropertyDescriptor descriptor) {
			this.data = data;
			this.descriptor = descriptor;
			this.feature = descriptor.getFeature(data);
	
			return createFeaturePresenter((EStructuralFeature) feature);
		}
	
		private FeatureEditPresenter createFeaturePresenter(EStructuralFeature eStructureFeature) {
			if (!eStructureFeature.isChangeable() || eStructureFeature.isDerived())
				return null;
	
			EClassifier eType = eStructureFeature.getEType();
			
			if (eStructureFeature instanceof EReference) {
				return createFeatureListPresenter();
			} else if (eType instanceof EDataType) {
				return createFeatureDataPresenter((EDataType) eType);
			} else {
				return new FeatureUniqueEditPresenter(clientFactory, data, descriptor, new TextView());
			}
		}
	
		private FeatureEditPresenter createFeatureDataPresenter(EDataType type) {
			if (!type.isSerializable()) return null;
	
			if (descriptor.isMany(data)) {
				return new FeatureListEditPresenter(clientFactory, data, descriptor, new SingleListView());
			}
			else {
				if (type.getInstanceClass() == Date.class) {
					return new FeatureUniqueEditPresenter(clientFactory, data, descriptor, new DateView());
				} 
				else if (type.getInstanceClass() == Boolean.class || type.getInstanceClass() == boolean.class) {
					return new FeatureUniqueEditPresenter(clientFactory, data, descriptor, new CheckBoxView());
				}
				else if (descriptor.isMultiLine(data)) {
					return new FeatureUniqueEditPresenter(clientFactory, data, descriptor, new TextAreaView());
				}
				else {
					return new FeatureUniqueEditPresenter(clientFactory, data, descriptor, new TextView());
				}
			}
		}
	
		private FeatureEditPresenter createFeatureListPresenter() {
			FeatureListEditPresenter.View view = descriptor.isMany(feature) ?
					new MultipleListView() :
						new SingleListView();
	
			return new FeatureListEditPresenter(clientFactory, data, descriptor, view);
		}
	}
	
	
	
	/**
	 * @generated
	 */
	@Override
	public void goTo(HasWidgets container) {
	}

}
