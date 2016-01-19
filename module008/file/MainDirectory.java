package module008.file;

import module008.utillist.ListPrintSort;
import module008.myexception.NegativeSizeException;

public class MainDirectory {

	public static void main (String... args) {
		try {
			ListPrintSort<File> list = new ListPrintSort<>();
			Directory directory = new Directory(
					new Audio("record001", "mp3", 1000),
					new Text("doc001", "txt", 10),
					new Image("image001", "gif", 253));

			System.out.println("---------------Directory---------------");
			list.printList(directory.getFile());

			System.out.println("\n---------------Directory---------------");
			directory.setFile(new Audio("zzzzz", "mp3", 1500), new Text("hello", "txt", 10));
			list.printList(directory.getFile());
			list.sortList(directory.getFile());

			System.out.println("\n---------------Directory---------------");
			list.printList(directory.getFile());

		}
		catch (NegativeSizeException e) {
			System.err.println("The size should not be less than zero, and has be: " + e.getSize() );			
		}
	}
}
