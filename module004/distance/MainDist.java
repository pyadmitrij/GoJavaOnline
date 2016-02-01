package module004.distance;

public class MainDist {
	
	public static void main (String... args) {
		
		Point a = new Point(-5, 10);
		Point b = new Point(5, 12);
				
		System.out.println("Distance a to b : " + a.distance(b));
		System.out.println("Distance b to a : " + b.distance(a));
		
	}
}
