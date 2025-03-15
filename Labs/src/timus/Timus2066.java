package timus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Timus2066 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        
        List<int[]> permutations = generatePermutations(a, b, c);
        int minResult = Integer.MAX_VALUE;
        
        for (int[] perm : permutations) {
            int x = perm[0];
            int y = perm[1];
            int z = perm[2];
            
            for (char op1 : new char[]{'+', '-', '*'}) {
                for (char op2 : new char[]{'+', '-', '*'}) {
                    int current = computeValue(x, y, z, op1, op2);
                    if (current < minResult) {
                        minResult = current;
                    }
                }
            }
        }
        
        System.out.println(minResult);
        in.close();
    }
	
	private static List<int[]> generatePermutations(int a, int b, int c) {
        List<int[]> permutations = new ArrayList<>();
        permutations.add(new int[]{a, b, c});
        permutations.add(new int[]{a, c, b});
        permutations.add(new int[]{b, a, c});
        permutations.add(new int[]{b, c, a});
        permutations.add(new int[]{c, a, b});
        permutations.add(new int[]{c, b, a});
        return permutations;
    }
    
    private static int computeValue(int x, int y, int z, char op1, char op2) {
        if (op2 == '*') {
            int right = evaluate(y, z, op2);
            return evaluate(x, right, op1);
        } else if (op1 == '*') {
            int left = evaluate(x, y, op1);
            return evaluate(left, z, op2);
        } else {
            int left = evaluate(x, y, op1);
            return evaluate(left, z, op2);
        }
    }
    
    private static int evaluate(int a, int b, char op) {
        switch(op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            default: throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }
}
