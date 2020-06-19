package com.manish.java.thread;

class RunnableDemo1 implements Runnable {
  
	private String argument;
	
	public String getArgument() {
		return argument;
	}
	public RunnableDemo1(String argument) {
		this.argument= argument;
	}

	public void setArgument(String argument) {
		this.argument = argument;
	}



	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			try {
				if(argument == "Child 1")
				Thread.sleep(50000);
				else 
					Thread.sleep(10000);
				System.out.println("Child Thread" + argument);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
public class ThreadJoinDemo {
	public static void main(java.lang.String[] args) {
		RunnableDemo1 runnableDemo1 = new RunnableDemo1("Child 1");
		RunnableDemo1 runnableDemo12 = new RunnableDemo1("Child 2");
		Thread t = new Thread(runnableDemo1);
		Thread t2 = new Thread(runnableDemo12);
		t.start();
		t2.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<5;i++) {
			System.out.println("main Thread");
		}
		
		String s = new String();
		System.out.println(s.toString());
		
	}
}

