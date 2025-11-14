package chap9;

//Write a Java program to create an interface Shape with the getArea() method. 
//Create three classes Rectangle, Circle, and Triangle that implement the Shape interface. 
//Implement the getArea() method for each of the three classes.

interface CalculateShape {
	public void getArea();
}

class Rectangle implements CalculateShape{
	 double length;
	 double width;
	 
	 public Rectangle(double length, double width) {
		 this.length = length;
		 this.width = width;
	 }
	@Override
	public void getArea() {
		double result = length*width;
		System.out.println("The Rectangle Shape: " + String.format("%.2f", result));
	}
	
	
}
class Circle implements CalculateShape {
	double radius;
	double PI = Math.PI;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	@Override
	public void getArea() {
		double result = PI*radius*radius;
		System.out.println("The Circle Shape: " + String.format("%.2f", result));
		
	}
}

class Triangle implements CalculateShape {
	
	double base;
	double height;
	
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}
	
	@Override
	public void getArea() {
		double result = (base*height)/2;
		System.out.println("The Triangle Shape: " + String.format("%.2f", result));
	}
	
}
 
public class Shape {

	public static void main(String[] args) {
		Rectangle rec = new Rectangle(1.5, 2.3);
		Circle cir = new Circle(2.4);
		Triangle tri = new Triangle(1.5, 5);
		
		rec.getArea();
		cir.getArea();
		tri.getArea();
	}
}

