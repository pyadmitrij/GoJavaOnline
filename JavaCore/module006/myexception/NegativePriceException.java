package myexception;

public class NegativePriceException extends RuntimeException{
	
	private int price;
	
	public NegativePriceException(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}

}
