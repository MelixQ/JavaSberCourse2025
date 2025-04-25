package lr5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lr5_Example1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Размер массива: ");
		int size = in.nextInt();
		in.close();
		
		int[] arr = new int[size];
		
		Random rnd = new Random();
		for (int i = 0; i < size; i++) {
			arr[i] = rnd.nextInt(100);
		}
		
		System.out.println("Массив: ");
		System.out.println(Arrays.toString(arr));
		
		int[] arrResult = filterEvenNumbers(arr);
		System.out.println("Массив после stream().filter(): ");
		System.out.println(Arrays.toString(arrResult));
	}
	
	public static int[] filterEvenNumbers(int[] arr) {
		return Arrays.stream(arr).filter(x -> x % 2 == 0).toArray();
	}
}
