package flower;

public class Aster extends Flower {

	public Aster(String name, Color color) {
		super(name, color);
	}

	@Override
	public void printInfo() {
		System.out.println(getName() + ", color " + getColor());
	}


}
