package timus;

import java.util.Scanner;

public class Timus1197 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        
        for (int i = 0; i < N; i++) {
            String position = in.nextLine().trim();
            int x = position.charAt(0) - 'a';
            int y = position.charAt(1) - '1';
            
            int[][] moves = {
                {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
                {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
            };
            
            int count = 0;
            for (int[] move : moves) {
                int newX = x + move[0];
                int newY = y + move[1];
                if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                    count++;
                }
            }
            
            System.out.println(count);
        }
        in.close();
    }
}
