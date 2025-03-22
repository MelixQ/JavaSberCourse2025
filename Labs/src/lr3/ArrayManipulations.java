package lr3;

import java.util.Scanner;

public class ArrayManipulations {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Введите размер массива: ");
		
		int size = in.nextInt();
		int[] array = new int[size];
		
		System.out.println("Введите элементы массива: ");
		recursiveArrayInput(array, 0, in);
		
		System.out.println("Элементы массива: ");
		recursiveArrayPrint(array, 0);
	}
	
	private static void recursiveArrayInput(int[] arr, int index, Scanner scanner) {
		if (index >= arr.length) return;
		arr[index] = scanner.nextInt();
		recursiveArrayInput(arr, index + 1, scanner);
	}
	
	private static void recursiveArrayPrint(int[] arr, int index) {
		if (index >= arr.length) {
			System.out.println();
			return;
		}
		System.out.println(arr[index] + " ");
		recursiveArrayPrint(arr, index + 1);
	}
}
