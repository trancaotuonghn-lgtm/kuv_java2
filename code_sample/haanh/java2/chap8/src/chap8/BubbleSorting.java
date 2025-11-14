package chap8;

public class BubbleSorting {
	
	public static void bubbleSort(int array[]) {
		int temp;
		for (int i = 0; i < array.length-1; i++) {
			for(int j = 0; j <array.length - i - 1; j++) {
				if(array[j] > array[j+1]) {
					temp = array[j];
					array[j]= array[j+1];
					array[j+1]= temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		
		int array[] = {11,8,2,4,9,10,6,3,7,5,1};
		bubbleSort(array);
		for(int m = 0 ; m < array.length; m++) {
			System.out.print(array[m] + "\n");
			}	
	}
}


