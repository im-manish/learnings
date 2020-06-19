package com.manish.java.exception;

public class CustomException {

	public static void main(String[] args) {
		int i =10;
		
		if(i<12) {
			try {
				throw new MyCustomException("Helloo");
			} catch (MyCustomException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyCustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*public MyCustomException() {
		super();
		// TODO Auto-generated constructor stub
	}*/
	public MyCustomException(String message){
		super(message);
	}
	public MyCustomException(String message, Throwable cause){
		super(message,cause);
	}
}
