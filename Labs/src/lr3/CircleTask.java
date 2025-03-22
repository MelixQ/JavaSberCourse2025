package lr3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CircleTask {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> arrayList = new ArrayList<>();
		LinkedList<Integer> linkedList = new LinkedList<>();
		
		System.out.println("Введите количество людей N: ");
		int n = in.nextInt();
		
        for (int i = 1; i <= n; i++) {
        	arrayList.add(i);
        	linkedList.add(i);
        }
		
		long startTime = System.currentTimeMillis();
        measureArrayList(n, arrayList);
        long endTime = System.currentTimeMillis();
        System.out.println("ArrayList: " + (endTime - startTime) + " миллисекунд");
		
        startTime = System.currentTimeMillis();
		measureLinkedList(n, linkedList); 
		endTime = System.currentTimeMillis();
		System.out.println("LinkedList: " + (endTime - startTime) + " миллисекунд");
		
		in.close();
	}
	
	private static void measureArrayList(int N, ArrayList<Integer> list) {
        int index = 0;
        while (list.size() > 1) {
            index = (index + 1) % list.size();
            list.remove(index);
            if (index == list.size()) {
                index = 0;
            }
        }
    }

    private static void measureLinkedList(int N, LinkedList<Integer> list) {
    	int index = 0;
        while (list.size() > 1) {
            index = (index + 1) % list.size();
            list.remove(index);
            if (index == list.size()) {
                index = 0;
            }
        }
    }
}
