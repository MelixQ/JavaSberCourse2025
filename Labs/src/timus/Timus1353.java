package timus;

import java.util.Scanner;

public class Timus1353 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int S = in.nextInt();
        in.close();
        
        long[][] dp = new long[10][82];
        dp[0][0] = 1;
        
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= 81; j++) {
                for (int k = 0; k <= 9; k++) {
                    if (j >= k) {
                        dp[i][j] += dp[i-1][j - k];
                    }
                }
            }
        }
        
        long result = dp[9][S];
        if (S == 1) {
            result += 1;
        }
        
        System.out.println(result);
	}
}
