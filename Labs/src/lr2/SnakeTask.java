package lr2;

import java.util.Scanner;

public class SnakeTask {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк: ");
        int rows = scanner.nextInt();

        System.out.print("Введите количество столбцов: ");
        int cols = scanner.nextInt();

        int[][] snakeGrid = new int[rows][cols];

        fillSnake(snakeGrid, rows, cols);
        printGrid(snakeGrid, rows, cols);

        scanner.close();
	}
	
	public static void fillSnake(int[][] array, int rows, int cols) {
        int initialCounter = 1;

        for (int i = 0; i < rows; i++) {
            // Если строка четная - заполняем элементами слева направо
            if (i % 2 == 0) {
                for (int j = 0; j < cols; j++) {
                    array[i][j] = initialCounter++;
                }
            } 
            // Если строка нечетная - заполняем элементами справа налево
            else {
                for (int j = cols - 1; j >= 0; j--) {
                    array[i][j] = initialCounter++;
                }
            }
        }
    }
	
	// Красивый вывод
    public static void printGrid(int[][] array, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
