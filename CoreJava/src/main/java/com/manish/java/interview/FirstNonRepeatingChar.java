package com.manish.java.interview;

import java.util.Arrays;

/**
 * @author Manish
 *
 */
public class FirstNonRepeatingChar {
	
	public static void main(String[] args) {
		String str = "manish";
		int[] count = new int[256];
		Arrays.fill(count, -1);
		for(int i=0;i<str.length();i++) {
			if(count[str.charAt(i)]==-1) {
				count[str.charAt(i)] = i;
			} else {
				count[str.charAt(i)] =-2;
			}
		}
		
		int res = Integer.MAX_VALUE;
		for(int i=0;i<256;i++) {
			if(count[i] >= 0) {
				res = Math.min(res, count[i]);
			}
		}
		if(res == Integer.MAX_VALUE) {
			System.out.println("Either all are non repeating or string is empty");
			return;
		}
		System.out.println("First non repeating charecter is "+str.charAt(res));
		
	}

}
