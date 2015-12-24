package music;

public class MainMusic {

	public static void main(String... args) {
		MusicShop shop = new MusicShop(new Guitar("Guitar", -150), new Piano("Piano", 550), new Trumpet("Trumpet", 250));
		
		System.out.println("MusicShop: ");
		for(MusicInstr i : shop.getInstr())
			i.printInfo();
	}
}
