package com.manish.java.interview;

public class InterfaceDefaultMethod {
	public static void main(String[] args) {
		I1 i1= new C();
		I2 i2= new C();
		i1.print();
		i2.print();
	}
}

interface I1{
	default public void print() {
		System.out.println("Inside I1");
	}
}
interface I2{
	default public void print() {
		System.out.println("Inside I2");
	}
}

class C implements I1,I2 {
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		I2.super.print();
		I1.super.print();
	}

	
	
	
}
