package module008.flower;

import module008.utillist.ListPrintSort;

public class MainFlover {
	
	public static void main(String... args) {

		ListPrintSort list = new ListPrintSort();
		Bouquet bouquet1 = new Bouquet(
				new Rose("Rose", Color.pinc ),
				new Aster("Aster", Color.yellow),
				new Chamomile("Chamomile",Color.white),
				new Tulip("Tulip",Color.red));

		Bouquet bouquet2 = new Bouquet(new RoseBush("RoseBush", Color.red, new Rose[5]));

		System.out.println("---------------Bouquet1---------------");
		list.printList(bouquet1.getFlower());
		System.out.println("\n---------------Bouquet1---------------");
		list.sortList(bouquet1.getFlower());
		list.printList(bouquet1.getFlower());

		System.out.println("\n---------------Bouque2---------------");
	 	list.printList(bouquet2.getFlower());
		bouquet2.setFlower(new RoseBush("RoseBush", Color.pinc, new Rose[6]),
				new RoseBush("RoseBush", Color.white, new Rose[7]));
		System.out.println("\n---------------Bouque2---------------");
		list.printList(bouquet2.getFlower());
		System.out.println("\n---------------Bouque2---------------");
		list.sortList(bouquet2.getFlower());
		list.printList(bouquet2.getFlower());
	}
}
