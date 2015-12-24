package file;

public class Text extends File {
	
	public Text(String name, int size) {
		super(name, size);
	}

	@Override
	public void printInfo() {
		System.out.println(getName() + " file," + " size = " + getSize());	
	}

}
