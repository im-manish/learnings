package com.canvera.java.innerclasses;

/**
 * @author Manish
 *
 */
public class AnonumousInnerClassDemo {
   public static void main(String[] args) {
	   //Anonymous Class implementing interface
	 Runnable r = new Runnable() {
		
		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.println("Child Thread");
			}			
		}
	};
	Thread t = new Thread(r);
	t.start();
	
	// Anonymous class extending a class
	 Thread t1 = new Thread() {
		 public void run() {
			 System.out.println("Child Thread");
		 }
	 };
	 t1.start();
	
   }
}
