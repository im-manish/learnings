package com.canvera.java.innerclasses;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Manish
 *
 */
public class ImmutableClassExample {
	
	private final Integer id;
	private final String name;
	private final HashMap<String, String> testMap;
	
	
	public ImmutableClassExample(Integer i, String str, HashMap<String, String> hashmap) {
		super();
		this.id = i;
		this.name = str;
		HashMap<String,String> tempMap=new HashMap<String,String>();
		String key;
		Iterator<String> it = hashmap.keySet().iterator();
		while(it.hasNext()){
			key=it.next();
			tempMap.put(key, hashmap.get(key));
		}
		this.testMap=tempMap;
	}
	
	
	
	public Integer getId() {
		return id;
	}



	public String getName() {
		return name;
	}



	public HashMap<String, String> getTestMap() {
		return testMap;
	}



	public static void main(String[] args) {
		HashMap<String, String> h1 = new HashMap<String,String>();
		h1.put("1", "first");
		h1.put("2", "second");
		
		String s = "original";
		
		int i=10;
		
		ImmutableClassExample ce = new ImmutableClassExample(i,s,h1);
		
		//Lets see whether its copy by field or reference
		System.out.println(s==ce.getName());
		System.out.println(h1 == ce.getTestMap());
		//print the ce values
		System.out.println("ce id:"+ce.getId());
		System.out.println("ce name:"+ce.getName());
		System.out.println("ce testMap:"+ce.getTestMap());
		//change the local variable values
		i=20;
		s="modified";
		h1.put("3", "third");
		//print the values again
		System.out.println("ce id after local variable change:"+ce.getId());
		System.out.println("ce name after local variable change:"+ce.getName());
		System.out.println("ce testMap after local variable change:"+ce.getTestMap());
		
		HashMap<String, String> hmTest = ce.getTestMap();
		hmTest.put("4", "new");
		
		System.out.println("ce testMap after changing variable from accessor methods:"+ce.getTestMap());
	}
	
	

}
