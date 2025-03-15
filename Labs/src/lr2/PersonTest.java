package lr2;

public class PersonTest {
	public static void main(String[] args) {
		Person maxim = new Person("Maxim Kuznetsov", 23, "Male");
		
		System.out.println("Имя: " + maxim.getName());
		System.out.println("Возраст: " + maxim.getAge());
		System.out.println("Пол: " + maxim.getGender());
		
		maxim.setAge(42);
		System.out.println("Возраст (изм.): " + maxim.getAge());
	}
}
