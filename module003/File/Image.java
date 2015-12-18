package File;

public class Image extends File {
	
	private String name = "Image";
	
	public String getName() {
		return name;
	}
	
	public Image (int size) {
		super(size);
	}

	@Override
	public void printInfo() {
		System.out.println(getName() + " file," + " size = " + getSize());
	}
}
