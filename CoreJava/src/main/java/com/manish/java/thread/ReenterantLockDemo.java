package com.manish.java.thread;

import java.util.concurrent.locks.ReentrantLock;

class DisplayWithOutSyncronization {
	ReentrantLock reentrantLock = new ReentrantLock(true);
	public void displayWish(String name) {
		reentrantLock.lock();
		for(int i=0;i<5;i++) {
			System.out.println("Goood Morning "+name);
		}
		reentrantLock.unlock();
	}
}

class Mythread extends Thread {
	
	private DisplayWithOutSyncronization displayWithOutSyncronization;
	private String name;
	
	public Mythread(DisplayWithOutSyncronization displayWithOutSyncronization, String name) {
		this.displayWithOutSyncronization = displayWithOutSyncronization;
		this.name = name;
	}
	
	public void run() {
		displayWithOutSyncronization.displayWish(name);
	}
	
}

public class ReenterantLockDemo {
	public static void main(String[] args) {
		DisplayWithOutSyncronization displayWithOutSyncronization = new  DisplayWithOutSyncronization();
		Mythread t1 = new Mythread(displayWithOutSyncronization, "Manish");
		Mythread t2 = new Mythread(displayWithOutSyncronization, "Bhaisi");
		Mythread t3 = new Mythread(displayWithOutSyncronization, "Khushboo");
		t1.start();
		t2.start();
		t3.start();
	}

}
