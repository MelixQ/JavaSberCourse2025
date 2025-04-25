package timus;

import java.util.Scanner;

public class Timus2111 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += scanner.nextInt();
        }
        scanner.close();
        System.out.println(sum * sum);
	}
}
