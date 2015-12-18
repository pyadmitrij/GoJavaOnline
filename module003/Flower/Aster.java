package Flower;

public class Aster extends Flower {
	
	private String name = "Aster";
	
	public String getName() {
		return name;
	}


	public Aster(Color color) {
		super(color);
	}

	@Override
	public void printInfo() {
		System.out.println(getName() + ", color " + getColor());
	}


}
