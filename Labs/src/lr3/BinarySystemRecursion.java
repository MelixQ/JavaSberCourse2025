package lr3;

import java.util.Scanner;

public class BinarySystemRecursion {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Введите число для перевода: ");
		int numberToConvert = in.nextInt();
		
		if (numberToConvert == 0) {
			System.out.println("0");
		} else {
			System.out.println(recursionDecimalToBinary(numberToConvert));
		}
		in.close();
	}
	
	private static String recursionDecimalToBinary(int n) {
		// Вспоминаю как вообще переводим: 14_10 -> 14 / 2 = 7 (0) / 2 = 3 (1) / 2 = 1 (1) / 2 = 0 (1) ==> 1110_2
		if (n == 0) {
			return "";
		} else {
			return recursionDecimalToBinary(n / 2) + (n % 2);
		}
	}
}
