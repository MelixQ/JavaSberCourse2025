package lr7;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Lr7_Example3_refactor {
	public static void main(String[] args) {
		String fileName = "Labs/src/lr7/example3/example_file3.txt";
		// Ввод данных с консоли
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите данные для записи в файл: ");
		String data = scanner.nextLine();

		try (FileWriter fw = new FileWriter(fileName)) {
			fw.write(data);
			System.out.println("Данные записаны в файл: " + fileName);
		} catch (IOException e) {
			System.out.println("Ошибка записи в файл: " + e.getMessage());
		}

		try (FileReader fr = new FileReader(fileName)) {
			var buffer = new char[1024];
			int charRead = fr.read(buffer);
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
