package module010.file;

import module010.myexception.NegativeSizeException;
import module010.utillist.FileWorker;
import module010.utillist.ListPrintSort;
import module010.utillist.AlgorithmCaesar;

import java.io.FileNotFoundException;

public class MainDirectory {

	public static void main (String... args) {
		try {
			ListPrintSort<File> list = new ListPrintSort<File>();
			AlgorithmCaesar algorithm = new AlgorithmCaesar();
			int key = 1;
			FileWorker worker = new FileWorker();
			String fileName = "directory.txt";

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

			String string = directory.getFile().toString();
			System.out.println("\n" + string);

			string = algorithm.encode(string, key);
			System.out.println("\n" + string);
			worker.writeFile(fileName, string);

			string = worker.readFile(fileName);
			System.out.println("\n" + string);

			string = algorithm.decode(string, key);
			System.out.println(string);

		} catch (NegativeSizeException e) {
			System.err.println("The size should not be less than zero, and has be: " + e.getSize());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
