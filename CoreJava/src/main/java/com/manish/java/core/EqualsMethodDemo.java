package com.manish.java.core;

/**
 * @author Manish
 *
 */
class EqualTest1 {
	int rollno;
	String name;
//	
	public EqualTest1(int rollno, String name) {
		this.rollno = rollno;
		this.name = name;
	}
	
	
}
class EqualTest2 {
	int rollNo;
	String name;
	public EqualTest2(int rollNo, String name) {
		super();
		this.rollNo = rollNo;
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rollNo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EqualTest2))
			return false;
		EqualTest2 other = (EqualTest2) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rollNo != other.rollNo)
			return false;
		return true;
	}
	
	
	
}
public class EqualsMethodDemo {
	
	public static void main(String[] args) {
		EqualTest1 eqt1 = new EqualTest1(10, "Manish");
		EqualTest1 eqt2 = new EqualTest1(10, "Manish");
		EqualTest1 eqt3=eqt2;
		System.out.println(eqt1.equals(eqt2));
		System.out.println(eqt3.equals(eqt2)+"\n == Comparison Result ->"+(eqt3== eqt2));
		
		EqualTest2 eqt12 = new EqualTest2(10,"Khushboo");
		EqualTest2 eqt13 = new EqualTest2(10,"Khushboo");
		EqualTest2 eqt14 = eqt12;
		System.out.println(eqt12.equals(eqt13));
		System.out.println(eqt13.equals(eqt14) +"\n == comparison Result ->"+(eqt12 == eqt14));

		
		
	}
}
