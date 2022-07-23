package com.MIT.lecture2.sorted.array;

public class InsertSorted {
	
	int insert(int a[], int n, int key, int capacity) {
		if(capacity <= n)
			return n;
		
		int i;
		for(i = n-1;i>=0; i--) {
			if(a[i]<= key)
				break;
			a[i+1] = a[i];
		}
		a[i+1] = key;
		return n+1;
	}
	
	public static void main(String[] args) {
		int arr[] = new int[20];
        arr[0] = 12;
        arr[1] = 16;
        arr[2] = 20;
        arr[3] = 40;
        arr[4] = 50;
        arr[5] = 70;
        int capacity = arr.length;
        int n = 6;
        int key = 26;
 
        System.out.print("\nBefore Insertion: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
 
        InsertSorted insertSorted = new InsertSorted();
         n =insertSorted.insert(arr, n, key, capacity);
        System.out.println("\nAfter Insertion: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        
        
        
	}

}
