package module008.music;

import module008.myexception.NegativePriceException;
import module008.utillist.ListPrintSort;

public class MainMusic {

	public static void main(String... args) {
		ListPrintSort list = new ListPrintSort<>();
		try {
			MusicShop shop = new MusicShop(
					new Guitar("Guitar", 150),
					new Piano("Piano", 550),
					new Trumpet("Trumpet", 250));

			System.out.println("---------------MusicShop---------------");
			list.printList(shop.getInstrument());

			shop.setInstrument(new Guitar("ElectroGuitar", 200), new Piano("ElectroPiano", 600));

			System.out.println("\n---------------MusicShop---------------");
			list.printList(shop.getInstrument());

			System.out.println("\n---------------MusicShop---------------");
			list.sortList(shop.getInstrument());
			list.printList(shop.getInstrument());
		}
		catch (NegativePriceException e) {
			System.err.println("The size should not be less than zero, and has be: " + e.getPrice());	
		}
	}
}
