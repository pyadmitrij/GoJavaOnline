package flower;

public class Main {
	
	public static void main(String... args){
	 	Bouquet bouquet1 = new Bouquet(new Rose("pinc"), new Aster("white"), new Chamomile("white"), new Tulip("red"));
	 	Bouquet bouquet2 = new Bouquet(new RoseBush("red", 5));
	 	
	 	System.out.println("Bouquet1: ");
	 	for(Flower f : bouquet1.getFlower())
	 		f.printInfo();
	 	System.out.println();
	 		 	
	 	System.out.println("Bouquet2: ");
	 	for(Flower f : bouquet2.getFlower())
	 		f.printInfo();
	 	
	}
}
