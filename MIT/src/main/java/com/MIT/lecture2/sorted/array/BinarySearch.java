package com.MIT.lecture2.sorted.array;

public class BinarySearch {
	
	/**
	 * Complexity O(log n)
	 * @param a
	 * @param low
	 * @param high
	 * @param key
	 * @return
	 */
	int find(int[] a, int low, int high, int key) {
		if(low>high || low < a.length || high> a.length)
			return -1;
		
		int mid = (low+high)/2;
		if(key == a[mid])
			return mid;
		
		if(key < a[mid])
			return find(a, low, mid-1, key);
		
		return find(a, mid+1, high, key);
	}
	
	public static void main(String[] args) {
		int arr[] = { 5, 6, 7, 8, 9, 10 };
		
		BinarySearch binarySearch = new BinarySearch();
		System.out.println(binarySearch.find(arr, 0, arr.length, 18));
	}

}
