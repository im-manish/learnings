/**
Copyright (c) 2020 Manish Kumar written on 11-Jul-2020
 * 
 */
package com.manish.java.thread.concurrency;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Manish
 *
 */
public class ExecutorServiceDemo2 {
	
	private static String[] hostList = { "http://crunchify.com", "http://yahoo.com", "http://www.ebay.com", "http://google.com",
			"http://www.example.co", "https://paypal.com", "http://bing.com/", "http://techcrunch.com/", "http://mashable.com/",
			"http://thenextweb.com/", "http://wordpress.com/", "http://wordpress.org/", "http://example.com/", "http://sjsu.edu/",
			"http://ebay.co.uk/", "http://google123.co.uk/", "http://wikipedia.org/", "http://en.wikipedia.org" };


	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(30);
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < hostList.length; i++) {
			String url = hostList[i];
			Runnable worker = new RunnableTask1(url);
			executor.execute(worker);
			//worker.run();
		}
		executor.shutdown();
		// Wait until all threads are finish
		while (!executor.isTerminated()) {
		}
		 System.out.println("Task complete in ->  "+(System.currentTimeMillis() - startTime));
	}

}

class RunnableTask1 implements Runnable {

	private String url;

	/**
	 * @param url
	 */
	public RunnableTask1(String url) {
		super();
		this.url = url;
	}

	@Override
	public void run() {
		String result = "";
		int code = 200;
		try {
			URL siteURL = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(3000);
			connection.connect();
			code = connection.getResponseCode();
			if (code == 200) {
				result = "-> Green <-\t" + "Code: " + code;
				;
			} else {
				result = "-> Yellow <-\t" + "Code: " + code;
			}
		} catch (Exception e) {
			result = "-> Red <-\t" + "Wrong domain - Exception: " + e.getMessage();

		}
		System.out.println(url + "\t\tStatus:" + result + " Run by thread ->"+Thread.currentThread().getName());
	}

}