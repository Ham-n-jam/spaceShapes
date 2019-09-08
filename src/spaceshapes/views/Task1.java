package spaceshapes.views;

import java.util.ArrayList;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import spaceshapes.CarrierShape;
import spaceshapes.Shape;
import spaceshapes.ShapeModel;

/**
 * Adapter class that adapts ShapeModel to the TreeModel target 
 * interface. An instance of Task1 thus allows a ShapeModel
 * object to be displayed by a JTree Swing component.
 * 
 * @author Alex Bell
 * 
 */
public class Task1 implements TreeModel {
	
	protected ArrayList<TreeModelListener> _listeners = new ArrayList<TreeModelListener>();
	
	protected ShapeModel _model;
	
	public Task1(ShapeModel model) {
		_model = model;
	}

	@Override
	public void addTreeModelListener(TreeModelListener listener) {
		_listeners.add(listener);
	}

	@Override
	public Object getChild(Object parentShape, int index) {
		if(parentShape instanceof CarrierShape) {
			CarrierShape carrier =(CarrierShape) parentShape;
			try {
				return carrier.shapeAt(index);
			}catch(IndexOutOfBoundsException error){
				return null;
			}
		}
		return null;
	}

	@Override
	public int getChildCount(Object shape) {
		if(shape instanceof CarrierShape) {
			CarrierShape carrier =(CarrierShape) shape;
			return carrier.shapeCount();
		}
		return 0; //if shape can't have children
	}

	@Override
	public int getIndexOfChild(Object parentShape, Object childShape) {
		if(parentShape instanceof CarrierShape) {
			CarrierShape carrier =(CarrierShape) parentShape;
			if(childShape instanceof Shape) {
				Shape shape = (Shape) childShape;
				return (carrier.indexOf(shape));
			}
		}
		return -1; //return -1 if inputs are null or they do not belong to the tree model
	}

	@Override
	public Object getRoot() {
		return _model.root();
	}

	@Override
	public boolean isLeaf(Object node) {
		if(node instanceof CarrierShape) {
			return false;
		}else if(node instanceof Shape) {
			return true;
		}
		return false;
	}

	@Override
	public void removeTreeModelListener(TreeModelListener listener) {
		_listeners.remove(listener);
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {}

}
