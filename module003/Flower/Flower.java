package Flower;

public abstract class Flower {
	private String name = "Flover";
	private Color color;
	
	public Flower(Color color){
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}
	
	public abstract void printInfo();
}
