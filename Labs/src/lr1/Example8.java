package lr1;

import java.util.Scanner;

public class Example8 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

        System.out.println("Введите текущий день недели: ");
        String dayOfWeek = in.nextLine();

        System.out.println("Введите название месяца: ");
        String month = in.nextLine();

        System.out.println("Введите текущую дату: ");
        int date = in.nextInt();

        System.out.printf("Сегодня %d число месяца %s. День недели - %s\n", date, month, dayOfWeek);
        in.close();
	}
}
