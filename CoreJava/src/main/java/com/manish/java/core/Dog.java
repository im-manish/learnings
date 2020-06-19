package com.manish.java.core;


/**
 * @author Manish
 *
 */
public class Dog implements Cloneable
{
	// Instance Variables
	String name;
	String breed;
	int age;
	String color;
	
	public Dog(){
	    
	}

	// Constructor Declaration of Class
	public Dog(String name, String breed,
				int age, String color)
	{
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.color = color;
	}

	// method 1
	public String getName()
	{
		return name;
	}

	// method 2
	public String getBreed()
	{
		return breed;
	}

	// method 3
	public int getAge()
	{
		return age;
	}

	// method 4
	public String getColor()
	{
		return color;
	}

	@Override
	public String toString()
	{
		return("Hi my name is "+ this.getName()+
			".\nMy breed,age and color are " +
			this.getBreed()+"," + this.getAge()+
			","+ this.getColor());
	}
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, CloneNotSupportedException
	{
		Dog tuffy = new Dog("tuffy","papillon", 5, "white");
		//tuffy = (Dog)Class.forName("com.manish.CoreJava.Dog").newInstance();
		Dog muffy = (Dog) tuffy.clone();
		System.out.println(muffy.toString());
	}
	
}
