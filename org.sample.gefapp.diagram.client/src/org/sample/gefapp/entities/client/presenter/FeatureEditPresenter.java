package org.sample.gefapp.entities.client.presenter;

import java.util.Collection;
import java.util.EventObject;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.gmf.runtime.gwt.client.ClientFactory;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;


/**
 * @generated
 */
public abstract class FeatureEditPresenter implements Presenter {

	
	/**
	 * @generated
	 */
	public interface View {
	
		Label getLabel();
		
		Widget getEditWidget();
		
		int getColSpan();
		
		void setValue(Object value);
		
		void addEventHandler(ViewEventHandler handler);
		
		Widget asWidget();
	
	}
	
	public interface ViewEventHandler {
		void update(Object value);
	}
	
	protected final ViewEventHandler viewHandler = new ViewEventHandler() {
		@Override
		public void update(Object value) {
			FeatureEditPresenter.this.update(value);
		}
	};
	
	protected final ClientFactory clientFactory;
	protected final Object object;
	protected final IItemPropertyDescriptor descriptor;
	protected final CommandStackListener listener;
	
	public FeatureEditPresenter(ClientFactory clientFactory, Object object, IItemPropertyDescriptor descriptor) {
		this.clientFactory = clientFactory;
		this.object = object;
		this.descriptor = descriptor;
		this.listener = getCommandStackListener();
	}
	
	
	/**
	 * @generated
	 */
	private void bind() {
	}
	
	protected abstract void update(Object value);
	
	protected Object getEditableValue() {
		return clientFactory.getItemDelegator().getEditableValue(descriptor.getPropertyValue(object));
	}
	
	protected CommandStackListener getCommandStackListener() {
		return new CommandStackListener() {
			public void commandStackChanged(EventObject event) {
				Command mostRecentCommand = ((CommandStack)event.getSource()).getMostRecentCommand();
	
				if (mostRecentCommand != null) {
					Collection<?> affectedObjects = mostRecentCommand.getAffectedObjects();
					if (!affectedObjects.isEmpty()) {
						Object newSelection = affectedObjects.iterator().next();
						if (newSelection.equals(object)) {
							setValue(getEditableValue());
						}
					}
				}
			}
		};
	}
	
	public abstract void setValue(Object value);
	
	public String getLabel() {
		return descriptor.getDisplayName(object);
	}
	
	public abstract View getView();
	
	@Override
	protected void finalize() throws Throwable {
		clientFactory.getCommandStack().removeCommandStackListener(getCommandStackListener());
		super.finalize();
	}
	
	
	
	/**
	 * @generated
	 */
	@Override
	public void goTo(HasWidgets container) {
	}

}
