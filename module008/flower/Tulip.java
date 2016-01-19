package module008.flower;

public class Tulip extends Flower {
	
	public Tulip(String name, Color color) {
		super(name, color);
	}

	@Override
	public void printInfo() {
		System.out.println(getName() + ", color " + getColor());		
	}

}
