package lr7;

import java.io.*;
import java.util.Scanner;


public class Lr7_Task7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите название файла: ");
		String fileName = scanner.nextLine();
		String filePath = "Labs/src/lr7/tasks_data/" + fileName;

		System.out.print("Введите текст для записи в файл: ");
		String data = scanner.nextLine();

		try (var writer = new FileWriter(filePath)) {
			writer.write(data);
			System.out.println("Количество записанных символов: " + data.length());
		} catch (IOException e) {
			System.out.println("Ошибка записи в файл: " + e.getMessage());
		}
	}
}
