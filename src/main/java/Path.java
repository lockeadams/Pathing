import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Path extends ArrayList<Point2D> {
	
	private static final long serialVersionUID = 1L; //not sure why i had to add this
	ArrayList<Point2D> waypoints, injectedPoints, smoothPoints;
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
	
	/**
	 * Takes Path and injects a new Path with a given amount of points 
	 * based on spacing and distance between points in original path.
	 * 
	 * @author Locke Adams
	 * @param spacing
	 */
	public ArrayList<Point2D> injectPoints(double spacing) {
		injectedPoints = new ArrayList<Point2D>();
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
				injectedPoints.add(point);
			}
		}	
		injectedPoints.add(waypoints.get(waypoints.size() - 1));
		return injectedPoints;
	}
	
	/**
	 * Takes path and smooths around the cusps by a given radius.
	 * Higher radius leads to more smoothing, but also more deviation 
	 * from original path.
	 * 
	 * @author Locke Adams
	 * @param radius
	 */
	public ArrayList<Point2D> smooth(int radius) {
		for(int c = 0; c < waypoints.size() - 2; c++) {
			if(injectedPoints == null) {
				Path nullInjected = new Path(waypoints);
				injectedPoints = nullInjected.injectPoints(0.5);
			}
			smoothPoints = new ArrayList<Point2D>(injectedPoints);
			Point2D cusp = new Point2D.Double();
			cusp = waypoints.get(c + 1);
			int cuspIndex = injectedPoints.indexOf(cusp);
			Point2D beforePoint = injectedPoints.get(cuspIndex - 1);
			Point2D afterPoint = injectedPoints.get(cuspIndex + 1);
			double beforeDeltaX = cusp.getX() - beforePoint.getX();
			double beforeDeltaY = cusp.getY() - beforePoint.getY();
			double afterDeltaX = afterPoint.getX() - cusp.getX();
			double afterDeltaY = afterPoint.getY() - cusp.getY();
			double cuspDeltaX = (beforeDeltaX + afterDeltaX) / 2; //cuspDeltaX and Y average the lines before and after to approximate the slope of the cusp
			double cuspDeltaY = (beforeDeltaY + afterDeltaY) / 2;
			//this averages slope of the points +/- radius away from the current point and changes the current point based on that average slope
			System.out.println("radius: " + radius);
			for(int i = 1; i < 2 * radius + 1; i++) {
				int skipCuspConst = 1; //allows us to skip changing the location of the cusp
				if(i < radius + 1) {
					skipCuspConst = 1;
				} else {
					skipCuspConst = 0;
				}
				int currentPointIndex = cuspIndex - radius + (i - skipCuspConst);
				double newDeltaX = ((2 * radius - i) * beforeDeltaX + cuspDeltaX + (i - 1) * afterDeltaX) / (2 * radius);
				double newDeltaY = ((2 * radius - i) * beforeDeltaY + cuspDeltaY + (i - 1) * afterDeltaY) / (2 * radius);
				double newX = injectedPoints.get(currentPointIndex).getX() + newDeltaX;
				double newY = injectedPoints.get(currentPointIndex).getY() + newDeltaY;
				Point2D newPoint = new Point2D.Double(newX, newY);
				smoothPoints.set(currentPointIndex, newPoint);
			}
		}
		return smoothPoints;
	} 
	
}
