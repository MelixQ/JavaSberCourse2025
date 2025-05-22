package lr7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class Lr7_Example2_refactor {
	public static void main(String[] args) {
		String fileName = "Labs/src/lr7/example2/example_file2.txt";

		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите данные для записи в файл: ");
		String data = scanner.nextLine();

		try (FileOutputStream fos = new FileOutputStream(fileName)) {
			fos.write(data.getBytes());
			System.out.println("Данные записаны в файл: " + fileName);
		} catch (IOException e) {
			System.out.println("Ошибка записи в файл: " + e.getMessage());
		}

		try (FileInputStream fis = new FileInputStream(fileName)) {
			var buffer = new byte[1024];
			int bytesRead = fis.read(buffer);
			String readData = new String(buffer, 0, bytesRead);
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
