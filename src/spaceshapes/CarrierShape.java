package spaceshapes;

import java.util.ArrayList;

public class CarrierShape extends Shape {
	
	private ArrayList<Shape> _children = new ArrayList<Shape>();
	
	/**
	 * Creates a CarrierShape object with default values for state.
	 */
	public CarrierShape() {
		super();
	}
	
	/**
	 * Creates a CarrierShape object with specified location values, default values for other state items.
	 */
	public CarrierShape(int x, int y) {
		super(x,y);
	}
	
	/**
	 * Creates a CarrierShape object with specified values for location, velocity and direction.
	 * Non-specified state items take on default values.
	*/
	public CarrierShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	
	/**
	 * Creates a CarrierShape with specified values for location, velocity, direction, width and height.
	 */
	public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x,y,deltaX,deltaY,width,height, text);
	}
	
	/**
	 * Moves a CarrierShape object (including its children) within the bounds specified by 
	 * arguments width and height.
	 */
	@Override
	public void move(int width, int height) {
		super.move(width, height);
		
		for(Shape s : _children) {
			s.move(_width, _height);
		}
	}
	
	/**
	 * Paints a CarrierShape object by drawing a rectangle around the edge of its bounding box.
	 * The CarrierShape object's children are then painted.
	 */

	@Override
	protected void doPaint(Painter painter) {
		//Draw Carrier
		painter.drawRect(_x,_y,_width,_height);
		painter.translate(_x, _y);
		// Progress the animation.
			for(Shape s : _children) {
				s.paint(painter);
			}
		//Translate back
		painter.translate(-_x, -_y);
	}
	
	/*
	* Attempts to add a Shape to a Carrier Shape object. If successful, a two−way link is 
	* established between the Carrier Shape and the newly added Shape.
	* @param shape the shape to be added.
	* @throws IllegalArgumentException if an attempt is made to add a Shape to a CarrierShape instance
	* where the Shape argument is already a child within a CarrierShape instance.
	* An IllegalArgumentException is also thrown when an attempt is made to add a Shape that will not
	* fit within the bounds of the proposed CarrierShape object.
	* 
	*/
	void add(Shape shape) throws IllegalArgumentException{
		if((shape._container == null) && (shape._width + shape._x <= this.width() + this._x) && 
				(shape._height + shape._y <= this.height() + this._y) ){
			_children.add(shape);
			shape._container = this;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	
	/**
	 * Removes
	 */
	void remove(Shape shape) {
		_children.remove(shape);
		shape._container = null;
	}
	
	/**
	 * Returns
	 */
	public Shape shapeAt(int index) throws IndexOutOfBoundsException{
		if((index > _children.size() - 1) || (index < 0)) {
			throw new IndexOutOfBoundsException();
		}
		return _children.get(index);
	}
	
	/**
	 * Returns
	 */
	public int shapeCount() {
		return _children.size();
	}
	
	/**
	 * Returns
	 */
	public int indexOf(Shape shape) {
		return _children.indexOf(shape);
	}
	
	/**
	 * Returns
	 */
	public boolean contains(Shape shape) {
		return _children.contains(shape);
	}
	
}
