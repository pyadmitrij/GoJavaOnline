package flower;

public class MainFlowers {	
	
	public static void main(String... args){
	Bouquet bouquet1 = new Bouquet(new Rose(Color.pinc), new Aster(Color.yellow),
			new Chamomile(Color.white), new Tulip(Color.red));
	Bouquet bouquet2 = new Bouquet(new RoseBush(Color.red, 5));
		 	
	System.out.println("Bouquet1: ");
	for(Flower f : bouquet1.getFlower())
		f.printInfo();
	
	System.out.println();
		 		 	
	System.out.println("Bouquet2: ");
	for(Flower f : bouquet2.getFlower())
		f.printInfo();
		 	
	}
}
