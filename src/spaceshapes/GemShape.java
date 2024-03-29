package spaceshapes;

/**
 * Class to represent a simple oval space-shape.
 * 
 * @author Alex Bell
 * 
 */
public class GemShape extends Shape {

	/**
	 * Default constructor that creates a HexgaonShape instance whose instance
	 * variables are set to default values.
	 */
	public GemShape() {
		super();
	}

	/**
	 * Creates a HexgaonShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public GemShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}

	/**
	 * Creates a HexagonShape instance with specified values for instance 
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
	public GemShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	public GemShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x,y,deltaX,deltaY,width,height, text);
	}
	
	/**
	 * Paints this HexagonShape object using the supplied Painter object to 
	 * draw a series of lines.
	 */
	protected void doPaint(Painter painter) {
		if(_width >= 40) { //Draw regular hexagon shape
			painter.drawLine(_x,_y +_height/2,_x + 20,_y); //top left edge
			painter.drawLine(_x + 20,_y,_x + _width - 20,_y); //top middle edge
			painter.drawLine(_x + _width - 20,_y,_x + _width,_y + _height/2); //top right edge
			painter.drawLine(_x + _width,_y + _height/2,_x + _width - 20,_y + _height); //bottom right edge
			painter.drawLine(_x + _width - 20,_y + _height,_x + 20,_y + _height); //bottom middle edge
			painter.drawLine(_x + 20,_y + _height,_x,_y + _height/2); //top middle edge
		}else { //Draw a diamond shape
			painter.drawLine(_x,_y + _height/2, _x +_width/2,_y);//top left edge
			painter.drawLine(_x + _width/2,_y, _x +_width,_y + _height/2);//top right edge
			painter.drawLine(_x +_width,_y + _height/2, _x +_width/2,_y + _height);//bottom right edge
			painter.drawLine(_x +_width/2,_y + _height, _x,_y + _height/2);//bottom right edge
		}
	}
}