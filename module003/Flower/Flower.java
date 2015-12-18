package Flower;

public abstract class Flower {
	private String name = "Flover";
	private Colors color;
	
	public Flower(Colors color){
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public Colors getColor() {
		return color;
	}
	
	public abstract void printInfo();
}
