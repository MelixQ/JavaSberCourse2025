package lr4;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Lr2_Task2_2 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Введите количество строк матрицы: ");
            int rows = in.nextInt();

            System.out.print("Введите количество столбцов матрицы: ");
            int cols = in.nextInt();

            if (rows <= 0 || cols <= 0) {
                throw new IllegalArgumentException(
                		"Размеры могут быть только положительными числами"
                		);
            }

            int[][] matrix = new int[rows][cols];
            System.out.println("Введите элементы матрицы: ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                	System.out.print("Элемент [" + i + "][" + j + "]: ");
                    matrix[i][j] = in.nextInt();
                }
            }

            System.out.print("Введите номер столбца для вывода: ");
            int column = in.nextInt();

            if (column < 0 || column >= cols) {
                throw new IndexOutOfBoundsException("Столбца с таким номером не существует");
            }

            System.out.println("Столбец " + column + ":");
            for (int i = 0; i < rows; i++) {
                System.out.println(matrix[i][column]);
            }

        } catch (InputMismatchException e) {
			System.out.println("Введено некорректное значение (вводите только целые числа)");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        } finally {
            in.close();
        }
    }
}
