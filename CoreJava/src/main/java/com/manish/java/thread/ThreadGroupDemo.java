package com.manish.java.thread;

/**
 * @author Manish
 *
 */
public class ThreadGroupDemo {
	public static void main(String[] args) {

		System.out.println(Thread.currentThread().getThreadGroup().getName());
		System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
		ThreadGroup th = new ThreadGroup("Parent");
		System.out.println(th.getParent().getName());
		ThreadGroup ch = new ThreadGroup(th, "Childgroup");
		System.out.println(ch.getParent().getName());

		ThreadGroup g1 = new ThreadGroup("tg");
		Thread t1 = new Thread(g1, "Thread 1");
		Thread t2 = new Thread(g1, "Thread 2");
		g1.setMaxPriority(3);
		Thread t3 = new Thread(g1, "Thread 3");
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		System.out.println(t3.getPriority());

	}
}
