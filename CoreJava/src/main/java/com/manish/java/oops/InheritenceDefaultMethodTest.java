package com.manish.java.oops;

public class InheritenceDefaultMethodTest implements I1,I2{

	/*public void show(float i) {
		System.out.println("Float");
	}*/
	public void show(int... i) {
		System.out.println("var");
	}
	public static void main(String[] args) {
		InheritenceDefaultMethodTest obj = new InheritenceDefaultMethodTest();
		obj.show(10);
	}
	

}

interface I1 {
	
	default void  display() {
		System.out.println("I1 Call");
	}
}
interface I2 {
	default void  display1() {
		System.out.println("I2 Call");
	}
}
