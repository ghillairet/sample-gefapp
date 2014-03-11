package org.sample.gefapp.entities.client.presenter;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.gmf.runtime.gwt.client.ClientFactory;

import com.google.gwt.user.client.ui.HasWidgets;


/**
 * @generated
 */
public  class FeatureUniqueEditPresenter extends FeatureEditPresenter implements Presenter {

	
	
	private final EAttribute attribute;
	
	private final EDataType eDataType;
	
	private final View view;
	
	public FeatureUniqueEditPresenter(ClientFactory clientFactory, Object object, IItemPropertyDescriptor descriptor, View view) {
		super(clientFactory, object, descriptor);
		
		this.view  = view;
		this.attribute = (EAttribute) descriptor.getFeature(object);
		this.eDataType = attribute.getEAttributeType();
		this.view.addEventHandler(viewHandler);
		this.view.getLabel().setText(descriptor.getDisplayName(object));
		
		setValue(getEditableValue());
		clientFactory.getCommandStack().addCommandStackListener(getCommandStackListener());
	}
	
	
	/**
	 * @generated
	 */
	private void bind() {
	}
	
	@Override
	protected void update(Object value) {
		descriptor.setPropertyValue(object, EcoreUtil.createFromString(eDataType, value.toString()));
	}
	
	@Override
	public void setValue(Object value) {
		view.setValue(EcoreUtil.convertToString(eDataType, value));
	}
	
	public EDataType getEDataType() {
		return eDataType;
	}
	
	public View getView() {
		return view;
	};
	
	
	
	/**
	 * @generated
	 */
	@Override
	public void goTo(HasWidgets container) {
	}

}
