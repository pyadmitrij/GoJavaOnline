package music;

import myexception.NotNegativeValueException;

public abstract class MusicInstr {
	
	private String name;
	private int price;
	
	public MusicInstr(String name, int price) {
		try {
		if(price < 0)
			throw new NotNegativeValueException(price);
		else 
			this.price = price;
		} catch (NotNegativeValueException e) {
			System.out.println("[Error]: Entered price is '" + e.getValue() + "' Price should be >= 0!");
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
