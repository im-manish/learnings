package com.manish.java.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;

/**
 * @author Manish
 *
 */
public class MapDemo {
	// Here we will check the IdentityHashMap And WeekHashMap
	
	public static void main(String[] args) {
		/*//IdentityMap compare key with == operator in case of duplicate;
		IdentityHashMap<Integer, String> identityHashMap = new IdentityHashMap<>();
		Integer i1 = new Integer(10);
		Integer i2 = new Integer(10);
		identityHashMap.put(i1, "Manish");
		identityHashMap.put(i2, "Khushboo");
		System.out.println(identityHashMap);
		HashMap<Integer, String> hashMap = new HashMap<>();
		hashMap.putAll(identityHashMap);
		System.out.println(hashMap);
		
		//WeakHashMap if key is eligible for gc then it will gc but in case of normal hashmap it's not
		WeakHashMap<Object, String> weakHashMap = new WeakHashMap<>();
		Integer i = new Integer(11);
		weakHashMap.put(i, "Manish");
		hashMap.put(i, "Pawan");
		System.out.println(weakHashMap);
		i=null;
		System.gc();
		System.out.println(weakHashMap);
		System.out.println(hashMap);*/
		
		System.out.println();
		
		
		
	}
}
