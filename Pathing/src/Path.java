import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Path extends JPanel{
	
	int xCoords[] = {0,100,255,550};
	int yCoords[] = {0,100,325,350};
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		for(int i = 1; i < xCoords.length; i++) {
			g.drawLine(xCoords[i-1], yCoords[i-1], xCoords[i], yCoords[i]);
		}
	}

}
