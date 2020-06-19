package com.manish.java.oops;

/**
 * @author Manish
 *
 */
public class OverloadingInInheritenceDemo {
	
	public static void main(String[] args) {
		Base b = new Derived();
		Derived d = new Derived();
		b.displayNumber(89.1);
		d.displayNumber(10.1);
		
	}
	

}

class Base {
	public void displayNumber(float i) {
		System.out.println("Base class number display+"+i);
	}
	public void displayNumber(double ... i) {
		System.out.println("base class number display+"+i);
	}
}

class Derived extends Base{
	public void displayNumber(double i) {
		System.out.println("derived class number display+"+i);
	}
	
}