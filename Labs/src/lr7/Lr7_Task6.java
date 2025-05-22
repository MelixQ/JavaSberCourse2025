package lr7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Lr7_Task6 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Введите путь к файлу: ");
		String filePath = scanner.nextLine();

		System.out.print("Слово для поисска: ");
		String target = scanner.nextLine();

		File file = new File(filePath);
		if (!file.exists() || !file.isFile()) {
			System.out.println("Файл не найден или по указанному пути не файл");
			return;
		}
		try (var reader = new BufferedReader(new FileReader(file))) {
			String line;
			var lineNum = 0;
			var isTargetFound = false;

			while ((line = reader.readLine()) != null) {
				lineNum++;
				if (line.contains(target)) {
					System.out.println("Строка #" + lineNum + ": " + line);
					isTargetFound = true;
				}
			}
			if (!isTargetFound) {
				System.out.println("Слово не найдено ни разу");
			}
		} catch (IOException e) {
			System.out.println("Ошибка при чтении файла: " + e.getMessage());
		}
	}
}
