package com.MIT;

public class PeakFinding1D {
	
	static enum PeakType{RECURSIVE, ITERATIVE}
	
	private int findPeakRecursiveUtil(int[] a, int low, int high, int length) {
		int peak = -1;
		int mid= low + (high-low)/2;
		
		if((mid==0 || a[mid] >= a[mid-1])
				&& (mid == length-1 || a[mid] >= a[mid+1]))
			peak = a[mid];
		
		else if(mid>0 && a[mid-1] > a[mid])
			peak = findPeakRecursiveUtil(a, low, mid-1, length);
			
		else
			peak = findPeakRecursiveUtil(a, mid+1, high, length);
			
		return  peak;
	}
	
	private int findPeakIterativeUtil(int[] a, int n) {
		int peak = -1;
		
		int i=0;
		int length = n;
		int mid=0;
		while(i<length) {
			mid = i + (length-i)/2;
			if((mid ==0 || a[mid] >= a[mid-1])
					&& (mid==length-1 || a[mid] >= a[mid+1])) {
				peak = a[mid];
				break;
			}else if(a[mid-1]>a[mid]) {
				length=mid-1;
			}else {
				i=mid+1;
			}		
		}
		return peak;
	}
	
	private int findPeak(int[] array, int n, PeakFinding1D.PeakType peakType) {
		if(PeakType.RECURSIVE.equals(peakType))
			return findPeakRecursiveUtil(array, 0, n-1, n);
		else if(PeakType.ITERATIVE.equals(peakType))
			return findPeakIterativeUtil(array, n);
		else
			return 0;
	}
	
	
	
	public static void main(String[] args) {
		PeakFinding1D finding1d = new PeakFinding1D();
		
		int array[] = {19, 20, 12, 2, 23, 90, 91};
		System.out.println(finding1d.findPeak(array, array.length, PeakFinding1D.PeakType.RECURSIVE));
		System.out.println(finding1d.findPeak(array, array.length, PeakFinding1D.PeakType.ITERATIVE));
	}



}
