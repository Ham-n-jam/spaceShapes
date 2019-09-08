package spaceshapes;

import java.awt.Color;

public class DynamicRectangleShape extends Shape {
	
	Color _white = Color.white;
	Color _col = Color.magenta; //set default alt colour to magenta
	
	/**
	 * Default constructor that creates a RectangleShape instance whose instance
	 * variables are set to default values.
	 */
	public DynamicRectangleShape() {
		super();
	}
	
	/**
	 * Creates a RectangleShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, Color col) {
		super(x,y,deltaX,deltaY);
		_col = col;
	}
	
	/**
	 * Creates a RectangleShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 */
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x,y,deltaX,deltaY,width,height, text);
	}
	
	/**
	 * Creates a RectangleShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 * @param col colour to set the shape after a bounce
	 */
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, Color col) {
		super(x,y,deltaX,deltaY,width,height);
		_col = col;
	}
	
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, String text, Color col) {
		super(x,y,deltaX,deltaY,width,height, text);
		_col = col;
	}
	
	
	protected void doPaint(Painter painter) {
			painter.setColor(_white);
			if(_bouncedLeftRight) {
				painter.setColor(_col);
				painter.drawFilledRect(_x, _y, _width, _height);
				painter.setColor(_white);
			}else {
				painter.drawRect(_x,_y,_width,_height);
			}
	}
	
}
