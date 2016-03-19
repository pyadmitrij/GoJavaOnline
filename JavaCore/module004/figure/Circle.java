package module004.figure;

public class Circle extends Figure {
	
	private final double pi = 3.14;
	private double r;
	
	public Circle (double r){
		this.r = r;
	}
	
	public double getPi() {
		return pi;
	}

	public double getR() {
		return r;
	}

	@Override
	public double area() {
		return pi * ( r * r);
	}

	@Override
	public void printInfo() {
		System.out.println("The area of a circle : " + area());
	}

}
