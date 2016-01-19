package module008.file;

public class Image extends File {
		
	public Image (String name, int size) {
		super(name, size);
	}

	@Override
	public void printInfo() {
		System.out.println(getName() + "." + getSize());
	}
}
