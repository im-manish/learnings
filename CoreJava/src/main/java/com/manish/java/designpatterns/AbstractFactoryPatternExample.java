package com.manish.java.designpatterns;

/**
 * @author Manish
 *
 */

// One step above factory pattern 
public class AbstractFactoryPatternExample {
	public static void main(String[] args) {
		ComputerInterface desktop = ComputerFactoryNew.getComputer(new DesktopFactory("4 GB", "1 TB", "2.5 Ghz."));
		ComputerInterface laptop = ComputerFactoryNew.getComputer(new LaptopPCFactory("8 GB", "2 TB", "4.5 Ghz."));
		System.out.println(desktop.getString());
		System.out.println(desktop.getString());
	}

}

interface ComputerInterface {
	public abstract String getRAM();

	public abstract String getHDD();

	public abstract String getCPU();

	default String getString() {
		return "Computer [getRAM()=" + getRAM() + ", getHDD()=" + getHDD() + ", getCPU()=" + getCPU() + "]";
	}
}

class Desktop implements ComputerInterface {
	private String RAM;
	private String HDD;
	private String CPU;

	public Desktop(String rAM, String hDD, String cPU) {
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
class LaptopPC implements ComputerInterface {
	private String RAM;
	private String HDD;
	private String CPU;

	public LaptopPC(String rAM, String hDD, String cPU) {
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

interface ComputerFactoryInterface {
	
	public ComputerInterface createComputer();
}


class DesktopFactory implements ComputerFactoryInterface {
	private String RAM;
	private String HDD;
	private String CPU;

	public DesktopFactory(String rAM, String hDD, String cPU) {
		super();
		RAM = rAM;
		HDD = hDD;
		CPU = cPU;
	}



	@Override
	public ComputerInterface createComputer() {
		return new Desktop(RAM, HDD, CPU);
	}
	
}

class LaptopPCFactory implements ComputerFactoryInterface {
	private String RAM;
	private String HDD;
	private String CPU;

	public LaptopPCFactory(String rAM, String hDD, String cPU) {
		super();
		RAM = rAM;
		HDD = hDD;
		CPU = cPU;
	}



	@Override
	public ComputerInterface createComputer() {
		return new Desktop(RAM, HDD, CPU);
	}
	
}


class ComputerFactoryNew {
	
	public static ComputerInterface getComputer(ComputerFactoryInterface factory) {
		return factory.createComputer();
	}
	
}