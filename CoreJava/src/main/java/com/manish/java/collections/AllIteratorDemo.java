package com.manish.java.collections;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

/**
 * @author Manish
 *
 */
public class AllIteratorDemo {
	
	public static void main(String[] args) {
		//Enumaration;
		Vector vector = new Vector<>();
		vector.add("Manish");
		vector.addElement("Khushboo");
		vector.add(30);
		vector.addElement(32);
		Enumeration elements = vector.elements();
		while(elements.hasMoreElements()) {
			System.out.println(elements.nextElement());
		}
		// Iterator
		Iterator iterator = vector.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
			if(iterator.next().equals(30)) {
				iterator.remove();
			}
		}
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Manish");
		arrayList.add("Khushboo");
		arrayList.add(null);
		ListIterator<String> listIterator = arrayList.listIterator();
		while(listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}
	}

}
