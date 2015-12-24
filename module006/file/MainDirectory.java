package file;

public class MainDirectory {

	public static void main (String... args) {
		
		Directory directory1 = new Directory(new Audio("record001", -1000), new Text("doc001", 10), new Image("image001", 253));
		System.out.println("Directory1: ");
		for(File f : directory1.getFile())
			f.printInfo();
	}
}
