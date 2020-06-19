package com.manish.java.interview;

/**
 * @author Manish
 *
 */
public class BinarySearchExample {
	
	public static void main(String[] args) {
		int[] array = {10,15,16,19,34,45,66,100};
		int lengthOfArray = array.length;
		int numberToBeSearch = 10;
		int index = binearySearchRucurcive(array,0,(lengthOfArray -1),numberToBeSearch);
		int indexWithoutRecurrsion = binarySearch(array,numberToBeSearch);
		if(indexWithoutRecurrsion == -1) {
			System.out.println("Number not present in array");
		} else {
			System.out.println("Number present at location using recurrsion "+(index+1));
			System.out.println("Number present at location without recurrsion "+(indexWithoutRecurrsion+1));
		}
	}

	private static int binearySearchRucurcive(int[] array, int first, int last, int numberToBeSearch) {
		if(first <= last) {
			int mid = first + (last-first) / 2 ;
			if(array[mid] == numberToBeSearch) {
				return mid;
			}
			if(array[mid] < numberToBeSearch) {
			 return binearySearchRucurcive(array, mid+1, last, numberToBeSearch);
			} else {
				return binearySearchRucurcive(array, first, mid-1, numberToBeSearch);
			}
			
		}
		return -1;
	}
	
	private static int binarySearch(int[] array, int numberToBeSearch) {
		int last = (array.length-1);
		int first = 0;
		int mid = 0;
		while(first <= last) {
			mid = first + (last - first)/2;
			if(array[mid] == numberToBeSearch) {
				return mid;
			}
			if(array[mid] < numberToBeSearch) {
				first = mid + 1;
			} else {
				last = mid-1;
			}
		}
		return -1;
	}

}
