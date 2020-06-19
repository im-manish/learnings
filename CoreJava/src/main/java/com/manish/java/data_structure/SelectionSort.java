package com.manish.java.data_structure;

import java.util.Arrays;

/*
 
 arr[] = 64 25 12 22 11

// Find the minimum element in arr[0...4]
// and place it at beginning
11 25 12 22 64

// Find the minimum element in arr[1...4]
// and place it at beginning of arr[1...4]
11 12 25 22 64

// Find the minimum element in arr[2...4]
// and place it at beginning of arr[2...4]
11 12 22 25 64

// Find the minimum element in arr[3...4]
// and place it at beginning of arr[3...4]
11 12 22 25 64 

Time Complexity: O(n2) as there are two nested loops.

Auxiliary Space: O(1)
*/
/**
 * @author Manish
 *
 */
public class SelectionSort {
	public static void main(String[] args) {
		int[] unsortedArray = {5,4,1,3,2,2,8,7,6};
		int[] sortedArray = selectionSort(unsortedArray);
		System.out.println(Arrays.toString(sortedArray));
	}

	private static int[] selectionSort(int[] unsortedArray) {
		int n = unsortedArray.length;
		for(int i=0;i<n;i++) {
			int minimum =unsortedArray[i];
			int minimumIndex = i;
			for(int j=i;j<n;j++) {
				if(unsortedArray[j] < minimum) {
					minimum = unsortedArray[j];
					minimumIndex = j;
				}
			}
			swap(unsortedArray,i,minimumIndex);
			unsortedArray[i] = minimum;
		}
		return unsortedArray;
		
	}

	private static void swap(int[] unsortedArray, int i, int minimumIndex) {
		int temp = unsortedArray[i];
		unsortedArray[i] = unsortedArray[minimumIndex];
		unsortedArray[minimumIndex] = temp;
		
	}

}
