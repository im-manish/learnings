package com.manish.java.thread;

/**
 * @author Manish
 *
 */
public class FirstThreadExample extends Thread {
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("Thread Running");
	}
	
	/*public void start() {
		super.start();
		System.out.println("Start");
	}*/
	
	public static void main(String[] args) throws InterruptedException {
		FirstThreadExample f = new FirstThreadExample();
		FirstThreadExample f1 = new FirstThreadExample();
		f.setName("First");
		f1.setName("Second");
		f.start();
		f1.start();
		f.join();
		f1.join();
		System.out.println("mian");
	}
}
