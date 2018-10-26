public class Main {
	
	public static void main(String[] args) {
		
		//new GUI();
		Path path = new Path();
		path.addWaypoint(0, 0);
		path.addWaypoint(0, 10);
		path.addWaypoint(10, 10);
		//System.out.println(path.injectPoints(0.5));
		System.out.println(path.smooth(3)); 

		
	}
}
