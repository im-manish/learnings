package com.canvera.java.innerclasses;

/**
 * @author Manish
 *
 */

// classs scope will be limited to local method
public class MethodLocalInnerClasses {
	
	private final int x=10;
	private static final int y =20;
	
	public void methodOne() {
		int a=10;
		// can access both static and non static methods.
		class InnerClassNonStaticMethod {
			public void sum() {
				System.out.println("Sum = "+ (x+y+a));
			}
		}
		
		InnerClassNonStaticMethod innerClassNonStaticMethod = new InnerClassNonStaticMethod();
		innerClassNonStaticMethod.sum();
		
	}
	public static void methodOneStatic() {
		int b=10;
		class InnerClassStaticMethod {
			final int a=10;
			public void sum() {
				System.out.println("Sum = " + (y+a+b));
			}
		}
		InnerClassStaticMethod innerClassStaticMethod = new InnerClassStaticMethod();
		innerClassStaticMethod.sum();
	}
	
	public static void main(String[] args) {
		System.out.println(new MethodLocalInnerClasses());
		new MethodLocalInnerClasses().methodOne();
		MethodLocalInnerClasses.methodOneStatic();
		 
	}
	
}
