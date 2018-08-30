import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Vector extends Line2D.Double {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Point2D initial, terminal, normalP1, normalP2, scalarP1, scalarP2;
	public double x1, y1, x2, y2, slope;
	public Vector normalVector, scalarVector;

	public Vector(Point2D initial, Point2D terminal) {
		this.initial = initial;
		this.terminal = terminal;
		this.x1 = initial.getX();
		this.y1 = initial.getY();
		this.x2 = terminal.getX();
		this.y2 = terminal.getY();
		this.slope = (y2-y1)/(x2-x1);
		//this.vector = new Vector(initial, terminal);
	}
	
	public Vector(int x1, int y1, int x2, int y2) {
		this.initial = new Point2D.Double(x1, y1);
		this.terminal = new Point2D.Double(x2, y2);
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.slope = (y2-y1)/(x2-x1);
	}
	
	public double getMagnitude() {
		return Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2));
	}
	
	public Point2D getComponent() {
		double compX = x2 - x1;
		double compY = y2 - y1;
		Point2D component = new Point2D.Double(compX, compY);
		return component;
	}
	
	public Vector normalize() {
		normalP1 = new Point2D.Double((x1 / Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2))), (y1 / Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2))));
		normalP2 = new Point2D.Double((x2 / Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2))), (y2 / Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2))));
		normalVector = new Vector(normalP1, normalP2);
		return normalVector;
	}
	
	public Vector multiplyScalar(double scalar) {
		scalarP1 = new Point2D.Double((x1 * scalar), (y1 * scalar));
		scalarP2 = new Point2D.Double((x2 * scalar), (y2 * scalar));
		scalarVector = new Vector(scalarP1, scalarP2);
		return scalarVector;		
	}
	
	public Point2D getP1() {
		return initial;
	}

	public Point2D getP2() {
		return terminal;
	}

	public double getX1() {
		return x1;
	}

	public double getX2() {
		return x2;
	}

	public double getY1() {
		return y1;
	}

	public double getY2() {
		return y2;
	}


}