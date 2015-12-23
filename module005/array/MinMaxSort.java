package array;

public class MinMaxSort {
		
	public void findMin(int array[]) {
		int min = array[0];
		for(int i = 0; i < array.length; i ++) {
			if(min > array[i])
				min = array[i];
		}
		System.out.println("Min = " + min);		
	}
	
	public void findMax(int array[]) {
		int max = array[0];
		for(int i = 0; i < array.length; i ++) {
			if(max < array[i])
				max = array[i];
		}
		System.out.println("Max = " + max);		
	}
	
	public void sortSelect(int array[]) {
		for (int i = 0; i < array.length; i++) {
		    int min = array[i]; 
		    int iMin = i;
		    for (int j = i+1; j < array.length; j++) {
		        if (array[j] < min) {
		            min = array[j];
		            iMin = j;
		        }
		    }
		    if (i != iMin) {
		        int temp = array[i];
		        array[i] = array[iMin];
		        array[iMin] = temp;
		    }
		    System.out.println(array[i]);
		}
	}
}
