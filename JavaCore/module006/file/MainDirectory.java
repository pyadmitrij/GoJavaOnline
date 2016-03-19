package file;

import myexception.NegativeSizeException;

public class MainDirectory {

	public static void main (String... args) {
		try {
			Directory directory1 = new Directory(new Audio("record001", -1000), new Text("doc001", 10), new Image("image001", 253));
			System.out.println("Directory1: ");
			for(File f : directory1.getFile())
				f.printInfo();
		}
		catch (NegativeSizeException e) {
			System.err.println("The size should not be less than zero, and has be: " + e.getSize() );			
		}
	}
}
