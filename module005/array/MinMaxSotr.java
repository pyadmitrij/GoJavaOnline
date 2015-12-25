package array;

public class MinMaxSotr {

	public static int findMin(int [] array) {
		if(array.length == 0) {
			System.out.println("The array is empty!!!");
			return 0;
		} 
		else {
			int min = array[0];
			for(int i = 0; i < array.length; i ++)
				if(min > array[i]) min = array[i];	
			return min;
	   }
	}
	
	public static int findMax(int [] array) {
		if(array.length != 0) {
			int max = array[0];
			for(int i = 0; i < array.length; i++)
				if(max < array[i]) max = array[i];
			return max;
		}
		else {
			System.out.println("The array is empty!!!");
			return 0;   
		}
	}
	
	public static void sortSelect(int [] array) {
		for (int i=0; i < array.length-1; i++) {
			int min = i;
			int temp;
			for (int j = i+1; j < array.length; j++)
				if (array[j] < array[min])
					min = j;
			temp = array[min];
			array[min] = array[i];
	       	array[i] = temp;
		}
	}
	
	public static void printArray(int [] array) {
        for(int i=0; i<array.length; i++)
            System.out.println("array["+ i + "] = " + array[i]);
        System.out.println();
	}
}
