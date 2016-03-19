package myexception;

public class NegativeSizeException extends RuntimeException {
	
	private int size;
	
	public NegativeSizeException(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}

}
