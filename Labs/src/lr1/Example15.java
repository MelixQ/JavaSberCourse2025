package lr1;

import java.util.Scanner;

public class Example15 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Число 1: ");
		int num1 = in.nextInt();
		
		System.out.println("Число 2: ");
		int num2 = in.nextInt();
		
        System.out.printf("Cумма: %d | Разность: %d", num1 + num2, num1 - num2);
        in.close();
	}
}
