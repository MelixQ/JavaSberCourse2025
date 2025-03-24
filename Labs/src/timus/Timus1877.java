package timus;

import java.util.Scanner;

public class Timus1877 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String lockOne = in.nextLine();
		String lockTwo = in.nextLine();
		boolean result = (Integer.parseInt(lockOne) % 2 == 0) || (Integer.parseInt(lockTwo) % 2 == 1);
		if (result)
		{
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
		in.close();
	}
}
