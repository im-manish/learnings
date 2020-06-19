package com.manish.java.searching;

/**
 * @author Manish
 *
 *
 *Let’s consider the following array: (0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610).
 * Length of the array is 16. Jump search will find the value of 55 with the following steps 
 * assuming that the block size to be jumped is 4.
STEP 1: Jump from index 0 to index 4;
STEP 2: Jump from index 4 to index 8;
STEP 3: Jump from index 8 to index 16;
STEP 4: Since the element at index 16 is greater than 55 we will jump back a step to come to index 9.
STEP 5: Perform linear search from index 9 to get the element 55.
find m using m = squrt(n)
 */
public class JumpSearch {
	
	public static void main(String[] args) {
		int[] sortedArray = {2,4,6,8,9,13,23,33,34,57,89,100};
		jumpSearch(sortedArray,45);
		
	}

	private static void jumpSearch(int[] sortedArray, int key) {
		int length = (sortedArray.length);
		int blockSizedToSkip = (int) Math.floor(Math.sqrt(length));
		int steps = 0;
		while(steps <= length) {
			if(sortedArray[steps] == key) {
				System.out.println("Element found at position " +(steps+1));
				return;
			}
			else if(sortedArray[blockSizedToSkip] < key) {
				steps +=(blockSizedToSkip);
				if(steps >= length) {
					steps = length-1;
				}
				continue;
			}  else {
				performLinearSearchBackWard(sortedArray,blockSizedToSkip,key);
			}
			
		}
		System.out.println("Element not present");
		
	}

	private static void performLinearSearchBackWard(int[] sortedArray, int blockSizedToSkip, int key) {
		for(int index= (blockSizedToSkip-1);index<=0;index--) {
			if(sortedArray[index]== key) {
				System.out.println("Element found at position " +(index+1));
			}
		}
		
	}
	

}
