package com.manish.java.thread;
/**
 * @author Manish
 *
 */
class ThreadWaitingAndNotify implements Runnable {

	int total=0;
	@Override
	public void run() {
		synchronized (this) {
			System.out.println("Child Thread Start calculation");
			for (int i = 0; i < 5; i++) {
				total++;
			}
			System.out.println("child thread giving notification call");
			this.notify();
		}
		
	}
	
}

public class WaitNotifyAndNotifyAllDemo {
	
	public static void main(String[] args) throws InterruptedException {
		ThreadWaitingAndNotify th = new ThreadWaitingAndNotify();
		Thread t = new Thread(th);
		t.start();
		synchronized (th) {
			System.out.println("main Thread calling wait() method");//step-1
			th.wait();
			System.out.println("main Thread got notification call");//step-4
			System.out.println(th.total);
		}
				
	}

}
