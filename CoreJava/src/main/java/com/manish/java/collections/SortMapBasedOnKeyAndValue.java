package com.manish.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Manish
 *
 */
public class SortMapBasedOnKeyAndValue {
	
	public static void main(String[] args) {
		HashMap<String,Integer> map = new HashMap<>();
		map.put("10", 10);
		map.put("5", 5);
		map.put("7", 7);
		map.put("55", 55);
		System.out.println(map);
		
		TreeMap<String, Integer> sortedMapBasedOnKey = new TreeMap<>(map);
		System.out.println(sortedMapBasedOnKey);
		
		/*Set<Entry<String, Integer>> entrySet = map.entrySet();
		System.out.println(entrySet);
		
		HashMap<String,Integer> map1 = new HashMap;*/
		Comparator<Entry<String, Integer>> myComparator = 
				(Entry<String, Integer> e1,Entry<String, Integer> e2) -> 
			{if(e1.getValue() < e2.getValue()) return -1; else if(e1.getValue() > e2.getValue())
				return 1; else return 0;};
		
				Set<Entry<String, Integer>> entrySet = map.entrySet();
				List<Entry<String, Integer>> unsortedList = new ArrayList<>(entrySet);
				Collections.sort(unsortedList, myComparator);
				LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
				for(Entry<String, Integer> entry: unsortedList) {
					sortedMap.put(entry.getKey(), entry.getValue());
				}
				System.out.println(sortedMap);
		
		
	}

}
