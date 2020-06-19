package com.manish.java.core;

/**
 * @author Manish
 *
 */
public abstract  class StringComparisonDemo {
	public static void main(String[] args) {
		
		/*String s1=new String("you cannot change me!");
		String s2=new String("you cannot change me!");
		System.out.println(s1==s2);//fals
		String s3="you cannot change me!";
		System.out.println(s1==s3);//false
		String s4="you cannot change me!";
		System.out.println(s3==s4);//true
		String s5="you cannot "+"change me!";
		System.out.println(s3==s5);//true
		String s6="you cannot ";
		// runtime change in string then object created only in heap not in SCP 
		String s7=s6+"change me!";
		System.out.println(s3==s7);//false
		final String s8="you cannot ";
		// in case of final compile time resolution happens so s9="you cannot change me!" at compile time only
		String s9=s8+"change me!";
		System.out.println(s3==s9);//true
		System.out.println(s6==s8);//true
		System.out.println(s4);
		//intern 
		String s10 = s3.intern();
		s10=s8;
		System.out.println(s10);
		System.out.println(s4);*/
		
		
		
		String s1=new String("ashok");
		String s2=s1.toString();
		String s3=s1.toUpperCase();
		String s4=s1.toLowerCase();
		String s5=s4.toUpperCase();
		String s6=s3.toLowerCase();
		System.out.println(s1.hashCode());//123456
		System.out.println(s2.hashCode());//123456
		System.out.println(s3.hashCode());//345678
		System.out.println(s4.hashCode());//123456
		System.out.println(s5.hashCode());//345678
		System.out.println(s6.hashCode());//456789
		
		
		/*String a = "abc";
		String b = "abc";
		String c = "ABC";
		//No change in content same object will reuse;
		String d = c.toUpperCase();
		//change in content so new object created but only in heap not in scp
		String e =  a.toUpperCase();
		
		String f = new String("ABC");
		String g = f.toLowerCase();
		String h = c.toLowerCase();
		System.out.println(a==b); // true
		System.out.println(d==c); //true
		System.out.println(d==e);//false
		System.out.println(f==e); // false
		System.out.println(g==h);//false
*/		
		
		/*String s3="you cannot change me!";
		String s6="you cannot ";
		String s7=s6+"change me!";
		System.out.println(s3==s7);//false
		final String s8="you cannot ";
		// in case of final compiler assign the value directly so 
		// s9 = S8+"Change me" become s9="you cannot" + "change me";
		// but in case of non final variable replacement happens at runtime.
		// for more details decompile the .class file and check.
		String s9=s8+"change me!";
		System.out.println(s3==s9);//true
		System.out.println(s6==s8);//true 
*/	}
}
