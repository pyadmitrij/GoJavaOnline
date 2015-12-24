package myexception;

public class NotNegativeValueException extends Exception {
	
	private int value;
	
	public NotNegativeValueException(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

}
