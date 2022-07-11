package com.MIT;

public class Main {
	public static void main(String[] args) {
		int [][] matrix = new int[4][4];
		matrix[0][0] = 10;
		matrix[0][1] = 8;
		matrix[0][2] = 10;
		matrix[0][3] = 10;
		
		matrix[1][0] = 14;
		matrix[1][1] = 13;
		matrix[1][2] = 12;
		matrix[1][3] = 11;
		
		matrix[2][0] = 15;
		matrix[2][1] = 9;
		matrix[2][2] = 11;
		matrix[2][3] = 21;
		
		matrix[3][0] = 16;
		matrix[3][1] = 17;
		matrix[3][2] = 19;
		matrix[3][3] = 20;
		
		PeakFinding peakFinding = new PeakFinding();
		System.out.println(peakFinding.peakFinding(matrix, 0, 2));
	}
}
