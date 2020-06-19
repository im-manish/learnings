package com.manish.java.designpatterns;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Manish
 *
 */

// Singleton Pattern is used when we have to crate only one object of class is vailable in jvm .

//Eager initialisation method

class SingletonEagerInitializationDemo {
	
	private static final SingletonEagerInitializationDemo instance = new SingletonEagerInitializationDemo();
	
	private SingletonEagerInitializationDemo() {
		
	}
	
	public static SingletonEagerInitializationDemo getInstance() {
		return instance;
	}
}

// static block initialisation method

class SingletonStaticBlockInitializationDemo {
	 private static SingletonStaticBlockInitializationDemo instance ;
	 
	 private SingletonStaticBlockInitializationDemo() {
	}
	 static {
		 try {
			instance = new SingletonStaticBlockInitializationDemo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 
	 public static SingletonStaticBlockInitializationDemo getInstance() {
		 return instance;
	 }
	 
}

// Both above mention practise is not good because it create the instance when class is getting loaded

//Lazy initialisation

class SingletonLazyIntialisationDemo {
	private static SingletonLazyIntialisationDemo instance;
	
	private SingletonLazyIntialisationDemo() {
		
	}
	
	public static SingletonLazyIntialisationDemo getInstance() {
		if(null == instance) {
			instance = new SingletonLazyIntialisationDemo();
		}
		return instance;
	}
}


// Thread safe singleton demo // but its 

class SingleTonThreadSafeDemo {
	
	private static SingleTonThreadSafeDemo instance;
	
	private SingleTonThreadSafeDemo() {
		
	}
	
	public static SingleTonThreadSafeDemo getInstance() {
		if(null == instance) {
			
			synchronized (SingleTonThreadSafeDemo.class) {
				if(null == instance) {
					instance = new SingleTonThreadSafeDemo();
				}
			}
		}
		return instance;
	}
	
}


//Bill Pauge approach / Best way to create singleton

	class BillPaugeSingletonDemo {
		
		private BillPaugeSingletonDemo() {
			
		}
		
		private static class SingletonHelper {
			private static final BillPaugeSingletonDemo instance = new BillPaugeSingletonDemo();
		}
		
		public static BillPaugeSingletonDemo getInstance() {
			return SingletonHelper.instance;
		}
	}
	
	
	public class SingletonPatternExample {
		
		public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			// using reflection to destroy singleton pattern
			BillPaugeSingletonDemo instance1 = BillPaugeSingletonDemo.getInstance();
			BillPaugeSingletonDemo instance2 = BillPaugeSingletonDemo.getInstance();
			
			System.out.println(instance1.hashCode());
			System.out.println(instance2.hashCode());
			
			Constructor<?>[] declaredConstructors = BillPaugeSingletonDemo.class.getDeclaredConstructors();
			for(Constructor<?> constructor : declaredConstructors) {
				constructor.setAccessible(true);
				instance2 = (BillPaugeSingletonDemo) constructor.newInstance();
				break;
			}
			System.out.println("After reflection use");
			System.out.println(instance1.hashCode());
			System.out.println(instance2.hashCode());
			System.out.println(3/2);
			
		}
		
		
		

	}