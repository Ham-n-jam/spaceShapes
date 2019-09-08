package spaceshapes;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;


/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics _g;
	
	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this._g = g;
		_g.setColor(new Color(212, 212, 212));
	}

	/**
	 * @see spaceshapes.Painter.drawRect
	 */
	public void drawRect(int x, int y, int width, int height) {
		_g.drawRect(x, y, width, height);
	}

	/**
	 * @see spaceshapes.Painter.drawOval
	 */
	public void drawOval(int x, int y, int width, int height) {
		_g.drawOval(x, y, width, height);
	}

	/**
	 * @see spaeshapes.Painter.drawLine.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_g.drawLine(x1, y1, x2, y2);
	}
	
	/**
	 * Returns java.awt.Color value
	 */
	public Color getColor() {
		return _g.getColor();
	}
	
	/**
	 * Sets a new color
	 */
	public void setColor(Color c) {
		_g.setColor(c);
	}
	
	/**
	 * Draw filledRect
	 */
	public void drawFilledRect(int x, int y, int width, int height) {
		_g.fillRect(x, y, width, height);
	}
	
	public void translate(int x, int y) {
		_g.translate(x, y);
		
	}

	public void drawCentredText(String string, int xPos, int yPos, int width, int height) {
		//Setup font
		FontMetrics stringDimensions = _g.getFontMetrics();
		int ascent = stringDimensions.getAscent();
		int descent = stringDimensions.getDescent();
		
		int x = xPos + (width - stringDimensions.stringWidth(string))/2;
		int y;
		//Change y position based on the font ascents and descents
		if(ascent == descent) {
			y = yPos + height/2;
		}else if(ascent > descent) {
			y = yPos + height/2 + (ascent - descent)/2;
		}else {
			y = yPos + height/2 + (descent - ascent)/2;
		}
		
		_g.drawString(string, x, y);
	}

	public void drawImage(Image img, int x, int y, int width, int height) {
		_g.drawImage(img, x, y, width, height, null);
		
	}
	
}
