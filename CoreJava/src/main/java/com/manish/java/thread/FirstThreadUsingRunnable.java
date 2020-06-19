package com.manish.java.thread;

/**
 * @author Manish
 *
 */
public class FirstThreadUsingRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread running");
		
	}
	public static void main(String[] args) {
		FirstThreadUsingRunnable f = new FirstThreadUsingRunnable();
		Thread t = new Thread(f);
		t.start();
	}

}
