package file;

import myexception.NegativeSizeException;

public abstract class File {
	
	private String name;
	private int size;
	
	public File(String name, int size) throws NegativeSizeException{
		if(size < 0)
				throw new NegativeSizeException(size);
			else 
				this.size = size;
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
