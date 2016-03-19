package flower;

public class MainFlover {
	
	public static void main(String... args){
		
		Bouquet bouquet1 = new Bouquet(new Rose("Rose", Color.pinc ), new Aster("Aster", Color.yellow),
				new Chamomile("Chamomile",Color.white), new Tulip("Tulip",Color.red));
	 	Bouquet bouquet2 = new Bouquet(new RoseBush("RoseBush", Color.red));
	 	
	 	System.out.println("Bouquet1: ");
	 	for(Flower f : bouquet1.getFlower())
	 		f.printInfo();
	 	System.out.println();
	 		 	
	 	System.out.println("Bouquet2: ");
	 	for(Flower f : bouquet2.getFlower())
	 		f.printInfo();
	 	
	}
}
