package com.manish.java.thread.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Manish
 *
 */

class CallableTask implements Callable<Integer>{
	
	private Integer number;
	public CallableTask(Integer number) {
		this.number = number;
	}
	

	@Override
	public Integer call() throws Exception {
		try {
			Thread.sleep(1000);
			return number * number;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}
}




public class FutureTaskDemo {
	
	public static void main(String[] args) throws Throwable {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		List<Future<Integer>> futures = new ArrayList<>();
		Future<Integer> futureTask1 = executorService.submit(new CallableTask(10));
		futures.add(futureTask1);
		Future<Integer> futureTask2 = executorService.submit(new CallableTask(5));
		futures.add(futureTask2);
		Future<Integer> futureTask3 = executorService.submit(new CallableTask(6));
		futures.add(futureTask3);
		Future<Integer> futureTask4 = executorService.submit(new CallableTask(4));
		futures.add(futureTask4);
		
		waitTillAllFutureComplete(futures);
		Integer total = 0;
		for(Future<Integer> future:futures) {
		   total += future.get();	
		}
		System.out.println("Total value = "+total);
		
		executorService.shutdown();
		
		/*FutureTaskDemo obj = new FutureTaskDemo();
		Future<Integer> calculate = obj.calculate(100);
		while(!calculate.isDone()) {
			 System.out.println("Calculating...");
			 Thread.sleep(300);
		}
		System.out.println(calculate.get());
		obj.finalize();
		//obj.executorService.shutdown();
*/	}

	private static void waitTillAllFutureComplete(List<Future<Integer>> futures) {
		while(true) {
			boolean isAllFutureCompletes = true;
			for(Future<Integer> future : futures) {
				if(null != future && !future.isDone()) {
					isAllFutureCompletes = false;
					break;
				} 
			}
			if(isAllFutureCompletes) {
				break;
			} else {
				System.out.println("Still processing......");
			}
		}
		
	}

}
