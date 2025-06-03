package timus;

import java.util.Scanner;

public class Timus1567 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        var s = scan.nextLine();
        var c = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = switch (c[i]) {
                case 'a', 'd', 'g', 'j', 'm', 'p', 's', 'v', 'y', '.', ' ' -> sum + 1;
                case 'b', 'e', 'h', 'k', 'n', 'q', 't', 'w', 'z', ',' -> sum + 2;
                case 'c', 'f', 'i', 'l', 'o', 'r', 'u', 'x', '!' -> sum + 3;
                default -> sum;
            };
        }
        System.out.println(sum);
    }
}
