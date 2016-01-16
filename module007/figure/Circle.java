package figure;

public class Circle extends Figure {
	
	private final double PI = 3.14;
	
	// не понятно, что за переменная
	private double r;
	
	public Circle (double r){
		this.r = r;
	}
	
	public double getPi() {
		return PI;
	}

	public double getR() {
		return r;
	}

	@Override
	public double area() {
		return PI * ( r * r);
	}

	@Override
	public void printInfo() {
		System.out.println("The area of a circle : " + area());
	}

}
