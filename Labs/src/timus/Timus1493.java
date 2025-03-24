package timus;

import java.util.Scanner;

public class Timus1493 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int ticket = in.nextInt();
		int halfOne = ticket / 1000;
		int halfTwo = ticket % 1000;
		int sumOne = sumOfDigits(halfOne);
		
		if (sumOne == sumOfDigits(halfTwo - 1) || sumOne == sumOfDigits(halfTwo + 1))
		{
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		in.close();
	}
	
	private static int sumOfDigits(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}
}
