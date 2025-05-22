package timus;

import java.util.Scanner;

public class Timus2100 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        int guests = 2;
        int sum = 200;

        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            if (line.contains("+")) {
                sum += 200;
                guests += 2;
            } else {
                sum += 100;
                guests += 1;
            }
        }

        if (guests == 13) {
            sum += 100;
        }

        System.out.println(sum);
        in.close();
    }
}
