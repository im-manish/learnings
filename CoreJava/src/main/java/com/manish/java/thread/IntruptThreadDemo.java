package com.manish.java.thread;

/**
 * @author Manish
 *
 */
public class IntruptThreadDemo implements Runnable {
	public static void main(String[] args) {
		Thread t = new Thread(new IntruptThreadDemo());
		t.start();
		t.interrupt();
		System.out.println("Main Thread execution");
		for(int i=0;i<5;i++) {
			System.out.println("Main Thread Printing -> "+i);
		}
		
		
	}

	@Override
	public void run() {
		System.out.println("Chiled Thread execution");
		synchronized (this) {
			for(int i=0;i<5;i++) {
				try {
					wait(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Chiled Thread Printing -> "+i);
			}
		}
		
	}

}
