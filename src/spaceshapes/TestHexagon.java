package spaceshapes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


/**
 * A class that implements test cases aimed at identifying bugs in the 
 * implementations of classes Shape and RectangleShape.
 * 
 * @author Alex Bell
 * 
 */
public class TestHexagon {
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
	
	@Test
	public void testSizeGreaterThan40() {
		GemShape shape = new GemShape(50, 50, 10, 10, 50, 50);
		shape.paint(_painter); //6 sided
		assertEquals("(line 50,75,70,50)(line 70,50,80,50)(line 80,50,100,75)(line 100,75,80,100)"
				+ "(line 80,100,70,100)(line 70,100,50,75)", _painter.toString());
	}
	
	@Test
	public void testSizeLessThan40() {
		GemShape shape = new GemShape(50, 50, 10, 10, 30, 30);
		shape.paint(_painter); //4 sided
		assertEquals("(line 50,65,65,50)(line 65,50,80,65)(line 80,65,65,80)"
				+ "(line 65,80,50,65)", _painter.toString());
	}
	
	
}
