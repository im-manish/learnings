package com.manish.java.interview;

import java.util.Arrays;

/**
 * @author Manish
 *
 */
public class AnagramTest {

	public static void main(String[] args) {
		String str1 = "silent";
		String str2 = "listen";
		checkAnagramUsingSorting(str1,str2);
		checkAnagramUsingCharPosition(str1,str2);
		
	}

	// assuming character support is 8 bit system
	private static void checkAnagramUsingCharPosition(String str1, String str2) {
		if(str1.length() != str2.length()) {
			System.out.println("Not anagram using char position");
			return;
		}
		int[] count1 = new int[256];
		int[] count2 = new int[256];
		for(int i=0;i<str1.length();i++) {
			count1[str1.charAt(i)]++;
		}
		for(int i=0;i<str2.length();i++) {
			count2[str2.charAt(i)]++;
		}
		for(int i=0;i<256;i++) {
			if(count1[i] != count2[i]) {
				System.out.println("Not anagram using char position");
				return;
			}
		}
		System.out.println("anagram using char position");
	}

	private static void checkAnagramUsingSorting(String str1, String str2) {
		if(str1.length() != str2.length()) {
			System.out.println("Not anagram using Sorting");
			return;
		}
		char[] charArray = str1.toCharArray();
		Arrays.sort(charArray);
		char[] charArray2 = str2.toCharArray();
		Arrays.sort(charArray2);
		for(int i=0;i<str2.length();i++) {
			if(charArray[i] != charArray2[i]) {
				System.out.println("Not anagram using Sorting");
				return;
			}
		}
		System.out.println("anagram using Sorting");
	}
	
}
