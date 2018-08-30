import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Path extends ArrayList<Point2D> {
	
	private static final long serialVersionUID = 1L; //not sure why i had to add this
	ArrayList<Point2D> waypoints, genPoints;
	Point2D normalizedP1, normalizedP2;
	Vector normalized, spaced;
	int numOfPoints;
	
	public Path(ArrayList<Point2D> waypoints) {
		this.waypoints = waypoints;
	}
	
	public Path() {
		this.waypoints = new ArrayList<Point2D>();
	}
	
	public void addWaypoint(double x1, double y1) {
		Point2D newWaypoint = new Point2D.Double(x1, y1);
		waypoints.add(newWaypoint);		
	}
	
	public ArrayList<Point2D> injectPoints(double spacing) {
		genPoints = new ArrayList<Point2D>();
		for(int c = 0; c < waypoints.size() - 1; c++) {
			Point2D initial = waypoints.get(c);
			Point2D terminal = waypoints.get(c + 1);
			Vector line = new Vector(initial, terminal);
			this.numOfPoints = (int) (line.getMagnitude() / spacing) ;
			normalized = line.normalize();
			spaced = normalized.multiplyScalar(spacing);
			for(int i = 0; i < numOfPoints; i++) {
				double x = line.getX1() + (spaced.getComponent().getX() * i);
				double y = line.getY1() + (spaced.getComponent().getY() * i);
				Point2D point = new Point2D.Double(x, y);
				genPoints.add(point);
			}
		}	
		genPoints.add(waypoints.get(waypoints.size() - 1));
		return genPoints;
	}
	
}
