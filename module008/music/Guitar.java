package module008.music;

public class Guitar extends MusicInstr {
	
	public Guitar(String name, int price) {
		super(name, price);
	}
	
	@Override
	public void printInfo() {
		System.out.println(getName() + ", price = " + getPrice());
	}
}
