package com.manish.java.exception;

import java.io.IOException;

// overriding case child to parent
// constructor case parent to child;


class Parent {
	
	public Parent() throws IOException {
		System.out.println("Hello");
	}
	public void show()   {
		System.out.println("Parent Show method");
	}
}
class Child  extends Parent {
	
	public Child()  throws IOException{
		this(8);
		// TODO Auto-generated constructor stub
	}
	public Child(int i)  throws IOException{
		System.out.println(i);
	}
	public void show()  throws RuntimeException {
		System.out.println("Child show method");
	}
	
	
	
	
}


interface I1 {
	
	public int add(int a,int b);
}

interface I2  {
	
	public double add(int a,int b);
}

public class OverridingExceptionFlow {
	public static void main(String[] args) throws IOException {
		//throw new RuntimeException();
		Child c = new Child();
		c.show();
		
		
	}

}
