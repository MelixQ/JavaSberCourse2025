package lr1;

import java.util.Scanner;

public class Example13 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Число 1: ");
		int num1 = in.nextInt();
		
		System.out.println("Число 2: ");
		int num2 = in.nextInt();
		
        System.out.printf("Сумма чисел = %d", num1 + num2);
        in.close();
	}
}
