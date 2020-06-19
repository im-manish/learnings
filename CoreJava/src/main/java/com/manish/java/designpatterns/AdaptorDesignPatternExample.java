package com.manish.java.designpatterns;

/**
 * @author Manish
 *
 */
interface Bird {
	 public void makeSound();
	 public void fly();
}

interface ToyDuck {
	
	public void squeez();
}

class Sparrow implements Bird {

	@Override
	public void makeSound() {
		System.out.println("Make Sound Chee chee");
		
	}

	@Override
	public void fly() {
		System.out.println("Fly to the moon");
		
	}
	
}

class PlasticDuck implements ToyDuck {

	@Override
	public void squeez() {
		System.out.println("Make sqeez quek quek");
		
	}
	
}

class BirdAdaptor extends Sparrow implements ToyDuck {

	@Override
	public void squeez() {
		makeSound();
		
	}
}

public class AdaptorDesignPatternExample {
	
	public static void main(String[] args) {
		Sparrow sparrow = new Sparrow();
		PlasticDuck plasticDuck = new PlasticDuck();
		sparrow.fly();
		sparrow.makeSound();
		plasticDuck.squeez();
		ToyDuck birdAdaptor = new BirdAdaptor();
		birdAdaptor.squeez();
	}

	
}

