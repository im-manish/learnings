package com.manish.java.thread;

public class EvenAndOddThreadDemo {

	public static void main(String[] args) throws InterruptedException {
		PrintNumber printNumber = new PrintNumber();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					printNumber.printEven();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					printNumber.printOdd();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.setName("Even Thread");
		t2.setName("Odd Thread");
		t2.start();
		t1.start();
		//t2.join();
		//t2.join();

	}

}

class PrintNumber {

	public synchronized void printEven() throws InterruptedException {
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				System.out.println("Printing by Thread " + Thread.currentThread().getName() + " " + i);
				Thread.sleep(1000);
				this.notify();
				this.wait();
			}
		}
		this.notify();
	}

	public synchronized void printOdd() throws InterruptedException {
		for (int i = 1; i <= 10; i++) {
			if (i % 2 != 0) {
				System.out.println("Printing by Thread " + Thread.currentThread().getName() + " " + i);
				Thread.sleep(1000);
				this.notify();
				this.wait();
			}
		}
		this.notify();
	}
}