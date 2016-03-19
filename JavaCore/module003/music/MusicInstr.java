package music;

public abstract class MusicInstr {
	
	private String name;
	private int price;
	
	public MusicInstr(String name, int price) {
		this.price = price;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	
	public abstract void printInfo();
}
