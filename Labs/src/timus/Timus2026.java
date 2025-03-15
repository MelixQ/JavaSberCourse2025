package timus;

import java.util.Scanner;

public class Timus2026 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean hasThree = false;
        boolean allFive = true;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            int grade = in.nextInt();
            if (grade == 3) hasThree = true;
            if (grade != 5) allFive = false;
            sum += grade;
        }
        
        if (hasThree) {
            System.out.println("None");
        } else if (allFive) {
            System.out.println("Named");
        } else {
            double average = (double) sum / n;
            System.out.println(average >= 4.5 ? "High" : "Common");
        }
        
        in.close();
	}
}
