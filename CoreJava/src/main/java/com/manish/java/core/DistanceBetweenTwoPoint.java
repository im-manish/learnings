package com.manish.java.core;

/**
 * @author Manish
 *
 */
public class DistanceBetweenTwoPoint {
	private static int a=10;
	static {
		System.out.println("Hello");
		System.out.println(a);
	}
	public DistanceBetweenTwoPoint() {
		System.out.println("123");
	}
	
	public static void main(String[] args) {
		
		try {
			//ClassLoader.getSystemClassLoader().loadClass("com.manish.java.core.DistanceBetweenTwoPoint");
			Class.forName("com.manish.java.core.DistanceBetweenTwoPoint");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//System.out.println("jgukfuf");
	}

}
