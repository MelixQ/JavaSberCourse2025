package lr1;

import java.util.Scanner;

public class Example9 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        
		System.out.println("Введите название месяца: ");
        String month = in.nextLine();

        System.out.println("Введите количество дней в этом месяце: ");
        int date = in.nextInt();
        
        if (date == 30)
        	System.out.printf("Месяц %s содержит %d дней.\n", month, date);
        else
        	System.out.printf("Месяц %s содержит %d день.\n", month, date);
        in.close();
	}
}
