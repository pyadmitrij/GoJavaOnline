package File;

public class Audio extends File {
	
	private String name = "Audio";
	
	public String getName() {
		return name;
	}
	
	public Audio(int size) {
		super(size);
	}

	@Override
	public void printInfo() {
		System.out.println(getName() + " file," + " size = " + getSize());		
	}
}
