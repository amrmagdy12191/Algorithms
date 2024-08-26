package udemy.data.structure.algorithms.sort;

import java.util.Arrays;

public class MergeSort {
	
	/**
	 * Idea : split array to two half then call recursion merge sort for each half
	 * Then merge both left and right half by calling merge method and return sorted array
	 * Stop condition : array length == 1 then return array
	 * @param array
	 * @return
	 */
	public static int[] mergeSort(int[] array) {
		if(array.length == 1) return array;
		
		int midIndex = array.length/2;
		int[] leftArray = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
		int[] rightArray = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));
		return merge(leftArray, rightArray);
	}
	/**
	 * Idea: create combined array to merge both sorted arrays then loop on both arrays 
	 * and compare each item with remaining items in other array and add smallest to combined array
	 * until find greater item then add current small item and switch loop on other array and compare and so on
	 * then add remaining items of arrays if exist to combined array
	 * 1- create combined array
	 * 2- create index for combined and i for array1 and j for array2
	 * 3- loop using while i < array1 length and j < array2 length
	 * 4- if array1[i] < array2[j] then add array[i] to combined[index] and index++ and i++
	 * 5  else do the same for array2[j] to combined[index] and index++ and j++
	 * 6- while loop i less than array1.length then add array1[i] to combined[index] and index++,i++
	 * 7- while loop j less than array1.length then add array2[j] to combined[index] and index++,j++
	 * 8- return combined[index]
	 * @param array1
	 * @param array2
	 * @return merged sorted array
	 */
	public static int[] merge(int[] array1, int[] array2) {
		int[] combined = new int[array1.length + array2.length];
		int index = 0;
		int i = 0;
		int j = 0;
		while(i< array1.length && j< array2.length) {
			if(array1[i] < array2[j]) {
				combined[index] = array1[i];
				index++;
				i++;
			}else {
				combined[index] = array2[j];
				index++;
				j++;
			}
		}
		
		while(i<array1.length) {
			combined[index] = array1[i];
			index++;
			i++;
		}
		
		while(j<array2.length) {
			combined[index] = array2[j];
			index++;
			j++;
		}
		
		return combined;
	}

	public static void main(String[] args) {
		int[] array1 = {1,3,7,8};
        int[] array2 = {2,4,5,6};

        System.out.println( "Merged Array : " + Arrays.toString(merge(array1, array2)) );

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6, 7, 8]

         */
        
        int[] originalArray = {3,1,4,2};

        int [] sortedArray = mergeSort(originalArray);

        System.out.println( "\nOriginal Array: " + Arrays.toString( originalArray ) );

        System.out.println( "\nSorted Array: " + Arrays.toString( sortedArray ) );

        /*
            EXPECTED OUTPUT:
            ----------------
            Original Array: [3, 1, 4, 2]
            
            Sorted Array: [1, 2, 3, 4]

         */

	}

}
