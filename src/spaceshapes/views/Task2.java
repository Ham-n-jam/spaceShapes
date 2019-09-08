package spaceshapes.views;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;

import spaceshapes.Shape;
import spaceshapes.ShapeModel;
import spaceshapes.ShapeModelEvent;
import spaceshapes.ShapeModelEvent.EventType;
import spaceshapes.ShapeModelListener;

/*
 * Can both render a ShapeModel's shape composition and respond to changes that occur in
 * the ShapeModel.
 * 
 */

public class Task2 extends Task1 implements ShapeModelListener {

	public Task2(ShapeModel model) {
		super(model);
	}
	
	/*
	 * Adapts the ShapeModelEvent to a TreeModelEvent and fires it to all of the
	 * attached TreeModelListeners.
	 */
	
	@Override
	public void update(ShapeModelEvent event) {
		
		ShapeModel source = event.source();
		
		int[] childIndices = new int[1];
		childIndices[0] = event.index();
		
		Shape[] children = new Shape[1];
		children[0] = event.operand();
		
		
		
		if(event.eventType().equals(EventType.ShapeAdded)){
			TreeModelEvent treeModelEvent = new TreeModelEvent(source, event.parent().path().toArray(), childIndices, children);
			fireTreeNodesInserted(treeModelEvent);
			
		}else if(event.eventType().equals(EventType.ShapeRemoved)){
			TreeModelEvent treeModelEvent = new TreeModelEvent(source, event.parent().path().toArray(), childIndices, children);
			fireTreeNodesRemoved(treeModelEvent);
		}
		
	}
	
	/*
	 * Iterate through registered TreeModelListeners and fire different 
	 * TreeModelEvents to each in turn.
	 */
	private void fireTreeNodesInserted(TreeModelEvent event) {
		for(TreeModelListener listener : _listeners) {
			listener.treeNodesInserted(event);
		}
	}
	
	private void fireTreeNodesRemoved(TreeModelEvent event) {
		for(TreeModelListener listener : _listeners) {
			listener.treeNodesRemoved(event);
		}
	}
		
}