package com.manish.java.data_structure;

import java.util.Arrays;

/**
 * @author Manish
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] unsortedArray = { 5, 4, 1, 3, 2, 8, 7, 6 };
		int[] sortedArray = mergeSort(unsortedArray);
		System.out.println(Arrays.toString(sortedArray));
	}

	private static int[] mergeSort(int[] unsortedArray) {
		int length = unsortedArray.length;
		mergeSortImpl(unsortedArray, 0, (length - 1));
		return unsortedArray;
	}

	private static void mergeSortImpl(int[] array, int start, int end) {
		if (start < end) {
			int mid = (start+ end)/2;
			mergeSortImpl(array, start, mid);
			mergeSortImpl(array, mid + 1, end);
			merge(array, start, mid, end);
		}
	}

	private static void merge(int[] array, int start, int mid, int end) {

		// create a temp array
		int[] temp = new int[end - start + 1];
		int i = start, j = mid + 1, k = start;
		while (i <= mid && j <= end) {
			if (array[i] < array[j]) {
				temp[k] = array[i];
				i++;
			} else {
				temp[k] = array[j];
				j++;
			}
			k++;
		}

		// copy remaining item of left part into temp
		while (i <= mid) {
			array[k] = array[i];
			i++;
			k++;
		}
		// copy remaining item of right part into temp
		while (j <= end) {
			array[k] = array[j];
			j++;
			k++;
		}
		
		// copy all sorted item to array from temp
		for(int i1=start;i1<=end;i1++) {
			array[i1] = temp[i1];
		}
	}
}
