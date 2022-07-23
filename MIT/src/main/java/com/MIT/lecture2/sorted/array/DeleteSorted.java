package com.MIT.lecture2.sorted.array;

public class DeleteSorted {
	
	int binarySearch(int[] a, int low, int high, int key) {
		if(low>high || low < 0 || high> a.length)
			return -1;
		
		int mid = (low+high)/2;
		
		
		if(key == a[mid])
			return mid;
		
		if(key < a[mid])
			return binarySearch(a, low, mid-1, key);
		
		return binarySearch(a, mid+1, high, key);
	}
	
	int delete(int[] a, int key) {
		
		int pos= binarySearch(a, 0, a.length, key);
		System.out.println("pos = " + pos);
		 if (pos == -1) {
	            System.out.println("Element not found");
	            return a.length;
	     }
		
		for(int i =pos; i<a.length-1; i++) {
			a[i] = a[i+1];
		}
		
		return a.length-1;

	}
	
	public static void main(String[] args)
    {
 
        int i;
        int arr[] = { 10, 20, 30, 40, 50 };
 
        int n = arr.length;
        int key = 30;
 
        System.out.print("Array before deletion:\n");
        for (i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
 
        DeleteSorted deleteSorted = new DeleteSorted();
        n = deleteSorted.delete(arr, key);
 
        System.out.print("\n\nArray after deletion:\n");
        for (i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

}
