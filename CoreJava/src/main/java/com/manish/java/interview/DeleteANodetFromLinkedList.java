package com.manish.java.interview;

/**
 * @author Manish
 *
 */
public class DeleteANodetFromLinkedList {
	public static void main(String[] args) {
		Clas obj1 = new Clas();
		A obj2 = new Clas();
		C1 obj3 = new Clas();
		obj1.print(obj3);
		
		//obj1.print(obj3);
		//obj.m1();
	}

}

interface A {
	 static public void m1() {
		System.out.println("A");
	}
}
interface B {
	default public void m1() {
		System.out.println("B");
	}
}
interface C1 extends A,B{

	@Override
	default void m1() {
		// TODO Auto-generated method stub
		A.m1();
	}
	
}
class Parent {
	
}
class Clas implements C1{
	
	public void m1() {
		System.out.println("Hello");
	}
	public void m2() {
		System.out.println("Hello M2");
	}
	
	public void print(A a) {
		A.m1();
	}
	
}
