package com.manish.java.oops;

import java.util.Date;

/**
 * @author Manish
 *
 */
public class AutomaticPromotionInMethodOverloading {

	/*public void methodOne() {
		System.out.println("Method with empty argument");
	}*/
	/*public void methodOne(int i) {
		System.out.println("Method with int argument");
	}
	public void methodOne(int i, int z) {
		System.out.println("Method with two int argument");
	}
	public void methodOne(int ... i) {
		System.out.println("Method with var args int argument");
	}
	public void methodOne(float i) {
		System.out.println("Method with float  argument");
	}
	public void methodOne(float i,float z) {
		System.out.println("Method with two float  argument");
	}
	public void methodOne(double i) {
		System.out.println("Method with double  argument");
	}
	public void methodOne(double i, double z) {
		System.out.println("Method with two double  argument");
	}
	public void methodOne(float i, double z) {
		System.out.println("Method with one float and one double  argument");
	}*/
	/*public void methodOne(String s) {
		System.out.println("Method with one String value");
	}*/
	public void methodOne(Date d) {
		System.out.println("Method with one date argument");
	}
	
	public static void main(String[] args) {
		AutomaticPromotionInMethodOverloading obj = new AutomaticPromotionInMethodOverloading();
		/*obj.methodOne();
		obj.methodOne(10.5);
		obj.methodOne(10.5f);
		obj.methodOne(10,10);
		obj.methodOne(10.0,10.1);
		obj.methodOne('a');*/
		obj.methodOne(null);
		
	}
}
