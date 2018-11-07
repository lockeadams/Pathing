public class Main {
	
	public static void main(String[] args) {
		
		//new GUI();
		Path path = new Path();
		path.addWaypoint(0, 0);
		path.addWaypoint(0, 10);
		path.addWaypoint(10, 10);
		path.smooth(6);
		System.out.println(path.getSmoothed());
		
		
	}
}
