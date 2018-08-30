public class Main {

	static int test;
	
	public static void main(String[] args) {
		
		//new GUI();
		
		Path path = new Path();
		path.addWaypoint(0, 0);
		path.addWaypoint(10, 0);
		path.addWaypoint(20, 10);
		System.out.println(path.injectPoints(0.5));
		
		
	}
}
