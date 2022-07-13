package com.MIT;

/**
 * Complexity O(mlogn)
 * m=rows
 * n=columns
 * Auxiliary Space: O(columns/2) 
 * @author amrmagdy
 *
 */
public class PeakFinding2D {
	
	public int findMatrixPeak(int[][] arr, int rows, int columns) {
		return peakFind(arr, rows, columns, columns/2);
		
	}
	
	private int peakFind(int[][] arr, int rows, int columns, int mid) {
		int peak = -1;
		
		int[] maxClomnValue = findMax(arr, rows, mid);
		int rowIndexOfMaxColValue = maxClomnValue[0];
		int maxValue= maxClomnValue[1];
		
		if((mid== 0 || arr[rowIndexOfMaxColValue][mid] >= arr[rowIndexOfMaxColValue][mid-1]) 
				&& (mid==columns-1 || arr[rowIndexOfMaxColValue][mid] >= arr[rowIndexOfMaxColValue][mid+1]))
			peak = maxValue;
		else if(arr[rowIndexOfMaxColValue][mid-1] > arr[rowIndexOfMaxColValue][mid])
			peak = peakFind(arr, rows, columns, mid - mid/2);
		else
			peak = peakFind(arr, rows, columns, mid + mid/2);
		
		
		
		return peak;
	}

	private int[] findMax(int[][] arr, int rows, int mid) {
		int max=0;
		int maxIndex = 0;
		for(int i=0; i<rows; i++) {
			if(max < arr[i][mid]) {
				max = arr[i][mid];
				maxIndex=i;
			}
			
		}
		int[] maxArr= {maxIndex, max};
		return maxArr;
		
	}
	
	 public static void main(String[] args){
		 PeakFinding2D peakFinding2D = new PeakFinding2D();
	        int[][] arr = {{ 10, 8, 10, 10, 10 },
	                       { 14, 13, 12, 12, 8 },
	                       { 15, 9, 11, 8, 26 },
	                       { 16, 17, 19, 9, 10 }};
	         
	        // Number of Columns
	        int rows = 4, columns = 4;
	        System.out.println(peakFinding2D.findMatrixPeak(arr, rows, columns));
	 }

}
