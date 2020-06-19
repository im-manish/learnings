package com.manish.java.thread;

public class ThreadDemoRunAndStartMethod extends Thread {
	
	public void run() {
		for(int index=0;index<=5;index++) {
			System.out.println("Child Thread");
		}
	}
	
	public void run(int i) {
		System.out.println("Child Thhread with parameter");
	}
	
	public void start() {
		super.start();
		System.out.println("Overriden start method");
	}
	
	public static void main(String[] args) {
	  ThreadDemoRunAndStartMethod t =  new ThreadDemoRunAndStartMethod();
	  t.start();
	  
	  for(int index=0;index<=5;index++) {
			System.out.println("Parent Thread");
		}
	  
	}

}
