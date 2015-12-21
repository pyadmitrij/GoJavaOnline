package file;

public class Text extends File {
	
	private String name = "Text";

	public String getName() {
		return name;
	}

	public Text(int size) {
		super(size);
	}

	@Override
	public void printInfo() {
		System.out.println(getName() + " file," + " size = " + getSize());	
	}

}
