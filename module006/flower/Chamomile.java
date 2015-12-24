package flower;

public class Chamomile extends Flower {
	
	public Chamomile(String name, Color color) {
		super(name, color);
	}

	@Override
	public void printInfo() {
		System.out.println(getName() + ", color " + getColor());	
	}
	
}
