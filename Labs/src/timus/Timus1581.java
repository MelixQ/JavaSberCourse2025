package timus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Timus1581 {
    public static void main(String[] args) {
        // Решаем задачу RLE
        // Заменяем сами элементы на количество элементов
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");
        scanner.close();

        List<Integer> result = new ArrayList<>();
        if (input.length == 0) {
            System.out.println();
            return;
        }

        int count = 1;
        int current = Integer.parseInt(input[0]);

        for (int i = 1; i < input.length; i++) {
            int next = Integer.parseInt(input[i]);
            if (next == current) {
                count++;
            } else {
                result.add(count);
                result.add(current);
                current = next;
                count = 1;
            }
        }

        result.add(count);
        result.add(current);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
