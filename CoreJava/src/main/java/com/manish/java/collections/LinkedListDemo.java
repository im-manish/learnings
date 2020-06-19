package com.manish.java.collections;

import java.util.LinkedList;

/**
 * @author Manish
 *
 */
public class LinkedListDemo {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.add("Manish");
		linkedList.add(30);
		linkedList.add("Khushboo");
		System.out.println(linkedList);
		linkedList.set(0, "First");
		System.out.println(linkedList);
		linkedList.removeFirst();
		linkedList.removeLast();
		System.out.println(linkedList);
		
	}

}