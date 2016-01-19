package module008.flower;

public abstract class Flower {
	private String name;
	private Color color;
	
	public Flower(String name, Color color) {
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "Flower " +
				"'" + name + '\'' +
				", color " + color;
	}

	public abstract void printInfo();
}
