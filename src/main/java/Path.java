import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Path {
	
	ArrayList<Vector> vectors;
	ArrayList<Point2D> points;
	Point2D normalizedP1, normalizedP2;
	Vector normalized, spaced;
	int numOfPoints;
	double spacing;
	
	public Path(ArrayList<Vector> vectors, double spacing) {
		this.vectors = vectors;
		this.spacing = spacing;
	}
	
	public ArrayList<Point2D> injectPoints(Vector line) {
		this.numOfPoints = (int) (line.getMagnitude() / spacing) ;
		points = new ArrayList<Point2D>();
		normalized = line.normalize(line);
		spaced = normalized.multiplyScalar(normalized, spacing);
		for(int i = 0; i <= numOfPoints; i++) {
			double x = line.getX1() + (spaced.getComponent().getX() * i);
			double y = line.getY1() + (spaced.getComponent().getY() * i);
			Point2D point = new Point2D.Double(x, y);
			points.add(point);
		}
		
		
		return points;
	}
	
}
