package com.manish.java.interview;

import java.util.Arrays;

public class FirstReapeatingCharecter {
	
	public static void main(String[] args) {
		String str = "manish kumar";
		int[] arrayCount = new int[256];
		Arrays.fill(arrayCount, 0);
		char[] charArray = str.toCharArray();
		for(int i=0;i<charArray.length;i++) {
			if(arrayCount[charArray[i]]!=0) {
				System.out.println("First non repeating char is "+charArray[i]);
				break;
			}
			
			arrayCount[charArray[i]]++;
		}
	}

}
