package module010.file;

import module010.myexception.NegativeSizeException;
import module010.utillist.ListPrintSort;
import module010.utillist.AlgorithmCaesar;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainDirectory {

	public static void main (String... args) throws IOException {
		try (FileWriter fileW = new FileWriter("MyText.txt"); FileReader fileR = new FileReader("MyText.txt")) {
			ListPrintSort<File> list = new ListPrintSort<File>();

			AlgorithmCaesar algorithm = new AlgorithmCaesar();

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

			int key = 0;
			String string = directory.getFile().toString();
			System.out.println("\n" + string);

			System.out.println("\n" + algorithm.encode(string, key));

			fileW.write(algorithm.encode(string, key));

			System.out.println("\n" + algorithm.decode(string, key));

		}
		catch (NegativeSizeException e) {
			System.err.println("The size should not be less than zero, and has be: " + e.getSize() );			
		}
		catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
