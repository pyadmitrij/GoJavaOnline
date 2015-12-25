package file;

import myexception.NegativeSizeException;

public abstract class File {
	
	private String name;
	private int size;
	
	public File(String name, int size) {
		try {
			if(size < 0)
				throw new NegativeSizeException(size);
			else 
				this.size = size;
			} catch (NegativeSizeException e) {
				System.out.println("The size should not be less than zero, and has be: " + e.getSize() );
				System.exit(-1);
			}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}
	
	public abstract void printInfo();

}
