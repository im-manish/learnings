package com.manish.java.exception;

public class ThrowAndFinallyDemo {
	
	public static void main(String[] args) throws Exception {
		int a = returnInt();
		System.out.println(a);
	}

	@SuppressWarnings("finally")
	private static int returnInt() throws Exception {
		int i =100;
		try {
			System.out.println();
			int a = 100/0;
		} catch (Exception e) {
			throw new NullPointerException();
		} finally {
			return i;
		}
	}

}
