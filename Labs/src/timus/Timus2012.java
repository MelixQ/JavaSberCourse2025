package timus;

import java.util.Scanner;

public class Timus2012 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tasksForFirstHour = in.nextInt();
		
		int timeLeft = 300;
		int tasks = 12;
		
		tasks -= tasksForFirstHour;
		timeLeft -= 60;
		
		for (int i = timeLeft; i >= 0; i -= 45) {
			tasks -= 1;
		}
		
		if (tasks >= 0)
			System.out.println("NO");
		else
			System.out.println("YES");
	
		in.close();
	}
}
