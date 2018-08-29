import java.awt.Color;
import javax.swing.JFrame;

public class GUI {
	
	public GUI() {
		
		JFrame window = new JFrame();
		window.setSize(600,400);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Pathing");
		window.setBackground(Color.RED);
		
	}
	
}
