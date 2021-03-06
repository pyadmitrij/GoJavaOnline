package array;

public class MainArray {
	
	public static void main(String... args) {
		
		int[] array = new int[] {};
		
		MinMaxSotr.printArray(array);
				
		System.out.println("Min = " + MinMaxSotr.findMin(array) + "\n");
		
		System.out.println("Max = " + MinMaxSotr.findMax(array) + "\n");
		
		MinMaxSotr.sortSelect(array); 
		
		MinMaxSotr.printArray(array);
	}
}
