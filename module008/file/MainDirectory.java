package module008.file;

import module008.listutils.ListPrint;
import module008.listutils.ListSort;
import module008.myexception.NegativeSizeException;

public class MainDirectory {

	public static void main (String... args) {
		try {
			Directory directory = new Directory(new Audio("record001", 1000), new Text("doc001", 10), new Image("image001", 253));

			System.out.println("-----------Directory-----------");

			ListPrint.printList(directory.getFile());

			System.out.println("-----------Directory-----------");

			directory.setFile(new Audio("zzzzz", 1500));

			ListPrint.printList(directory.getFile());

			ListSort.sortList(directory.getFile());

			System.out.println("-----------Directory-----------");

			ListPrint.printList(directory.getFile());

		}
		catch (NegativeSizeException e) {
			System.err.println("The size should not be less than zero, and has be: " + e.getSize() );			
		}
	}
}
