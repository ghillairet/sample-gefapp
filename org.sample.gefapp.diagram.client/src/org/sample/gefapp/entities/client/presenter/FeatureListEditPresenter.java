package org.sample.gefapp.entities.client.presenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.gmf.runtime.gwt.client.ClientFactory;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ListBox;


/**
 * @generated
 */
public  class FeatureListEditPresenter extends FeatureEditPresenter implements Presenter {

	public interface View extends FeatureEditPresenter.View {
		ListBox getListBox();
	}
	
	
	private View view;
	
	public FeatureListEditPresenter(ClientFactory clientFactory, Object object, IItemPropertyDescriptor descriptor, View view) {
		super(clientFactory, object, descriptor);
		
		this.view  = view;
		this.view.getLabel().setText(descriptor.getDisplayName(object));
		
		initialize();
	}
	
	
	/**
	 * @generated
	 */
	private void bind() {
	}
	
	protected void initialize() {
		Object value = getEditableValue();
		List<?> optionals = (List<?>) descriptor.getChoiceOfValues(object); 
		List<?> values;
	
		if (!descriptor.isMany(object)) {
			values = Collections.singletonList(value);
			view.getListBox().setVisibleItemCount(1);
		} else {
			values = (List<?>) value;
			view.getListBox().setVisibleItemCount(values.size());
		}
	
		setValue(values);
	
		if (!descriptor.isMany(object)) {
			setValue(optionals);
		}
	}
	
	@Override
	public void setValue(Object value) {
		List<?> values = (List<?>) value;
		IItemLabelProvider labelProvider = descriptor.getLabelProvider(object);
		List<?> oldValues = (List<?>) values;
		List<Object> oldValueSelection = new ArrayList<Object>();
		int valueBoxItemCount = view.getListBox().getItemCount();
	
		if (valueBoxItemCount != 0) {
			for (int i = 0; i < valueBoxItemCount; ++i) {
				if (view.getListBox().isItemSelected(i) && oldValues.size() > i) {
					oldValueSelection.add(oldValues.get(i));
				}
			}
			view.getListBox().clear();
		}
	
		for (Object val : values) {
			view.getListBox().addItem(labelProvider.getText(val));
	
			if (oldValueSelection.contains(val) || oldValues != null && !oldValues.contains(val)) {
				view.getListBox().setItemSelected(view.getListBox().getItemCount() - 1, true);
			}
		}
	}
	
	@Override
	protected void update(Object value) {
		List<?> optionals = (List<?>) descriptor.getChoiceOfValues(object);
		if (value instanceof Integer) {
			Object selected = optionals.get((Integer) value);
			descriptor.setPropertyValue(object, selected);
		}
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
