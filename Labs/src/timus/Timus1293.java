package timus;

import java.util.Arrays;
import java.util.Scanner;

public class Timus1293 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		in.close();
		
		int[] data = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
		
		int N = data[0], A = data[1], B = data[2];
		
		System.out.println((A * B * 2) * N);
	}
}
