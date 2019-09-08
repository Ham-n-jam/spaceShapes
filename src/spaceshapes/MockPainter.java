package spaceshapes;

import java.awt.Color;
import java.awt.Image;

/**
 * Implementation of the Painter interface that does not actually do any
 * painting. A MockPainter implementation responds to Painter requests by
 * logging simply logging them. The contents of a MockPainter object's
 * log can be retrieved by a call to toString() on the MockPainter.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public class MockPainter implements Painter {
	// Internal log.
	private StringBuffer _log = new StringBuffer();

	/**
	 * Returns the contents of this MockPainter's log.
	 */
	public String toString() {
		return _log.toString();
	}

	/**
	 * Logs the drawRect call.
	 */
	public void drawRect(int x, int y, int width, int height) {
		_log.append("(rectangle " + x + "," + y + "," + width + "," + height + ")");
	}
	
	/**
	 * Logs the drawOval call.
	 */
	public void drawOval(int x, int y, int width, int height) {
		_log.append("(oval " + x + "," + y + "," + width + "," + height + ")");
	}

	/**
	 * Logs the drawLine call.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_log.append("(line " + x1 + "," + y1 + "," + x2 + "," + y2 + ")");
	}
	
	/**
	 * Returns java.awt.Color value
	 */
	public Color getColor() {
		return null;
	}
	
	/**
	 * Append the colour of the shape to the log (only used for dynamic shapes)
	 */
	/*
	 * public void setColor(Color c) { _log.append("(" + c.getRed() + " " +
	 * c.getGreen() + " " + c.getBlue() + ")"); }
	 */
	
	/**
	 * Logs the filledRect call
	 */
	public void drawFilledRect(int x, int y, int width, int height) {
		_log.append("(filledRect " +x + "," + y + "," + width + "," + height + ")");
	}


	public void translate(int x, int y) {}

	public void setColor(Color c) {}

	public void drawCentredText(String string, int xPos, int yPos, int width, int height) {
		_log.append("Called drawCenteredText");
		
	}

	public void drawImage(Image img, int x, int y, int width, int height) {}
}