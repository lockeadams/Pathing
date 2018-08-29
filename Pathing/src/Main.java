import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Main {

	static int test;
	
	public static void main(String[] args) {
		
		//new GUI();
		
		Point2D initial = new Point2D.Double(0, 0);
		Point2D terminal = new Point2D.Double(3000, 0);
		Vector line = new Vector(initial, terminal);
		ArrayList<Vector> vectors = new ArrayList<Vector>();
		vectors.add(line);
		Path path = new Path(vectors, 0.1);
		System.out.println(path.injectPoints(line));
		
	}
}
