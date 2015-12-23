package array;

public class MainArray {
	
	public static void main(String... args){
		
		int array[] = new int [] {3, 11, 59, 38, 25, 27, 2, 51};
		
		MinMaxSort mms = new MinMaxSort();
		
		mms.findMin(array);
		
		mms.findMax(array);
		
		mms.sortSelect(array);
	}
}
