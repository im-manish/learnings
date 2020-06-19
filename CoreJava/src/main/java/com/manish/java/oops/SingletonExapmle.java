package com.manish.java.oops;

/**
 * @author Manish
 *
 */
public class SingletonExapmle {
	
	private static SingletonExapmle singaltonExapmle;
	
	private SingletonExapmle() {
		
	}
	
	public static SingletonExapmle getSingaltonClass() {
		if(null == singaltonExapmle) {
			 singaltonExapmle = new SingletonExapmle();
		}
		return singaltonExapmle;
	}
	
	public static void main(String[] args) {
		/*System.out.println(SingaltonExapmle.getSingaltonClass().hashCode());
		System.out.println(SingaltonExapmle.getSingaltonClass().hashCode());
		System.out.println(SingaltonExapmle.getSingaltonClass().hashCode());
		System.out.println(SingaltonExapmle.getSingaltonClass().hashCode());
		
		System.out.println(DoubletonExample.getDoubletonClass().hashCode());
		System.out.println(DoubletonExample.getDoubletonClass().hashCode());
		System.out.println(DoubletonExample.getDoubletonClass().hashCode());
		System.out.println(DoubletonExample.getDoubletonClass().hashCode());
		System.out.println(DoubletonExample.getDoubletonClass().hashCode());
		System.out.println(DoubletonExample.getDoubletonClass().hashCode());*/
		
		System.out.println(SingltonBestWay.getInstance().hashCode());
		System.out.println(SingltonBestWay.getInstance().hashCode());
		System.out.println(SingltonBestWay.getInstance().hashCode());
	}

}

class SingltonBestWay {
	
	private SingltonBestWay() {
	}
	
	private static class SingltonBestWayHelper {
		private static final SingltonBestWay INSTANCE = new SingltonBestWay();
	}
	
	public static SingltonBestWay getInstance() {
		return SingltonBestWayHelper.INSTANCE;
	}
}


class DoubletonExample{
	
	private static DoubletonExample doubletonExample1;
	private static DoubletonExample doubletonExample2;
	
	private DoubletonExample() {
		
	}
	public static DoubletonExample getDoubletonClass() {
		if(doubletonExample1 == null) {
			doubletonExample1 = new DoubletonExample();
			return doubletonExample1;
		} else if(null == doubletonExample2) {
			doubletonExample2 = new DoubletonExample();
			return doubletonExample2;
		} else {
			if(Math.random()< 0.5) 
				return doubletonExample1;
				else 
					return doubletonExample2;
			}
		}
	}
