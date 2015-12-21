package file;

public class MainDirectory {

	public static void main (String... args) {
		
		Directory directory1 = new Directory(new Audio(1000), new Text(10), new Image(253));
		System.out.println("Directory1: ");
		for(File f : directory1.getFile())
			f.printInfo();
	}
}
