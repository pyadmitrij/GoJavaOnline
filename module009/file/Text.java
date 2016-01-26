package module009.file;

public class Text extends File {
	
	public Text(String name, String type, int size) {
		super(name, type, size);
	}

	@Override
	public void printInfo() {
		System.out.println(getName() + "." + getType() + " "+ getSize());
	}
}
