package music;

public class Piano extends MusicInstr {
	
	private String name = "Piano";

	public Piano(int price) {
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

