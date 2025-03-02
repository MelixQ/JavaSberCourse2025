package lr1;

import java.time.Year;
import java.util.Scanner;

public class Example11 {
	public static void main(String[] args) {
		int year = Year.now().getValue();

		Scanner in = new Scanner(System.in);
		
		System.out.println("Введите ваше имя: ");
		String name = in.nextLine();
		
		System.out.println("Введите год рождения: ");
        int yearOfBirth = in.nextInt();
 
        System.out.printf("%s, возраст = %d", name, year - yearOfBirth);
        in.close();
	}
}
