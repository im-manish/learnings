package com.manish.java.exception;


class MyResources implements AutoCloseable {

	public MyResources() {
		System.out.println("Creating Resource");
	}
	public void doProcess() {
		System.out.println("Using Resorces");
	}
	@Override
	public void close() throws Exception {
		System.out.println("Closing Resorces");
		
	}
}


public class TryWithResourcesDemo {
	
	public static void preJDK7() {
		MyResources myResources = null;
		try {
			myResources = new MyResources();
			myResources.doProcess();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(null != myResources) {
					myResources.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void jdk7() {
		
		try(MyResources myResources = new MyResources()) {
			myResources.doProcess();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void jdk8() {
		MyResources myResources = new MyResources();
		try(MyResources r = myResources) {
			r.doProcess();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	// only applicable in java 9
	/*public static void jdk9() {
		MyResources myResources = new MyResources();
		try(myResources){
			myResources.doProcess();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void multipleJDK9() {
		MyResources myResources = new MyResources();
		MyResources myResources1 = new MyResources();
		MyResources myResources2 = new MyResources();
		try(myResources;myResources1;myResources2){
			myResources.doProcess();
			myResources1.doProcess();
			myResources2.doProcess();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public static void main(String[] args) {
		System.out.println("Program Execution With PreJDK7");
		preJDK7();
		System.out.println("Program Execution With JDK7");
		jdk7();
		System.out.println("Program Execution With JDK8");
		jdk8();
		
	}

}
