package file;

public abstract class File {
	
	private String name = "File";
	private int size;
	
	public File(int size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}
	
	public abstract void printInfo();

}
