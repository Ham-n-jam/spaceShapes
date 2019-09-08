package spaceshapes;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;


/**
 * A class that implements test cases aimed at identifying bugs in the 
 * implementations of classes Shape and RectangleShape.
 * 
 * @author Alex Bell
 */
public class TestDynamicRectangle {
	// Fixture object that is used by the tests.
	private MockPainter _painter;

	/**
	 * This method is called automatically by the JUnit test-runner immediately
	 * before each @Test method is executed. setUp() recreates the fixture so 
	 * that there no side effects from running individual tests.
	 */
	@Before
	public void setUp() {
		_painter = new MockPainter();
	}

	/**
	 * Test left wall bounce
	 */
	@Test
	public void testBounceOffLeft() {
		DynamicRectangleShape shape = new DynamicRectangleShape(50, 50, -60, 0, Color.blue);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(255 255 255)(rectangle 50,50,25,35)(0 0 255)(filledRect 0,50,25,35)(0 0 255)"
				+ "(filledRect 60,50,25,35)", 
				_painter.toString());
	}
	
	/**
	 * Test right wall bounce
	 */
	@Test
	public void testBounceOffRight() {
		DynamicRectangleShape shape = new DynamicRectangleShape(450, 50, 60, 0, Color.blue);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(255 255 255)(rectangle 450,50,25,35)(0 0 255)(filledRect 475,50,25,35)"
				+ "(0 0 255)(filledRect 415,50,25,35)", 
				_painter.toString());
	}

	/**
	 * Test top wall bounce
	 */
	@Test
	public void testBounceOffTop() {
		DynamicRectangleShape shape = new DynamicRectangleShape(50, 50, 0, -60, Color.blue);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(255 255 255)(rectangle 50,50,25,35)(255 255 255)(rectangle 50,0,25,35)"
				+ "(255 255 255)(rectangle 50,60,25,35)", 
				_painter.toString());
	}

	/**
	 * Test bottom wall bounce
	 */
	@Test
	public void testBounceOffBottom() {
		DynamicRectangleShape shape = new DynamicRectangleShape(50, 450, 0, 60, Color.blue);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(255 255 255)(rectangle 50,450,25,35)(255 255 255)(rectangle 50,465,25,35)"
				+ "(255 255 255)(rectangle 50,405,25,35)", 
				_painter.toString());
	}
	
	/**
	 * Test top left corner bounce
	 * hits top wall, then left
	 */
	@Test
	public void testBounceOffTopLeft() {
		DynamicRectangleShape shape = new DynamicRectangleShape(50, 50, -30, -60, Color.blue);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(255 255 255)(rectangle 50,50,25,35)(255 255 255)(rectangle 20,0,25,35)"
				+ "(0 0 255)(filledRect 0,60,25,35)(0 0 255)(filledRect 30,120,25,35)", 
				_painter.toString());
	}
	
	/**
	 * Test top right corner bounce
	 * hits top wall, then right
	 */
	@Test
	public void testBounceOffTopRight() {
		DynamicRectangleShape shape = new DynamicRectangleShape(450, 50, 30, -60, Color.blue);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(255 255 255)(rectangle 450,50,25,35)(255 255 255)(rectangle 475,0,25,35)"
				+ "(255 255 255)(rectangle 445,60,25,35)(255 255 255)(rectangle 415,120,25,35)", 
				_painter.toString());
	}
	
	/**
	 * Test bottom right corner bounce
	 * hits bottom wall, then right
	 */
	@Test
	public void testBounceOffBottomRight() {
		DynamicRectangleShape shape = new DynamicRectangleShape(430, 430, 30, 60, Color.blue);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(255 255 255)(rectangle 430,430,25,35)(255 255 255)(rectangle 460,465,25,35)"
				+ "(0 0 255)(filledRect 475,405,25,35)(0 0 255)(filledRect 445,345,25,35)", 
				_painter.toString());
	}
	
	/**
	 * Test bottom left corner bounce
	 * hits bottom wall, then left
	 */
	@Test
	public void testBounceOffBottomLeft() {
		DynamicRectangleShape shape = new DynamicRectangleShape(50, 430, -30, 60, Color.blue);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(255 255 255)(rectangle 50,430,25,35)(255 255 255)(rectangle 20,465,25,35)"
				+ "(0 0 255)(filledRect 0,405,25,35)(0 0 255)(filledRect 30,345,25,35)", 
				_painter.toString());
	}
	
}
