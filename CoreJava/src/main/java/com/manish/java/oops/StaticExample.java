package com.manish.java.oops;

/**
 * @author Manish
 *
 */
public class StaticExample {
	
	private static String staticString;
	private String nonStaticString;
	
	static {
		staticString = "Initializing Static Data";
	}
	private static void display() {
		System.out.println("Static display method call with static variable ->"+staticString);
	}
	
	static class InnerStaticClass{
		private void display() {
			System.out.println("Innner Static class displaying outer class static variable "+staticString);
		}
	}
	
	class InnerNonStaticClass{
		private void display() {
			System.out.println("Innner Static class displaying outer class static variable "+staticString+"\n");
			System.out.println("Innner Static class displaying outer class non static variable "+nonStaticString);
		}
	}
	
	public static void main(String[] args) { 
		StaticExample staticExample = new StaticExample();
		InnerNonStaticClass innerNonStaticClass = staticExample.new InnerNonStaticClass();
		innerNonStaticClass.display();
		StaticExample.display();
		InnerStaticClass innerStaticClass = new StaticExample.InnerStaticClass();
		innerStaticClass.display();
		
		
	}
	
	

}
