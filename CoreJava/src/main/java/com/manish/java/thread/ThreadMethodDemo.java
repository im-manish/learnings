package com.manish.java.thread;

/**
 * @author Manish
 *
 */


public class ThreadMethodDemo implements Runnable {
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " "+Thread.currentThread().getPriority());
		ThreadMethodDemo threadMethodDemo = new ThreadMethodDemo();
		Thread t2 = new Thread(threadMethodDemo);
		t2.setPriority(10);
		t2.setName("Ye to T2 hai");
		t2.start();
		System.out.println(Thread.currentThread().getName());
		
	}
}
