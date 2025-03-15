package lr2;

public class RectangleTest {
	public static void main(String[] args) {
		Rectangle rect = new Rectangle(3, 5);
		
		System.out.println("Длина: " + rect.getWidth());
		System.out.println("Ширина: " + rect.getHeight());
		System.out.println("Площадь: " + rect.getArea());
		System.out.println("Периметр: " + rect.getPerimeter());
	}
}
