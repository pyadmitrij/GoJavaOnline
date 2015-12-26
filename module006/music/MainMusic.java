package music;

import myexception.NegativePriceException;

public class MainMusic {

	public static void main(String... args) {
		try {
			MusicShop shop = new MusicShop(new Guitar("Guitar", -150), new Piano("Piano", 550), new Trumpet("Trumpet", 250));
			System.out.println("MusicShop: ");
			for(MusicInstr i : shop.getInstr())
				i.printInfo();
		}
		catch (NegativePriceException e) {
			System.err.println("The size should not be less than zero, and has be: " + e.getPrice());	
		}
	}
}
