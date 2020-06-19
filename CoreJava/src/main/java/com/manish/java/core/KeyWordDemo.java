package com.manish.java.core;

import java.util.Scanner;

/**
 * @author Manish
 *
 */
public class KeyWordDemo {
	
	public static void main(String[] args) {
		/*Scanner sc = new Scanner(System.in);
		int nextInt = sc.nextInt();
		assert nextInt >10:"Not valid";
		System.out.println("Pass");*/
		
		//floatig point literals are by default double 
		//float f= 123.123; // CE
		float f= 123.123f;
		double d= 123.123;
		double d1= 123.123D;
		
		float intergrlLiterals= 101;
		System.out.println(intergrlLiterals);
		
		// exponential form 
		double expo = 10e2; // 10x10pow(2)
		System.out.println(expo);
		
		// char allow value range for integral values range is 0 to 65535.
		
		char c= 971;
		System.out.println(c);
		
		// backspace character
		
		String s= "abc";
		System.out.println(s+"\b");
		
		// verion 1.7 onward we can use binary and _ in literals.
		
		// for binary we must use 0b or 0B first
		int i = 0B111;
		System.out.println(i);
		// we can use underscore within digits 
		int i1 = 1_100;
		System.out.println(i1);
		
		//invalid
		//double d1 = _1_234._123;
		double double_s= 1_2_34.34;
		System.out.println(double_s);
		
		// array declaration
		int[] a = new int['a'];
		System.out.println(a.length);
		int[][] a1 = new int[3][];
		System.out.println(a1.length);
		
		int[] array1 = {1,2,3,4};
		int[] array2 = {1,2};
		array2 = array1;
		System.out.println(array2.length);
		
		
		
		
	}
}
