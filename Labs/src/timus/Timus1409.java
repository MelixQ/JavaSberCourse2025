package timus;

import java.util.Arrays;
import java.util.Scanner;

public class Timus1409 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		in.close();
		
		int[] data = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
		
		int garryBottles = data[0], larryBottles = data[1];
		
		System.out.printf("%d %d", larryBottles - 1, garryBottles - 1);
	}
}
