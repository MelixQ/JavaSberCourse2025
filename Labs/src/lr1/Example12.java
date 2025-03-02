package lr1;

import java.time.Year;
import java.util.Scanner;

public class Example12 {
	public static void main(String[] args) {
		int year = Year.now().getValue();

		Scanner in = new Scanner(System.in);
		
		System.out.println("Введите ваш возраст: ");
		int age = in.nextInt();
		
        System.out.printf("Год рождения = %d", year - age);
        in.close();
	}
}
