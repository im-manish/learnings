package com.manish.java.thread;

/**
 * @author Manish
 *
 */
public class ThreadGroupDemo2 extends Thread implements Runnable {
	
	

	public ThreadGroupDemo2(ThreadGroup g, String name) {
		super(g,name);
	}
	@Override
	public void run() {
		System.out.println("Child Thread");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		// Iterate all system thread 
		ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
		Thread[] t = new Thread[system.activeCount()];
		system.enumerate(t);
		for (Thread t1: t) {
		System.out.println(t1.getName()+"-------"+t1.isDaemon());
		}
		
		
		
		
		ThreadGroup pg = new ThreadGroup("Parent Group");
		ThreadGroup cg = new ThreadGroup(pg, "Child Group");
		
		ThreadGroupDemo2 t1 = new ThreadGroupDemo2(pg, "Child Thread 1");
		
		ThreadGroupDemo2 t2 = new ThreadGroupDemo2(cg, "Child Thread 2");
		t1.start();
		t2.start();
		System.out.println(pg.activeCount());
		System.out.println(pg.activeGroupCount());
		pg.list();
		Thread.sleep(1000);
		System.out.println(pg.activeCount());
		pg.list();
	}

}
