package Flower;

public class Rose extends Flower {

	protected Rose(String name, String color) {
		super(name, color);
	}

	@Override
	protected void printInfo() {
		System.out.println(getName() + ", color " + getColor());
	}
	
}
