package org.sample.gefapp.entities.diagram.part;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.SelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.tools.ConnectionCreationTool;
import org.eclipse.gef.tools.CreationTool;
import org.eclipse.gmf.runtime.gwt.requests.CreateConnectionRequestEx;
import org.eclipse.gmf.runtime.gwt.requests.CreateRequestEx;
import org.eclipse.gmf.runtime.gwt.requests.ModelCreationFactory;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.sample.gefapp.entities.diagram.edit.parts.DomainModelEditPart;

/**
 * @generated
 */
public class EntitiesPaletteFactory {
	/**
	 * @generated
	 */
	public void contributeToPalette(PaletteRoot paletteRoot) {
		PaletteGroup controls = new PaletteGroup("Controls");
		paletteRoot.add(controls);

		ToolEntry tool = new SelectionToolEntry();
		controls.add(tool);
		paletteRoot.setDefaultEntry(tool);

		controls.add(new MarqueeToolEntry());
		paletteRoot.add(createDefault1Group());
	}
	/**
	 * Creates "Default" palette tool group
	 * @generated
	 */
	private PaletteContainer createDefault1Group() {
		PaletteGroup paletteContainer = new PaletteGroup("Default");
		paletteContainer.setDescription("Holds top-level non-container tools");
		{
			PaletteEntry paletteEntry = createEntity1CreationTool();
			if (paletteEntry != null) {
				paletteContainer.add(paletteEntry);
			}
		}
		{
			PaletteEntry paletteEntry = createSuperType2CreationTool();
			if (paletteEntry != null) {
				paletteContainer.add(paletteEntry);
			}
		}
		{
			PaletteEntry paletteEntry = createFeature3CreationTool();
			if (paletteEntry != null) {
				paletteContainer.add(paletteEntry);
			}
		}
		return paletteContainer;
	}
	/**
	 * @generated
	 */
	private ToolEntry createEntity1CreationTool() {
		final int[] visualIds = new int[]{2001};
		NodeToolEntry entry = new NodeToolEntry("Entity", "Create new Entity",
				visualIds);
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}
	/**
	 * @generated
	 */
	private ToolEntry createSuperType2CreationTool() {
		final int[] visualIds = new int[]{4001};
		LinkToolEntry entry = new LinkToolEntry("superType",
				"Create new superTypeConnection", visualIds);
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}
	/**
	 * @generated
	 */
	private ToolEntry createFeature3CreationTool() {
		final int[] visualIds = new int[]{3001};
		NodeToolEntry entry = new NodeToolEntry("Feature",
				"Create new Feature", visualIds);
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}
	/**
	 * @generated
	 */
	private static class NodeToolEntry extends CombinedTemplateCreationEntry {
		/**
		 * @generated
		 */
		private final int[] myVisualIDs;
		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description, int[] visualIDs) {
			super(title, description, new ModelCreationFactory(Node.class),
					null, null);
			myVisualIDs = visualIDs;
		}
		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool result = new CreationTool() {
				protected Request createTargetRequest() {
					CreateRequestEx request = new CreateRequestEx(
							DomainModelEditPart.MODEL_ID, myVisualIDs);
					request.setFactory(getFactory());
					return request;
				}
				protected void performCreation(int button) {
					super.performCreation(button);
					final EditPart createdEditPart = (EditPart) getCurrentViewer()
							.getEditPartRegistry().get(
									getCreateRequest().getNewObject());
					if (createdEditPart != null) {
						getCurrentViewer().getControl().getDisplay()
								.asyncExec(new Runnable() {
									public void run() {
										if (createdEditPart.isActive()) {
											createdEditPart
													.performRequest(new Request(
															RequestConstants.REQ_DIRECT_EDIT));
										}
									}
								});
					}
				}
			};
			result.setProperties(getToolProperties());
			return result;
		}
	}
	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ConnectionCreationToolEntry {
		/**
		 * @generated
		 */
		private final int[] myVisualIDs;
		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description, int[] visualIDs) {
			super(title, description, new ModelCreationFactory(Edge.class),
					null, null);
			myVisualIDs = visualIDs;
		}
		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool result = new ConnectionCreationTool() {
				{
					setUnloadWhenFinished(true);
				}
				protected Request createTargetRequest() {
					CreateConnectionRequestEx request = new CreateConnectionRequestEx(
							DomainModelEditPart.MODEL_ID, myVisualIDs);
					request.setFactory(getFactory());
					return request;
				}
			};
			result.setProperties(getToolProperties());
			return result;
		}
	}
}
