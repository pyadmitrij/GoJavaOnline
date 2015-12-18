package flower;

public class Main {
	
	public static void main(String... args){
	 	Bouquet bouquet = new Bouquet(new Rose("pinc"), new Aster("white"), new Chamomile("white"));
	 	
	 	System.out.println("Bouquet: ");
	 	for(Flower f : bouquet.getFlower())
	 		f.printInfo();
	 	
	 	System.out.println();
	 	
	 	bouquet.setFlower(new Tulip("red"));
	 	
	 	System.out.println("Bouquet: ");
	 	for(Flower f : bouquet.getFlower())
	 		f.printInfo();
	}

}
