package timus;

import java.util.Scanner;

public class Timus1785 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		
		String word;
        if (input >= 1 && input <= 4) {
            word = "few";
        } else if (input >= 5 && input <= 9) {
            word = "several";
        } else if (input >= 10 && input <= 19) {
            word = "pack";
        } else if (input >= 20 && input <= 49) {
            word = "lots";
        } else if (input >= 50 && input <= 99) {
            word = "horde";
        } else if (input >= 100 && input <= 249) {
            word = "throng";
        } else if (input >= 250 && input <= 499) {
            word = "swarm";
        } else if (input >= 500 && input <= 999) {
            word = "zounds";
        } else if (input >= 1000) {
            word = "legion";
        } else {
            word = "некорректное значение";
        }

        System.out.println(word);
        in.close();
	}
}
