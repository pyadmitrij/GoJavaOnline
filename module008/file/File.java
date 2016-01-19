package module008.file;

import module008.myexception.NegativeSizeException;

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

	@Override
	public String toString() {
		return "File{" +
				"name='" + name + '\'' +
				", size=" + size + '}';
	}

	public abstract void printInfo();

}
