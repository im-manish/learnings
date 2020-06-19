package com.manish.java.core;

/**
 * @author Manish
 *
 */
class Test1 {
	int i;
	public Test1(int i) {
		this.i=i;
	}
}

class Test2 {
	int i;
	public Test2(int i) {
		this.i =i;
	}
	@Override
	public int hashCode() {
		return i;
	}
	@Override
	public String toString() {
		return i+"";
	}
	
	
	
}
public class HashCodeVsToString {
	
	public static void main(String[] args) {
		Test1 t1 = new Test1(10);
		Test2 t2 = new Test2(20);
		System.out.println(t1);
		System.out.println(t2);
		
	}
	

}


	