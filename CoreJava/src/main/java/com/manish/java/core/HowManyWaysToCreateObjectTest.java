package com.manish.java.core;

import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * @author Manish
 *
 */
public class HowManyWaysToCreateObjectTest implements Serializable, Cloneable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	
	public HowManyWaysToCreateObjectTest() {
		// TODO Auto-generated constructor stub
	}
	public HowManyWaysToCreateObjectTest(String name) {
		this.setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "This is the "+this.name+ " to create the Object";
	}
	
	public static void main(String[] args) throws Exception {
		HowManyWaysToCreateObjectTest o1 = new HowManyWaysToCreateObjectTest("1'st Way");
		// only work if default paramenter exists
		HowManyWaysToCreateObjectTest o2 = (HowManyWaysToCreateObjectTest)Class.forName("com.manish.CoreJava.HowManyWaysToCreateObjectTest").newInstance();
		o2.setName("2nd Way");
		HowManyWaysToCreateObjectTest o3 = (HowManyWaysToCreateObjectTest) o1.clone();
		o3.setName("3rd Way");
		// Serialize and Deserializing way is forth way.
		
		
		Constructor<HowManyWaysToCreateObjectTest> declaredConstructor = HowManyWaysToCreateObjectTest.class.getDeclaredConstructor();
		HowManyWaysToCreateObjectTest o5 = declaredConstructor.newInstance();
		o5.setName("5th Way");
		System.out.println(o1.toString());
		System.out.println(o2.toString());
		System.out.println(o3.toString());
		System.out.println(o5.toString());
	}

}
