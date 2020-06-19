package com.manish.java.core;

/**
 * @author Manish
 *
 */
public class StaticFlowDemo {
	
	static int i=10;
	{
		System.out.println("Instance Block base");
	}
	
	public StaticFlowDemo() {
		super();
		System.out.println("Constructor value i="+i+"j ="+j);
	}
	static {
		methodOne();
		System.out.println("First Static block");
	}
	
	private static void methodOne() {
		System.out.println(i);
		System.out.println(j);
		
	}
	static int j=20;
	static {
		System.out.println("second static block");
	}
	
	public static void main(String[] args) {
		StaticFlowDemo s = new StaticFlowDemo();
		methodOne();
		System.out.println("main method");
	}

}

class StaticDemoChild extends StaticFlowDemo {
	static int derivedi=100;
	{
		System.out.println("Instance block derived");
	}
	static {
		methodTwo();
		System.out.println("First Derived staic block");
	}
	
	public static void main(String[] args) {
		StaticDemoChild obj = new StaticDemoChild();
		methodTwo();
		System.out.println("Derived main");
	}

	private static void methodTwo() {
		System.out.println(derivedj);
		
	}
	static int derivedj = 200;
}