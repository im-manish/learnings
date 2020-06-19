package com.manish.java.thread;

/**
 * @author Manish
 *
 */
public class ThreadLocalDemo extends Thread  implements Runnable {
	static int custId =0;
	ThreadLocal thread = new ThreadLocal() {
		protected Integer initialValue() {
			return custId++;
		}
	};
	public ThreadLocalDemo(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " Excuting with custd "+thread.get());
		}
	}
	public static void main(String[] args) {
		ThreadLocalDemo t1 = new ThreadLocalDemo("Thread 1");
		ThreadLocalDemo t2 = new ThreadLocalDemo("Thread 2");
		ThreadLocalDemo t3 = new ThreadLocalDemo("Thread 3");
		ThreadLocalDemo t4 = new ThreadLocalDemo("Thread 4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
