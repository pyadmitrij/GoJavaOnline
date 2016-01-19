package module008.flower;

public class Rose extends Flower {

	public Rose(String name, Color color) {
		super(name, color);
	}
	
	@Override
	public void printInfo() {
		System.out.println(getName() + ", color " + getColor());
	}
	
}
