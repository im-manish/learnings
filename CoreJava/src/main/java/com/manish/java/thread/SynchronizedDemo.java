package com.manish.java.thread;
/**
 * @author Manish
 *
 */
class Display {
	
	public synchronized void displayName(String name) {
		for(int i=0;i<=5;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name);
		}
	}
	
	public void displayName(String name, int value) {
		for(int i=0;i<=5;i++) {
			synchronized (this) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(name + " "+value++);
			}
		}
	}
}


class ThreadDisplay implements Runnable {
	Display d;
	String name;
	public ThreadDisplay(Display d,String name) {
		this.d =d;
		this.name =name;
	}
	@Override
	public void run() {
		d.displayName(name);
		d.displayName(name,1);
	}
}

/**
 * @author Manish
 *
 */
/**
 * @author Manish
 *
 */
public class SynchronizedDemo {
	public static void main(String[] args) {
		Display d = new Display();
		ThreadDisplay threadDisplay = new ThreadDisplay(d, "Manish");
		ThreadDisplay threadDisplay1 = new ThreadDisplay(d, "Khushboo");
		Thread t1 = new Thread(threadDisplay);
		Thread t2 = new Thread(threadDisplay1);
		t1.start();
		t2.start();
	}

}

