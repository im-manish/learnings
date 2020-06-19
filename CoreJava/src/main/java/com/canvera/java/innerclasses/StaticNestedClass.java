package com.canvera.java.innerclasses;

import com.canvera.java.innerclasses.ClassNestedInterface.ClassNestedInterfaceDemo;

/**
 * @author Manish
 *
 */
public class StaticNestedClass {
	int x=10;
	static int y=20;
	static class NestedStatic {
		static int y = 50;
		void methodOne() {
			System.out.println(y);
		}
		public static void main(String[] args) {
			StaticNestedClass.main(new String[10]);
			NestedStatic s1 = new StaticNestedClass.NestedStatic();
			s1.methodOne();
		}
	}
	public static void main(String[] args) {
		System.out.println(StaticNestedClass.NestedStatic.y);
	}
}
