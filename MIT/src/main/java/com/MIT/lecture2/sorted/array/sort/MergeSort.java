package com.MIT.lecture2.sorted.array.sort;

public class MergeSort {
	
	void sort(int[] arr, int low, int high) {
		if(low < high) {
		
			int mid = low +(high - low)/2;
			sort(arr, low, mid);
			sort(arr, mid+1, high);
			merge(arr, low, mid, high);
		}
	}
	
	
	/**
	 * O(nlogn)
	 * 1- Find sizes of two subarrays to be merged
	 * 2- Create temp arrays 
	 * 3- Copy data to temp arrays
	 * 4- Merge the temp arrays by looping them and set value in main array [compare between left[i] and right[j] ]
	 * 5- copy remaining elements in temp arrays to main array
	 * @param arr
	 * @param low
	 * @param mid
	 * @param high
	 */
	void merge(int[] arr, int low, int mid, int high) {
		int n1 = mid - low + 1;
		int n2 = high - mid;
		
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for(int i=0; i< n1; i++)
			left[i] = arr[low + i];
		
		for(int j =0; j<n2; j++) {
			right[j]= arr[mid+1 + j];
		}
		
		int i=0 , j = 0;
		int k=low;
		while(i<n1 && j <n2) {
			if(left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			}else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		
		while(i< n1) {
			arr[k] = left[i];
			i++;
			k++;
		}
		
		while(j<n2) {
			arr[k] = right[j];
			j++;
			k++;
		}
			
	}
	
	  /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
  
    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
  
        System.out.println("Given Array");
        printArray(arr);
  
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);
  
        System.out.println("\nSorted array");
        printArray(arr);
    }

}
