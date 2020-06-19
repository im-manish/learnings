package com.manish.java.interview;

/**
 * @author Manish
 *
 */
public class PrintMatrixSpiral {
	
	public static void main(String[] args) {
		int[][] array = { {1,2,5,6},{9,7,8,9},{9,0,7,6}};
		int column = array[0].length;
		int row = array.length;
		printSpiralForm(array,row-1,column-1);
	}

	private static void printSpiralForm(int[][] array, int i, int j) {
		if(i == array.length/2 && j == array[0].length/2) {
			return;
		}
		System.out.println("{"+array[i][j]+"}");
		while(i>0) {
			printSpiralForm(array, --i, ++j);
		}
		while(j>0) {
			printSpiralForm(array, ++i, --j);
		}
		
	}

}
