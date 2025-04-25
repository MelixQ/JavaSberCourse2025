package timus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Timus2002 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        HashMap<String, String> users = new HashMap<>();
        HashSet<String> loggedInUsers = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String command = parts[0];
            String username = parts[1];

            switch (command) {
                case "register":
                    String password = parts[2];
                    if (users.containsKey(username)) {
                        System.out.println("fail: user already exists");
                    } else {
                        users.put(username, password);
                        System.out.println("success: new user added");
                    }
                    break;
                case "login":
                    password = parts[2];
                    if (!users.containsKey(username)) {
                        System.out.println("fail: no such user");
                    } else if (!users.get(username).equals(password)) {
                        System.out.println("fail: incorrect password");
                    } else if (loggedInUsers.contains(username)) {
                        System.out.println("fail: already logged in");
                    } else {
                        loggedInUsers.add(username);
                        System.out.println("success: user logged in");
                    }
                    break;
                case "logout":
                    if (!users.containsKey(username)) {
                        System.out.println("fail: no such user");
                    } else if (!loggedInUsers.contains(username)) {
                        System.out.println("fail: already logged out");
                    } else {
                        loggedInUsers.remove(username);
                        System.out.println("success: user logged out");
                    }
                    break;
            }
        }
    }
}
