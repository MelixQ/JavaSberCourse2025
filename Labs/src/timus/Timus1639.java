package timus;

import java.util.Scanner;

public class Timus1639 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        int totalMoves = m * n - 1;

        if (totalMoves % 2 == 1) {
            System.out.println("[:=[first]");
        } else {
            System.out.println("[second]=:]");
        }
    }
}
