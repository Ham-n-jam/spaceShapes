package spaceshapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Simple GUI program to show an animation of shapes in a confined space. Class AnimationViewer is
 * a special kind of GUI component (JPanel), and as such an instance of 
 * AnimationViewer can be added to a JFrame object. A JFrame object is a 
 * window that can be closed, minimised, and maximised. The state of an
 * AnimationViewer object comprises a list of Shapes and a Timer object. An
 * AnimationViewer instance subscribes to events that are published by a Timer.
 * In response to receiving an event from the Timer, the AnimationViewer iterates 
 * through a list of Shapes requesting that each Shape paints and moves itself.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
@SuppressWarnings("serial")
public class AnimationViewer extends JPanel implements ActionListener {
	// Frequency in milliseconds for the Timer to generate events.
	private static final int DELAY = 20;

	// Collection of Shapes to animate.
	private List<Shape> _shapes;

	private Timer _timer = new Timer(DELAY, this);

	/**
	 * Creates an AnimationViewer instance with a list of Shape objects and 
	 * starts the animation.
	 */
	public AnimationViewer() {
		this.setBackground(Color.BLACK);
		_shapes = new ArrayList<Shape>();
	
		// Populate the list of Shapes.
//		_shapes.add(new RectangleShape(0, 0, 2, 3));
//		_shapes.add(new RectangleShape(10, 10, 4, 2));
//		_shapes.add(new OvalShape(20,20,3, 5));
//		_shapes.add(new OvalShape(50,50,4, 4, 6, 6));
//		_shapes.add(new HexagonShape(30, 30, 3, 2));
//		_shapes.add(new HexagonShape(20, 30, 3, 2, 30, 100));
//		_shapes.add(new HexagonShape(40 ,0 ,1 , 1, 80, 45));
		_shapes.add(new DynamicRectangleShape(12, 12, 3, 4, Color.orange));
//		_shapes.add(new DynamicShape(20, 45, 4, 4, 20, 45, Color.pink));
		
		CarrierShape _topCarrier = new CarrierShape(25, 25, 2, 2, 200, 200);
		_shapes.add(_topCarrier);
		_topCarrier.add(new RectangleShape(10, 10, 4, 2));
		_topCarrier.add(new OvalShape(50,50,1, 2, 8, 8));
		
		CarrierShape _middleCarrier = new CarrierShape(25, 25, 2, 2, 100, 150);
		_topCarrier.add(_middleCarrier);
		_middleCarrier.add(new RectangleShape(10, 10, 4, 2));
		_middleCarrier.add(new OvalShape(50,50,4, 4, 6, 6));
		
		CarrierShape _bottomCarrier = new CarrierShape(25, 25, 2, 2, 60, 75);
		_middleCarrier.add(_bottomCarrier);
		DynamicRectangleShape dynashape = new DynamicRectangleShape(12, 12, 3, 3, Color.orange);
		_bottomCarrier.add(dynashape);
		
		
		// Start the animation.
		_timer.start();
	}

	/**
	 * Called by the Swing framework whenever this AnimationViewer object
	 * should be repainted. This can happen, for example, after an explicit 
	 * repaint() call or after the window that contains this AnimationViewer 
	 * object has been opened, exposed or moved.
	 * 
	 */
	public void paintComponent(Graphics g) {
		// Call inherited implementation to handle background painting.
		super.paintComponent(g);
		
		// Calculate bounds of animation screen area.
		int width = getSize().width;
		int height = getSize().height;
		
		// Create a GraphicsPainter that Shape objects will use for drawing.
		// The GraphicsPainter delegates painting to a basic Graphics object.
		Painter painter = new GraphicsPainter(g);
		
		// Progress the animation.
		for(Shape s : _shapes) {
			s.paint(painter);
			s.move(width, height);
		}
		
		//add text
		_shapes.get(0).setText("Bro! You just posted cringe!");
		_shapes.get(1).setText("Ehhhhhhh?!");
		CarrierShape carrier = (CarrierShape) _shapes.get(1);
		carrier.shapeAt(0).setText("E");
		CarrierShape carrier2 = (CarrierShape) carrier.shapeAt(2);
		carrier2.shapeAt(1).setText("AEI");
		CarrierShape carrier3 = (CarrierShape) carrier2.shapeAt(2);
		carrier3.shapeAt(0).setText("WRRRYYY");

		
		
	}

	/**
	 * Notifies this AnimationViewer object of an ActionEvent. ActionEvents are
	 * received by the Timer.
	 */
	public void actionPerformed(ActionEvent e) {
		// Request that the AnimationViewer repaints itself. The call to 
		// repaint() will cause the AnimationViewer's paintComponent() method 
		// to be called.
		repaint();
	}
	
	
	/**
	 * Main program method to create an AnimationViewer object and display this
	 * within a JFrame window.
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Animation viewer");
				frame.add(new AnimationViewer());
		
				// Set window properties.
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}
