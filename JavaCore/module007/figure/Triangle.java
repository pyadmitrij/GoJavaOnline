﻿package figure;

public class Triangle extends Figure {
	
	// unknown variable
	private double a;
	
	// unknown variable
	private double b;
	
	public Triangle(double a, double b) {
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
		return a * b / 2;
	}

	@Override
	public void printInfo() {
		System.out.println("The area of a triangle : " + area());				
	}
	

}
