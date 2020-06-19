package com.manish.java.thread.concurrency;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Manish
 *
 */

class Task implements Runnable{
	
	private String taskName;
	
	

	public Task(String taskName) {
		super();
		this.taskName = taskName;
	}


	@Override
	public void run() {
	for(int i=0;i<10;i++) {
		 if (i==0)
         {
             Date d = new Date();
             SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
             System.out.println("Initialization Time for"
                     + " task name - "+ taskName +" = " +ft.format(d));   
             //prints the initialization time for every task 
         }
         else
         {
             Date d = new Date();
             SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
             System.out.println("Executing Time for task name - "+
            		 taskName +" = " +ft.format(d));   
             // prints the execution time for every task 
         }
         try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     System.out.println(taskName+" complete");
	}
		
}
public class ThreadPoolDemo {
	private static final int MAX_SIZE=3;
	public static void main(String[] args) {
		 // creates five tasks
        Runnable r1 = new Task("task 1");
        Runnable r2 = new Task("task 2");
        Runnable r3 = new Task("task 3");
        Runnable r4 = new Task("task 4");
        Runnable r5 = new Task("task 5");      
         
      ExecutorService executorService = Executors.newFixedThreadPool(MAX_SIZE);
      executorService.execute(r1);
      executorService.execute(r2);
      executorService.execute(r3);
      executorService.execute(r4);
      executorService.execute(r5);
      executorService.shutdown();
	}

}
