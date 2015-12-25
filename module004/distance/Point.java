package distance;

public class Point {
	
	private double x;

	private double y;
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double distance(Point p){
		return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
	}
	
	public void printPoint() {
		System.out.println("("+ x +";"+ y +")");
	}
}
