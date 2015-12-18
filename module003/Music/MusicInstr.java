package Music;

public abstract class MusicInstr {
	
	private String name = "MusicalInstrument";
	private int price;
	
	public MusicInstr(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	
	public abstract void printInfo();
}
