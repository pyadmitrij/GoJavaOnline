package module010.file;

public class Audio extends File {

	public Audio(String name, String type, int size) {
		super(name, type, size);
	}

	@Override
	public void printInfo() {

		System.out.println(getName() + "." + getType() + " "+ getSize());
	}
}
