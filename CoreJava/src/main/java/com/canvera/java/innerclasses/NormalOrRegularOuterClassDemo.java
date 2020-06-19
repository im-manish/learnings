package com.canvera.java.innerclasses;

/**
 * @author Manish
 *
 */
public class NormalOrRegularOuterClassDemo {
	/* inner class can access all members of outer class (both static and non-static, 
	private and non private methods and variables) directly.*/
	
	private int x= 10;
	private static int y=20;
	class Inner {
		private  int x= 30;
		private int y=40;
		public void methodOne() {
			System.out.println("Normal Inner class");
			System.out.println(x);
			System.out.println(y);
			System.out.println(this.x);
			System.out.println(this.y);
			System.out.println(NormalOrRegularOuterClassDemo.this.x);
			System.out.println(NormalOrRegularOuterClassDemo.this.y);
			
		}
		
	}
	public void methodTwo() {
		Inner i = new Inner();
		i.methodOne();
	}
	
	public static void main(String[] args) {
		NormalOrRegularOuterClassDemo obj = new NormalOrRegularOuterClassDemo();
		//obj.methodTwo();
		new NormalOrRegularOuterClassDemo().new Inner().methodOne();
	}

}
