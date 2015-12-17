package Flower;

public class Chamomile extends Flower {

	public Chamomile(String name, String color) {
		super(name, color);
	}

	@Override
	protected void printInfo() {
		System.out.println(getName() + ", color " + getColor());
		
	}

	
}
