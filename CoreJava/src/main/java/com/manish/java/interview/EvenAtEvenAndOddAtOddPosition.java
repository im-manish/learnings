package com.manish.java.interview;

/**
 * @author Manish
 *
 */
public class EvenAtEvenAndOddAtOddPosition {
	public static void main(String[] args) {
		int[] array = {10,9,7,18,13,19,4,20,21,14};
		for(int i=0;i<array.length;i++) {
			if(i%2 ==0 && array[i]%2==0) {
				continue;
			} else if(i%2 !=0 && array[i]%2 !=0) {
				continue;
			} else if(i%2 ==0 && array[i]%2 !=0) {
				for(int j=i+1;j<array.length;j++) {
					if(array[j]%2 == 0) {
						int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
						break;
					}
				}
			} else if(i%2 !=0 && array[i]%2 ==0) {
				for(int j=i+1;j<array.length;j++) {
					if(array[j]%2 != 0) {
						int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
						break;
					}
				}
			}
		}
		for(int i=0;i<array.length;i++) {
			System.out.print(" "+array[i]+",");
		}
	}

}
