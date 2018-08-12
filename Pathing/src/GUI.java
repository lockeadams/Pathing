import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
	
	public GUI() {
		
		Path path = new Path();
		path.repaint();
		
		JFrame window = new JFrame();
		window.setSize(600,400);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Pathing");
		window.add(path);
		
	}
	
}
