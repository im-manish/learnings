package com.manish.java.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author Manish
 *
 */
public class ThreadStopDemo implements Runnable {

	private volatile boolean exit= false;
	@Override
    public void run()
    {
		while(!exit) {
			System.out.println("Thread is running");
		}
        System.out.println("Thread is stop");
    }
	
	public void stop() {
		exit = true;
	}
	
	public static void main(String[] args) throws InterruptedException  {
		ThreadStopDemo threadStopDemo = new ThreadStopDemo();
		Thread t = new Thread(threadStopDemo);
		t.start();
		threadStopDemo.stop();
		TimeUnit.MILLISECONDS.toMillis(10000);
		
	}
		

}
