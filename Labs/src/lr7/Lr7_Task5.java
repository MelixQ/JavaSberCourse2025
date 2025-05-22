package lr7;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Lr7_Task5 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Введите путь к файлу: ");
		String filePath = scanner.nextLine();

		File file = new File(filePath);
		if (!file.exists()) {
			System.out.println("Файл не найден по указанному пути");
			return;
		}

		if (!file.isFile()) {
			System.out.println("По указанному пути нет файла (несоответствие типа)");
			return;
		}

		long fileSizeInBytes = file.length();
		System.out.println("Размер файла в байтах: " + fileSizeInBytes);
	}
}
