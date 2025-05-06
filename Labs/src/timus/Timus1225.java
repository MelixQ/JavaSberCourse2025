package timus;

import java.util.Scanner;

public class Timus1225 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		in.close();
		System.out.println(countWays(N));
	}

	public static long countWays(int N) {
		// Базовые случаи
		if (N == 1) return 2;
		if (N == 2) return 2;
		/* Последовательность количенства способов для N полосок совпадает
			с удвоенной последовательностью Фибоначчи:
			M(N) = 2 * Fib(N + 1), где Fib(1) = 1, Fib(2) = 1, Fib(3) = 2

			Тогда для случаев помимо базовых (N>=3): M(N) = M(N - 1) + M(N - 2)
		* */
		long a = 2; // M(N-2)
		long b = 2; // M(N-1)
		long c = 0; // M(N)

		for (int i = 3; i <= N; i++) {
			// На каждой итерации сдвигаем a и b и обновляем c
			c = a + b;
			a = b;
			b = c;
		}
		// возвращаем M(N)
		return b;
	}
}
