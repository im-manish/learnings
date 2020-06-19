package com.manish.java.oops;

public class AbstractClassExample {
   public static void main(String[] args) {
	/*Circle circle = new Circle("Red", 4.5);
	Rectangle rectangel = new Rectangle("Blue", 4.3, 2.5);
	circle.fun();
	rectangel.fun();*/
	   Shape s = new Shape("Abc") {
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		double area() {
			// TODO Auto-generated method stub
			return 0;
		}
	};
}
}

abstract class Shape {
	String color;

	abstract double area();

	public abstract String toString();

	public Shape(String color) {
		System.out.println("Abstract Constructor call");
		this.color = color;
	}

	public String getColor() {
		return color;
	}
	private void fun() {
		System.out.println("Shape fun called");
	}

}







class Circle extends Shape {

	double radius;
	
	 public Circle(String color, double radius) {
			super(color);
			this.radius = radius;
		}

	@Override
	double area() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public String toString() {
		return "Circle color is " + super.color + " and area is : " + area();
	}
	public void fun() {
		System.out.println("Circle fun called");
	}

}

class Rectangle extends Shape{
    double length;
    double width;
	public Rectangle(String color, double length, double width) {
		super(color);
		this.length = length;
		this.width = width;
	}

	@Override
	double area() {
		return length * width;
	}

	@Override
	public String toString() {
		return "Rectange color is " + super.color + " and area is : " + area();
	}
	public void fun() {
		System.out.println("Circle fun called");
	}
	
}