package music;

import myexception.NegativePriceException;

public abstract class MusicInstr {
	
	private String name;
	private int price;
	
	public MusicInstr(String name, int price) throws NegativePriceException{
		if(price < 0)
			throw new NegativePriceException(price);
		else 
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
