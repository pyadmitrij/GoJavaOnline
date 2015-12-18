package Music;

public class Trumpet extends MusicInstr {
	
	private String name = "Trumpet";

	public Trumpet(int price) {
		super(price);
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void printInfo() {
		System.out.println(getName() + ", price = " + getPrice());
	}
}

