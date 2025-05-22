package lr7;

import java.io.*;
import java.util.Scanner;


public class Lr7_Example4_refactor {
	public static void main(String[] args) {
		String fileName = "example_file4.txt";
		// Ввод с консоли
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите данные для записи в файл: ");
		String data = scanner.nextLine();

		try (var writer = new BufferedWriter(new FileWriter(fileName))) {
			writer.write(data);
			System.out.println("Данные записаны в файл: " + fileName);
		} catch (IOException e) {
			System.out.println("Ошибка записи в файл: " + e.getMessage());
		}

		try (var reader = new BufferedReader(new FileReader(fileName))) {
			var buffer = new char[1024];
			int charRead = reader.read(buffer);
			String readData = new String(buffer, 0, charRead);
			System.out.println("Прочитанные данные: " + readData);
 		} catch (IOException e) {
			System.out.println("Ошибка при чтении файла: " + e.getMessage());
		}

		if (new File(fileName).delete()) {
			System.out.println("Файл удален");
		} else {
			System.out.println("Ошибка при удалении файла");
		}
	}
}
