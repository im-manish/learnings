package com.manish.java.interview;

import java.util.Base64;

import com.manish.java.core.Base36;

public class Test {
	public static void main(String[] args) {
		String str1 = "FB";
		String str2 = "Ea";
		String str3 = "FB";
		String str4 = "Ea";
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		System.out.println(Base36.decode(str1));
		System.out.println(Base36.decode(str2));
		System.out.println(Base36.decode(str3));
		System.out.println(Base36.decode(str4));

		Base64.getDecoder();
		//System.out.println(UUID.fromString(str1));
		
		
		
		
	}
}
