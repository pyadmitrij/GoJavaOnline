package file;

import myexception.NotNegativeValueException;

public abstract class File {
	
	private String name;
	private int size;
	
	public File(String name, int size) {
		try {
			if(size < 0)
				throw new NotNegativeValueException(size);
			else 
				this.size = size;
			} catch (NotNegativeValueException e) {
				System.out.println("[Error]: Entered size is '" + e.getValue() + "' Size should be >= 0!");
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
