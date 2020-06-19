package com.manish.java.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Manish
 *
 */
public class SetDemo {
	
	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<>();
		hashSet.add("Manish");
		hashSet.add("Khushboo");
		hashSet.add(null);
		hashSet.add(null);
		hashSet.forEach(name -> System.out.println(name));
		
		// LinkedHashSet insertion Order preserve
		System.out.println("Linked HashSet\n");
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("Manish");
		linkedHashSet.add("Khushboo");
		linkedHashSet.add(null);
		linkedHashSet.add(null);
		linkedHashSet.forEach(name -> System.out.println(name));
		
		// SortedSet
		SortedSet<Integer> sortedSet = new TreeSet<>();
		sortedSet.add(100);
		sortedSet.add(90);
		sortedSet.add(2);
		sortedSet.add(120);
		sortedSet.add(50);
		
		System.out.println(sortedSet);
		System.out.println(sortedSet.first());
		System.out.println(sortedSet.last());
		
		System.out.println(sortedSet.subSet(50, 90));
		System.out.println(sortedSet.tailSet(50));
		System.out.println(sortedSet.headSet(90));
		
		//TreeSet
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(10);
		treeSet.add(100);
		treeSet.add(1000);
		//treeSet.add(null);
		System.out.println(treeSet);
	}

}
