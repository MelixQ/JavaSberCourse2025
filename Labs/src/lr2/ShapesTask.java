package lr2;

public class ShapesTask {
	public static void main(String[] args) {
		CircleShape circle = new CircleShape(0, 0, 3);
		circle.printInfo();
		System.out.println();
		
		SquareShape square = new SquareShape(0, 0, 5);
		square.printInfo();
		System.out.println();
		
		TriangleShape triangle = new TriangleShape(0, 0, 3, 4 ,5);
	    triangle.printInfo();
	}
}

abstract class Shape {
	private float x;
	private float y;
	
	public Shape(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract float getArea();
	public abstract float getPerimeter();
	public abstract void printInfo();
}

class CircleShape extends Shape {
	private float radius;
	
	public CircleShape(float x, float y, float radius) {
		super(x, y);
		this.radius = radius;
	}
	
	public float getArea() {
		return (float) (Math.PI * radius * radius);
	}
	
	public float getPerimeter() {
		return (float) (2 * Math.PI * radius);
	}
	
	public float getDiameter() {
		return 2 * radius;
	}
	
	public void printInfo() {
		System.out.println("Площадь круга: " + getArea());
		System.out.println("Периметр круга: " + getPerimeter());
		System.out.println("Диаметр: " + getDiameter());
	}
}

class SquareShape extends Shape {
	private float side;
	
	public SquareShape(float x, float y, float side) {
		super(x, y);
		this.side = side;
	}
	
	public float getArea() {
		return (float) (side * side);
	}
	
	public float getPerimeter() {
		return (float) (4 * side);
	}
	
	public float getDiagonal() {
		return (float) (side * Math.sqrt(2));
	}
	
	public void printInfo() {
		System.out.println("Площадь квадрата: " + getArea());
		System.out.println("Периметр квадрата: " + getPerimeter());
		System.out.println("Диагональ квадрата: " + getDiagonal());
	}
}

class TriangleShape extends Shape {
	private float a;
	private float b;
	private float c;
	
	public TriangleShape(float x, float y, float a, float b, float c) {
		super(x, y);
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public float getArea() {
		float p = (float) (a + b + c) * 0.5f;
		return (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
	}
	
	public float getPerimeter() {
		return a + b + c;
	}
	
	public boolean validateTriangle() {
		if (a + b <= c || a + c <= b || b + c <= a)
            return false;
        else
            return true;
	}
	
	public void printInfo() {
		System.out.println("Площадь треугольника: " + getArea());
		System.out.println("Периметр треугольника: " + getPerimeter());
		System.out.println("Реальный ли треугольник: " + validateTriangle());
	}
}
