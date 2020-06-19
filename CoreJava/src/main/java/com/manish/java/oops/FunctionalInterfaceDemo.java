package com.manish.java.oops;

@FunctionalInterface
interface FunctionalInterfaceDemo1 {
	final int i = 10;final int j = 20;
	void display();
	default int count() {
		return i+j;
	}
}

public class FunctionalInterfaceDemo {
	public static void main(String[] args) {
		FunctionalInterfaceDemo1 fcd = () -> System.out.println("First Interface wo bhi fuctional\n");
		fcd.display();
		System.out.println(fcd.count());
	}

}
