package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lr2_Task2_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			System.out.println("Введите размер массива: ");
			int size = in.nextInt();
			if (size <= 0) {
				throw new IllegalArgumentException("Размер массива должен быть положительным числом");
			}
			
			int[] array = new int[size];
			
			System.out.println("Вводите положительные целые числовые значения: ");
			for (int i = 0; i < array.length; i++) {
				array[i] = in.nextInt();
			}
			
			int sum = 0;
            int count = 0;
            for (int num : array) {
                if (num > 0) {
                    sum += num;
                    count++;
                }
            }
            
            if (count == 0) {
                throw new ArithmeticException("Положительные элементы отсутствуют");
            }
            
            double average = (double) sum / count;
            System.out.println("Среднее значение: " + average);
			
		} catch (InputMismatchException e) {
			System.out.println("Введено некорректное значение (вводите только целые числа)");
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		} catch (ArithmeticException e) {
			System.out.println(e);
		} finally {
			in.close();
		}
	}
}
