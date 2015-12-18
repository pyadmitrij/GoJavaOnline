package flower;

public abstract class Flower {
	private String name = "Flover";
	private String color;
	
	public Flower(String color){
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}
	
	protected abstract void printInfo();
}
