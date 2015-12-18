package Music;

public class MainMusic {

	public static void main(String... args) {
		MusicShop shop = new MusicShop(new Guitar(150), new Piano(550), new Trumpet(250));
		
		System.out.println("MusicShop: ");
		for(MusicInstr i : shop.getInstr())
			i.printInfo();
	}
}
