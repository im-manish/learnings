package com.manish.java.interview;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationDemo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public SerializationDemo() {
		// TODO Auto-generated constructor stub
	}
	SerializationDemo(String name, String password){
		this.name = name;
		this.password = password;
	}
	private void readObject(ObjectInputStream is) throws ClassNotFoundException, IOException {
		/*is.defaultReadObject();
		String epwd=(String)is.readObject();
		this.password = epwd.substring(3);*/
		this.name = (String)is.readObject();
	}
	
	private void writeObject(ObjectOutputStream os) throws IOException {
		os.writeObject(this.name);
		/*os.defaultWriteObject();
		String epwd="123"+password;
		os.writeObject(epwd);*/
	}
	
	
	
	
  @Override
	public String toString() {
		return "SerializationDemo [name=" + name + ", password=" + password + "]";
	}
public static void main(String[] args) throws IOException, ClassNotFoundException {
	SerializationDemo serializationDemo = new SerializationDemo("Manish", "Bhaisi");
	System.out.println(serializationDemo);
	FileOutputStream fileOutputStream = new FileOutputStream("SerializationDemo.ser");
	ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
	objectOutputStream.writeObject(serializationDemo);
	FileInputStream fileInputStream = new FileInputStream("SerializationDemo.ser");
	ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	SerializationDemo serializationDemo1 = (SerializationDemo)objectInputStream.readObject();
	System.out.println(serializationDemo1);
}	

}
