package com.manish.java.data_structure;

import java.util.Arrays;

/**
 * @author Manish
 * 
 * 12, 11, 13, 5, 6

Let us loop for i = 1 (second element of the array) to 5 (Size of input array)

i = 1. Since 11 is smaller than 12, move 12 and insert 11 before 12
11, 12, 13, 5, 6

i = 2. 13 will remain at its position as all elements in A[0..I-1] are smaller than 13
11, 12, 13, 5, 6

i = 3. 5 will move to the beginning and all other elements from 11 to 13 will move one position ahead of their current position.
5, 11, 12, 13, 6

i = 4. 6 will move to position after 5, and elements from 11 to 13 will move one position ahead of their current position.
5, 6, 11, 12, 13


Time Complexity: O(n*2)

Auxiliary Space: O(1)

Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order. And it takes minimum time (Order of n) when elements are already sorted.

Algorithmic Paradigm: Incremental Approach

Sorting In Place: Yes

Stable: Yes
 *
 */
public class InsertionSort {
	
	public static void main(String[] args) {
		int[] unsortedArray = {5,4,1,3,2,8,7,6,0,1,2,4};
		int[] sortedArray = insertionSort(unsortedArray);
		System.out.println(Arrays.toString(sortedArray));
	}

	private static int[] insertionSort(int[] unsortedArray) {
		for(int i=1;i<unsortedArray.length;i++) {
			for(int j=i;j>0;j--) {
				if(unsortedArray[j] < unsortedArray[j-1]) {
					int temp = unsortedArray[j-1];
					unsortedArray[j-1] = unsortedArray[j];
					unsortedArray[j] = temp;
				}
			}
		}
		return unsortedArray;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*private static int[] insertionSort(int[] unsortedArray) {
		for(int i=1; i <(unsortedArray.length); i++) {
			
			int key = unsortedArray[i];
			for(int j= i-1;j>=0;j--) {
				if(key < unsortedArray[j]) {
					unsortedArray[j+1] = unsortedArray[j];
					unsortedArray[j] = key;
				}
			}
		}
		return unsortedArray;
	}*/

}
