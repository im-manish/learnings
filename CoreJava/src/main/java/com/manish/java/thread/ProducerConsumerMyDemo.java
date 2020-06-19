package com.manish.java.thread;

import java.util.LinkedList;

/**
 * @author Manish
 *
 */

class ProducerConsumer {
	LinkedList<Integer> sharedList = new LinkedList<>();
	
	public synchronized void produce() throws InterruptedException{
		if(sharedList.size() ==10) {
			wait();
		}
		notify();
		System.out.println("Producing a value");
		sharedList.add(1);
	}
	
	public synchronized void consumer() throws InterruptedException{
		if(sharedList.size() ==0) {
			wait();
		}
		
		System.out.println("consuming a value");
		sharedList.remove();
		notify();
	}
	
}

public class ProducerConsumerMyDemo {
	public static void main(String[] args) {
		ProducerConsumer pc = new ProducerConsumer();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
						Thread.sleep(1000);
						pc.produce();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}) ;
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
						Thread.sleep(1000);
						pc.consumer();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}) ;
		
		t1.start();
		t2.start();
	}

}
