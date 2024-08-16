package com.MIT.lecture2.sorted.array.sort;

public class SelectionSort {
	/**
	 * O(n^2)
	 * @param arr
	 */
	void sort(int[] arr) {
		int n = arr.length;
		
		for(int i=0; i< n-1; i++) {
			int mid_index = i;			
			for(int j= i +1; j< n; j++) {
				if(arr[j] < arr[mid_index]) {
					mid_index = j;
				}
			}
			
			if(mid_index != i)
				swap(arr, mid_index, i);
		}
	}
	
	void swap(int[] arr, int firstIndex, int secondIndex) {
		int temp = arr[firstIndex];
		arr[firstIndex] = arr[secondIndex];
		arr[secondIndex] = temp;
	}
	
	// Prints the array
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
	
	public static void main(String[] args) {
		SelectionSort ob = new SelectionSort();
        int arr[] = {64,25,12,22,11};
        ob.sort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
	}
	

}
