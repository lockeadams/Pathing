import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Vector extends Line2D.Double {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Point2D initial, terminal, normalP1, normalP2, scalarP1, scalarP2;
	public double x1, y1, x2, y2, slope;
	public Vector vector, normalVector, scalarVector;

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
	
	public double getMagnitude() {
		return Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2));
	}
	
	public Point2D getComponent() {
		double compX = x2 - x1;
		double compY = y2 - y1;
		Point2D component = new Point2D.Double(compX, compY);
		return component;
	}
	
	public Vector normalize(Vector vector) {
		normalP1 = new Point2D.Double((vector.getX1() / vector.getMagnitude()), (vector.getY1() / vector.getMagnitude()));
		normalP2 = new Point2D.Double((vector.getX2() / vector.getMagnitude()), (vector.getY2() / vector.getMagnitude()));
		normalVector = new Vector(normalP1, normalP2);
		return normalVector;
	}
	
	public Vector multiplyScalar(Vector vector, double scalar) {
		scalarP1 = new Point2D.Double((vector.getX1() * scalar), (vector.getY1() * scalar));
		scalarP2 = new Point2D.Double((vector.getX2() * scalar), (vector.getY2() * scalar));
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