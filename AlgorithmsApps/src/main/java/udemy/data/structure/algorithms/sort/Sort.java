package udemy.data.structure.algorithms.sort;

import java.util.Arrays;

public class Sort {
	
	/**
	 * 1) Iterate through the input array from the last index to the first index (excluding the first index).
	   2) For each index i, iterate through the array from the first index up to index i-1 (inclusive).
	   3) Compare the element at the current index j with the element at the next index j+1.
	   4) If the element at index j is greater than the element at index j+1, swap the two elements.
		  After all iterations, the input array will be sorted in ascending order.
	 * @param arr
	 */
	public static void bubbleSort(int[] arr) {
		for(int i=arr.length -1; i>0;i--) {
			for(int j=0; j< i;j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * Idea: loop on area and compare each item with next items in array and get less item and replace with current one
	 * 
	 * 1- loop on array start from 0 by index i
	 * 2- set minIndex = i
	 * 3- loop again on array start index(j) from i+1
	 * 4- compare arr[i] < arr[j] then set minIndex=j
	 * 5- after finish second loop, if i not equal minIndex then replace their values in array 
	 * @param arr
	 */
	public static void selectionSort(int[] arr) {
		for(int i=0; i< arr.length; i++) {
			int minIndex = i;
			for(int j=i+1; j< arr.length;j++) {
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			
			if(i!=minIndex) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}
	
	/**
	 * idea : loop on items starting index[i] is 1 then compare all items before it with current item if bigger than current then swap
	 * 1) loop on array start from 1 by index [i]
	 * 2) set temp = arr[i]
	 * 3) set j equal i-1
	 * 4 while loop if j not equal -1 and array[j] greater than temp
	 * 5) set array[j+1] equal array[j] and array[j] equal temp
	 * 
	 * 
	 * @param arr
	 */
	public static void insertionSort(int[] arr) {
		for(int i = 1; i< arr.length; i++) {
			int temp = arr[i];
			int j = i-1;
			while(j> -1 && temp < arr[j]) {
				arr[j+1] = arr[j];
				arr[j] = temp;
				j--;
			}
		}
	}
	
	public static void main(String[] args) {

        int[] myArray = {4,2,6,5,1,3};

        bubbleSort(myArray);

        System.out.println( "Bubble Sort : " + Arrays.toString(myArray) );
        
        int[] selectionArray = {4,2,6,5,1,3};

        selectionSort(selectionArray);
        
        System.out.println( "Selection Sort : " + Arrays.toString(selectionArray) );
        
        int[] insertionArray = {4,2,6,5,1,3};

        insertionSort(insertionArray);
        
        System.out.println( "Insertion Sort : " + Arrays.toString(insertionArray) );

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6]

         */

    }

}
