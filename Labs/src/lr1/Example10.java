package lr1;

import java.time.Year;
import java.util.Scanner;

public class Example10 {
	public static void main(String[] args) {
		int year = Year.now().getValue();

		Scanner in = new Scanner(System.in);
		System.out.println("Введите год рождения: ");
        int yearOfBirth = in.nextInt();
 
        System.out.printf("Ваш возраст = %d", year - yearOfBirth);
        in.close();
	}
}
