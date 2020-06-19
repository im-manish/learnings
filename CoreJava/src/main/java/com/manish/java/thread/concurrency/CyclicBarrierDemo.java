package com.manish.java.thread.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Manish
 *
 */
public class CyclicBarrierDemo implements Runnable {

	private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
	@Override
	public void run() {
		System.out.println("Into run method");
		try {
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		CyclicBarrierDemo c = new CyclicBarrierDemo();
		Thread t = new Thread(c);
		t.start();
		cyclicBarrier.await();
		cyclicBarrier.reset();
		System.out.println("Finished main method");
	}

}
