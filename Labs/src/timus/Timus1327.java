package timus;

import java.util.Scanner;

public class Timus1327 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		if ((B % 2) != 0 || (A % 2) != 0)
			System.out.println((B - A) / 2 + 1);
		else
			System.out.println((B - A) / 2);
		in.close();
	}
}
