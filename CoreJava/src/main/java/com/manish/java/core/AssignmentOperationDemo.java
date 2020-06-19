package com.manish.java.core;

/**
 * @author Manish
 *
 */
public abstract class AssignmentOperationDemo {
	
	private int a = 10;
	{
		a=11;
	}
	
	public void print() {
		System.out.println("Print");
	}
	public static void main(String[] args) {
		byte b = 10;
		byte b1 = 11;
		// CE error because typecasting is not done
		//byte c = b1+b1;
		//byte c = b1+1;
		// typecasting done by compiler internally
		byte c = ++b1;
		System.out.println(c);
	}

}
