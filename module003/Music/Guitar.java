package music;

public class Guitar extends MusicInstr {
	
	private String name = "Guitar";

	public Guitar(int price) {
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
