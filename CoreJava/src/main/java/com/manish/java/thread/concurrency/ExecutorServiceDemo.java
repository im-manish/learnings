/**
Copyright (c) 2020 Manish Kumar written on 11-Jul-2020
 * 
 */
package com.manish.java.thread.concurrency;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.imageio.ImageIO;

/**
 * @author Manish
 *
 */
public class ExecutorServiceDemo {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		long startTime = System.currentTimeMillis();
		try (Stream<Path> walk = Files.walk(Paths.get("C:\\Users\\hp\\Desktop\\Images\\ReadImage"));) {
			List<Path> filePaths = walk.collect(Collectors.toList());
			filePaths.forEach(path -> {
				RunnableTask runnableTask = new RunnableTask(path);
				//runnableTask.run();
				executor.execute(runnableTask);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		executor.shutdown();
		// Wait until all threads are finish
		while (!executor.isTerminated()) {
		}
		System.out.println("Task complete in ->  "+(System.currentTimeMillis() - startTime));
	}

}

class RunnableTask implements Runnable {

	private Path path;

	/**
	 * @param path
	 */
	public RunnableTask(Path path) {
		super();
		this.path = path;
	}

	@Override
	public void run() {
		Path fileName = path.getFileName();
		try(ByteArrayInputStream bis = new ByteArrayInputStream(Files.readAllBytes(path));) {
			//byte[] readAllBytes = Files.readAllBytes(path);
			/*
			 * Blob blob = new SerialBlob(readAllBytes); int blobLength = (int)
			 * blob.length(); byte[] blobAsBytes = blob.getBytes(1, blobLength);
			 * blob.free();
			 */
			//bis = new ByteArrayInputStream(readAllBytes);
		    BufferedImage bImage2 = ImageIO.read(bis);
			ImageIO.write(bImage2, "jpg", new File("C:\\Users\\hp\\Desktop\\Images\\WriteImages\\"+fileName) );
			System.out.println("Convertion for image "+fileName+" complete by Thread ->"+Thread.currentThread().getName());
		} catch (Exception e) {
			System.out.println("Error for fileName"+fileName);
			e.printStackTrace();
		} 

	}

}
