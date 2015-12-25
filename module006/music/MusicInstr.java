package music;

import myexception.NegativePriceException;

public abstract class MusicInstr {
	
	private String name;
	private int price;
	
	public MusicInstr(String name, int price) {
		try {
			if(price < 0)
				throw new NegativePriceException(price);
			else 
				this.price = price;
		} catch (NegativePriceException e) {
			System.out.println("The price should not be less than zero, and has be: " + e.getPrice() );
			System.exit(-1);
		}
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
