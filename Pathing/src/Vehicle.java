import java.awt.Graphics;
import javax.swing.JLabel;

public class Vehicle extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int[] xPoints = {40, 25, 25};
	int[] yPoints = {10, 5, 15};
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillPolygon(xPoints, yPoints, 3);
	}
	
}
