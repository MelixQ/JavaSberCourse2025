package lr1;

import java.util.Scanner;

public class Example14 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Число: ");
		int num = in.nextInt();
		int prev = num - 1;
		int next = num + 1;
		
		int sum = num + prev + next;
		int square = sum * sum;
        System.out.printf(
        		"Итоговая последовательность: | %d | %d | %d | %d |",
        		prev, num, next, square);
        in.close();
	}
}
