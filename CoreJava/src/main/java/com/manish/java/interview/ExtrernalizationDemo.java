package com.manish.java.interview;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExtrernalizationDemo implements Externalizable {
	private String name;
	private String password;
	private int age;
	private String address;

	public ExtrernalizationDemo() {
		// TODO Auto-generated constructor stub
	}

	public ExtrernalizationDemo(String name, String password, int age, String address) {
		super();
		this.name = name;
		this.password = password;
		this.age = age;
		this.address = address;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeInt(age);
		out.writeObject(address);

	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name = (String) in.readObject();
		age = in.readInt();
		address = (String) in.readObject();

	}

	@Override
	public String toString() {
		return "ExtrernalizationDemo [name=" + name + ", password=" + password + ", age=" + age + ", address=" + address
				+ "]";
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ExtrernalizationDemo extrernalizationDemo = new ExtrernalizationDemo("Manish", "Bhaisi", 30, "Dujra");
		System.out.println(extrernalizationDemo);
		FileOutputStream fileOutputStream = new FileOutputStream("ExternalizableDemo.exr");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(extrernalizationDemo);
		
		FileInputStream fileInputStream = new FileInputStream("ExternalizableDemo.exr");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		ExtrernalizationDemo readObject = (ExtrernalizationDemo) objectInputStream.readObject();
		System.out.println(readObject);
		
		
		
	}

}
