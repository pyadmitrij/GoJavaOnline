package music;

public class Trumpet extends MusicInstr {

	public Trumpet(String name, int price) {
		super(name, price);
	}
	
	@Override
	public void printInfo() {
		System.out.println(getName() + ", price = " + getPrice());
	}
}

