package timus;

import java.util.Scanner;

public class Timus1209 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long N = scanner.nextInt();
		StringBuilder result = new StringBuilder();
		for (long i = 0; i < N; i++) {
			long K = scanner.nextInt();
			result.append(getDigit(K)).append(" ");
		}
		System.out.println(result.toString().trim());
	}
	
	private static char getDigit(long K) {
		/*
		* Последовательночть 1101001000100000...
		* Можно заметить, что
		* 1 - на 1
		* 1 - на 2
		* 1 - на 4
		* 1 - на 7
		* 1 - на 11 и так далее, т.е единица стоит на позиции 1 + (i * (i - 1)) / 2
		* Соответственно, если цифра в этой позиции, то там 1, иначе 0
		* Получается нужно решить квадратное уравнение K = 1 + (i * (i - 1)) / 2 относительно i
		* Упрощая получаем дискриминант D = 8K - 7
		* */
		long D = 8 * K - 7;
		long sqrtD = (long) Math.sqrt(D);
		// Если дискриминант полный квадрат - то K единица, иначе 0
		if (sqrtD * sqrtD == D) {
			return '1';
		} else {
			return '0';
		}
	}
}
