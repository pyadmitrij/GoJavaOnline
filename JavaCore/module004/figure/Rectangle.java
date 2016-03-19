package module004.figure;

public class Rectangle extends Figure {
	
	private double a;
	private double b;
	
	public Rectangle(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	@Override
	public double area() {
		return a * b;
	}

	@Override
	public void printInfo() {
		System.out.println("The area of a rectangle : " + area());
	}

}
