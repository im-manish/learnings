package com.manish.java.oops;

/**
 * @author Manish
 *
 */

@FunctionalInterface
interface SumInterfaceDemo {
	public int sum(int a,int b);
}




public class LamdaExpresssionDemo {
	public static void main(String[] args) {
		SumInterfaceDemo sum = (int a, int b) ->a*b;
		int sum2 = sum.sum(10, 299);
		System.out.println(sum2);
	}
}
