package com.manish.java.oops;

/**
 * @author Manish
 *
 */
public class InheritenceExample {

	public static void main(String[] args) {
	  //Parent p = new Parent();
	  //Child c = (Child)p;
	  // give RE Exception
	  //c.diplayChild();
	 /* Parent p2 = new Child();
	  p2.displayParent(new Child());*/
	 // Child c1 = (Child)p2;
	  //c1.displayParent();
		Child c = new Child();
		c.display();
		System.out.println();
	}
	/*static {
		i=100;
	}
	private static int i ;*/
}

class Parent {
	   
	private int AGE=50;
	/*public void displayParent(Child d) {
		d.diplayChild();
	}
	public String getParentData() {
		return parentData;
	}
	public void setParentData(String parentData) {
		this.parentData = parentData;
	}*/
	public void display() {
		System.out.println(this.AGE);
	}
	
}

class Child extends Parent {
	private int AGE=20;
	
	
/*	private String childData;
	
	public static void display() {
		System.out.println("Child display");
	}
	
	public String getChildData() {
		return childData;
	}

	public void setChildData(String childData) {
		this.childData = childData;
	}

	public void diplayChild() {
		System.out.println("Child Class Method");
	}*/
}

/*class Kid extends Child{
	public Kid() {
		super.diplayChild();
	}
}*/