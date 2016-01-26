package module009.file;

import module008.myexception.NegativeSizeException;

public abstract class File {
	
	private String name;
	private String type;
	private int size;
	
	public File(String name,String type, int size) throws NegativeSizeException{
		if(size < 0)
				throw new NegativeSizeException(size);
			else
				this.size = size;
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "File " +
				"'" + name +
				"."+ type + "'"+
				", size = " + size;
	}

	public abstract void printInfo();

}
