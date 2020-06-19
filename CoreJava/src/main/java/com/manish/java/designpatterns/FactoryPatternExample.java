package com.manish.java.designpatterns;

/**
 * @author Manish
 *
 */

//Factory design pattern is used when we have a super class with multiple sub-classes and based on input, we need to return one of the sub-class
abstract class Computer {
	
	public abstract String getRAM();
	public abstract String getHDD();
	public abstract String getCPU();
	
	@Override
	public String toString() {
		return "Computer [getRAM()=" + getRAM() + ", getHDD()=" + getHDD() + ", getCPU()=" + getCPU() + "]";
	}
	
}

class DesktopPC extends Computer {
	
	private String RAM;
	private String HDD;
	private String CPU;

	public DesktopPC(String rAM, String hDD, String cPU) {
		super();
		RAM = rAM;
		HDD = hDD;
		CPU = cPU;
	}

	@Override
	public String getRAM() {
		return this.RAM;
	}

	@Override
	public String getHDD() {
		return this.HDD;
	}

	@Override
	public String getCPU() {
		return this.CPU;
	}
	
}

class Laptop extends Computer {
	
	private String RAM;
	private String HDD;
	private String CPU;
	
	

	public Laptop(String rAM, String hDD, String cPU) {
		super();
		RAM = rAM;
		HDD = hDD;
		CPU = cPU;
	}

	@Override
	public String getRAM() {
		return this.RAM;
	}

	@Override
	public String getHDD() {
		return this.HDD;
	}

	@Override
	public String getCPU() {
		return this.CPU;
	}
	
}

class ComputerFactory {
	
	public static Computer getComputer(String type, String RAM, String HDD, String CPU) {
		if("DesktopPC".equals(type)) {
			return new DesktopPC(RAM, HDD, CPU);
		} else if("Laptop".equals(type)) {
			return new Laptop(RAM, HDD, CPU);
		}
		return null;
	}
}

public class FactoryPatternExample {
	public static void main(String[] args) {
       Computer desktopPc = ComputerFactory.getComputer("DesktopPC", "4 GB", "1 TB", "2.5 GHz");
       Computer laptop = ComputerFactory.getComputer("Laptop", "6 GB", "5 TB", "4.5 GHz");
       
       System.out.println(desktopPc);
       System.out.println(laptop);
       
	}
}
