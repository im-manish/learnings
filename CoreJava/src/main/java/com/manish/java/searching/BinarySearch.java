package com.manish.java.searching;

/**
 * @author Manish
 *
 */
public class BinarySearch {
	
	public static void main(String[] args) {
		int[] sortedArray = {2,4,6,8,9,13,23,33,34,57,89,100};
		//binarySearchWithoutRecurssion(sortedArray,13);
		binarySearchUsingRecurssion(sortedArray,9);
		
	}
	
	private static void binarySearchWithoutRecurssion(int[] sortedArray, int key) {
		int length = sortedArray.length;
		int low = 0;
		int high = length-1;
		while(low<=high) {
			int mid = (low+ high)/2;
			int midValue = sortedArray[mid];
			if(midValue== key) {
				System.out.println("Element found at position " +(mid+1));
				return ;
			} else if(midValue < key) {
				low=mid+1;
			} else {
				high = mid-1;
			}
		}
		System.out.println("Element not present");
	}
	
	private static void binarySearchUsingRecurssion(int[] sortedArray, int key) {
		int length = sortedArray.length;
		int low = 0;
		int high = length-1;
		recursiveBinarySearch(sortedArray,low,high,key);
	}

	private static void recursiveBinarySearch(int[] sortedArray, int low, int high, int key) {
		if(low > high) {
			System.out.println("Element not present");
			return;
		}
		int mid = (low+ high)/2;
		int midValue = sortedArray[mid];
		if(midValue== key) {
			System.out.println("Element found at position " +(mid+1));
			return ;
		} else if(midValue < key) {
			recursiveBinarySearch(sortedArray, mid+1, high, key);
		} else {
			recursiveBinarySearch(sortedArray, low, mid-1, key);
		}
	
	}
		


}
