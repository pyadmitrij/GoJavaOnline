package module008.music;

public class Piano extends MusicInstr {
	
	public Piano(String name, int price) {
		super(name, price);
	}

	@Override
	public void printInfo() {
		System.out.println(getName() + ", price = " + getPrice());
	}
}

