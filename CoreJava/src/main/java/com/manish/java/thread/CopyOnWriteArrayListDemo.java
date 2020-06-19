package com.manish.java.thread;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Manish
 *
 */
public class CopyOnWriteArrayListDemo {
	
	public static void main(String[] args) {
		CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
		copyOnWriteArrayList.add("10");
		copyOnWriteArrayList.add("20");
		copyOnWriteArrayList.add("30");
		copyOnWriteArrayList.add("40");
		Iterator<String> iterator = copyOnWriteArrayList.iterator();
		String s ="||";
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
			copyOnWriteArrayList.remove("10");
			//copyOnWriteArrayList.add(s);
			//s=s+"||";
		}
		Iterator<String> iterator1 = copyOnWriteArrayList.iterator();
		String s1 ="||";
		while(iterator1.hasNext()) {
			System.out.println(iterator1.next());
			copyOnWriteArrayList.add(s);
			s1=s1+"||";
		}
	}

}
