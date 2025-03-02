package timus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Timus1585 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        
        Map<String, Integer> penguinCounts = new HashMap<>();
        penguinCounts.put("Emperor Penguin", 0);
        penguinCounts.put("Little Penguin", 0);
        penguinCounts.put("Macaroni Penguin", 0);

        for (int i = 0; i < n; i++) {
            String penguin = in.nextLine();
            penguinCounts.put(penguin, penguinCounts.get(penguin) + 1);
        }

        String mostPopular = "";
        int maxCount = -1;

        for (Map.Entry<String, Integer> entry : penguinCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostPopular = entry.getKey();
            }
        }

        System.out.println(mostPopular);
        in.close();
	}
}
