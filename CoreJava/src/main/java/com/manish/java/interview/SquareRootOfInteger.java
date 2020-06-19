package com.manish.java.interview;

import java.util.Scanner;

/**
 * @author canvera
 *
 */
public class SquareRootOfInteger {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		System.out.println("Square root of a given no ->"+input+" is -> "+findSquareRoot(input));
		scanner.close();
	}

	private static float findSquareRoot(int input) {
		if(input < 0) {
			return -1;
		}
		if(input == 0 || input ==1) {
			return input;
		}
		float root = 0.0f;
		float precission = 0.0001f;
		float square = root;
		while (square < input) {
			root = root+precission;
			square = root * root;
		}
		
		return root;
	}
	
	// binary search implementation
	
	

}
