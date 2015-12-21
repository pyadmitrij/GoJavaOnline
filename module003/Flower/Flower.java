package flower;

public abstract class Flower {
	private String name;
	private Color color;
	
	public Flower(String name, Color color){
		this.name = name;
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
