package com.manish.java.oops;

/**
 * @author Manish
 *
 */
 interface InterfaceExampleDemo {
  int id = 10;
  int move();
		  
}

public class InterfaceExample implements InterfaceExampleDemo{

	@Override
	public int move() {
		return id+10;
	}
	public static void main(String[] args) {
		InterfaceExample t = new InterfaceExample();
		t.move();
		System.out.println(t.move()+" "+id);
	}
}