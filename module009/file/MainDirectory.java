package module009.file;

import module009.myexception.NegativeSizeException;
import module009.utillist.AlgorithmCaesar;
import module009.utillist.ListPrintSort;

public class MainDirectory {

	public static void main (String... args) {
		try {
			ListPrintSort<File> list = new ListPrintSort<>();
			AlgorithmCaesar algorithm = new AlgorithmCaesar();
			Directory directory = new Directory(
					new Audio("record001", "mp3", 1000),
					new Text("doc001", "txt", 10),
					new Image("image001", "gif", 253));

			System.out.println("---------------Directory---------------");
			list.printList(directory.getFiles());

			System.out.println("\n---------------Directory---------------");
			directory.addFile(new Audio("zzzzz", "mp3", 1500), new Text("hello", "txt", 10));
			list.printList(directory.getFiles());
			list.sortList(directory.getFiles());

			System.out.println("\n---------------Directory---------------");
			list.printList(directory.getFiles());

			char key = 0;
			String string = directory.getFiles().toString();
			System.out.println("\n" + string);

			string = algorithm.encode(string, key);
			System.out.println("\n" + string);

			string = algorithm.decode(string, key);
			System.out.println("\n" + string);
		}
		catch (NegativeSizeException e) {
			System.err.println("The size should not be less than zero, and has be: " + e.getSize() );			
		}
	}
}
