package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lr2_Task2_3 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Введите размер массива: ");
            int size = in.nextInt();

            if (size <= 0) {
                throw new IllegalArgumentException("Массив не может быть отрицательным");
            }

            byte[] array = new byte[size];
            System.out.println("Введите элементы массива (тип byte):");
            for (int i = 0; i < size; i++) {
                System.out.print("Элемент [" + i + "]: ");
                array[i] = in.nextByte();
            }

            byte sum = 0;
            for (byte num : array) {
                if ((sum > 0 && num > Byte.MAX_VALUE - sum) || (sum < 0 && num < Byte.MIN_VALUE - sum)) {
                    throw new ArithmeticException("Сумма вышла за пределы диапазона типа byte");
                }
                sum += num;
            }

            System.out.println("Сумма элементов массива: " + sum);

        } catch (InputMismatchException e) {
            System.out.println("Введено некорректное значение (вводите только байтовые числа)");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } catch (ArithmeticException e) {
            System.out.println(e);
        } finally {
            in.close();
        }
    }
}
