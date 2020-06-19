package com.manish.java.exception;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Manish
 *
 */
public class ExceptionFlow {

	public static void main(String[] args)  {
		try(BufferedReader bf = new BufferedReader(new FileReader("abc"))){
			System.out.println(10/0);
		} catch (Exception e) {
			System.out.println("catch Block");
		} finally {
			System.out.println("finally block");
		}
		System.out.println("End");
		
	}
	
		
}