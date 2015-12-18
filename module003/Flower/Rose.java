package Flower;

public class Rose extends Flower {
	
	private String name = "Rose";

	public Rose(Colors color) {
		super(color);
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void printInfo() {
		System.out.println(getName() + ", color " + getColor());
	}
	
}
