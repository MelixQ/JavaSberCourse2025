package lr2;

public class FiguresTask {
	public static void main(String[] args) {
		Circle circle = new Circle(3);
		Square square = new Square(2);
		Triangle triangle = new Triangle(3, 4, 5);
		
		circle.print();
		square.print();
		triangle.print();
	}
}

interface Figure {
	void print();
	double getArea();
	double getPerimeter();
}

class Circle implements Figure {
	
	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public void print() {
		System.out.println("------------КРУГ-----------");
		System.out.printf("Площадь круга: %.2f\n", getArea());
		System.out.printf("Периметр круга: %.2f\n", getPerimeter());
		System.out.println("---------------------------");
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}
}

class Square implements Figure {
	private double side;
	
	public Square(double side) {
		this.side = side;
	}
	
	public void print() {
		System.out.println("------------КВАДРАТ-----------");
		System.out.printf("Площадь квадрата: %.2f\n", getArea());
		System.out.printf("Периметр квадрата: %.2f\n", getPerimeter());
		System.out.println("----------------------------------");
	}

	public double getArea() {
		return side * side;
	}

	public double getPerimeter() {
		return 4 * side;
	}
}

class Triangle implements Figure {
	private double lengthOne;
	private double lengthTwo;
	private double lengthThree;
	
	public Triangle(double lengthOne, double lengthTwo, double lengthThree) {
		// Не будет проводить валидацию, представим что все треугольники реальные
		this.lengthOne = lengthOne;
		this.lengthTwo = lengthTwo;
		this.lengthThree = lengthThree;
	}
	
	public void print() {
		System.out.println("------------ТРЕУГОЛЬНИК-----------");
		System.out.printf("Площадь круга: %.2f\n", getArea());
		System.out.printf("Периметр круга: %.2f\n", getPerimeter());
		System.out.println("----------------------------------");
	}

	public double getArea() {
		double p = (lengthOne + lengthTwo + lengthThree) * 0.5;
		return Math.sqrt(p * (p - lengthOne) * (p - lengthTwo) * (p - lengthThree));
	}

	public double getPerimeter() {
		return lengthOne + lengthTwo + lengthThree;
	}
}