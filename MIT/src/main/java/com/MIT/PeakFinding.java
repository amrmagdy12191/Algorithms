package com.MIT;

public class PeakFinding {
	
	int peakFinding(int [][] matrix, int row, int col){
		int currentVal, leftVal, rightVal, aboveVal, belowVal;
			
		
		currentVal = getMatrixValue(row, col, matrix);
		leftVal =  getMatrixValue(row, col-1, matrix);
		rightVal= getMatrixValue(row, col+1, matrix);
		aboveVal = getMatrixValue(row-1, col, matrix);
		belowVal = getMatrixValue(row+1, col, matrix);
		
		
		int peak=-1;
		if(currentVal>= leftVal && currentVal>= rightVal && currentVal>= aboveVal && currentVal>= belowVal) {
			peak = currentVal;
		}else {
			if(currentVal >= leftVal && currentVal>= rightVal )
				peak = currentVal;
			else {
				if(leftVal>=currentVal&& leftVal>=rightVal)
					peak = peakFinding(matrix, row, col-1);
				else if(rightVal >= currentVal && rightVal >= leftVal)
					peak = peakFinding(matrix, row, col+ 1);
			}
			
			System.out.println("peak row : " + peak);
			//if(col == 1) {
				if(belowVal >= currentVal && belowVal>= aboveVal)
					peak = peakFinding(matrix, row, col+1);
				else if(aboveVal >= currentVal && aboveVal>= currentVal)
					peak = peakFinding(matrix, row, col-1);
				else
					peak = currentVal;	
		//	}
						
			
		}

		System.out.println(peak);
		return peak;
		
	}
	
	int getMatrixValue(int i, int j, int[][]matrix){
		if(i>0 && i <matrix.length && j>0 && j <matrix[0].length) {
			System.out.println(matrix[i][j]);
			return matrix[i][j];
		}
		return -1;
	}

}
