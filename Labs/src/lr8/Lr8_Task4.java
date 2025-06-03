package lr8;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Lr8_Task4 {
	public static void main(String[] args) throws IOException {
		var scanner = new Scanner(System.in);
		var filePath = "Labs/src/lr8/task4/task.xlsx";

		boolean repeat = true;
		while (repeat) {
			try {
				var file = new File(filePath);
				if (!file.exists()) {
					throw new IOException("Файл не найден: " + filePath);
				}

				try (FileInputStream is = new FileInputStream(file)) {
					var workbook = new XSSFWorkbook(is);

					System.out.println("Введите лист для поиска: ");
					var sheetName = scanner.nextLine();
					if (workbook.getSheet(sheetName) == null) {
						throw new IOException("Лист \"" + sheetName + "\" не найден в файле.");
					}

					var sheet = workbook.getSheet(sheetName);

					System.out.println("Содержимое листа \"" + sheetName + "\":");
					for (var row : sheet) {
						for (var cell : row) {
							System.out.print(cell.toString() + "\t");
						}
						System.out.println();
					}
					workbook.close();
				}
				repeat = false;

			} catch (IOException e) {
				System.err.println("Ошибка при работе с файлом: " + e.getMessage());
				System.out.print("Хотите повторить попытку? (y/n): ");
				var cmd = scanner.nextLine();

				if (cmd.equalsIgnoreCase("n")) {
					repeat = false;
				} else {
					System.out.print("Введите новый путь к xlsx фалу, либо нажмите enter для повтора с тем же файлом: ");
					String sameOrAnotherFilePath = scanner.nextLine();
					if (!sameOrAnotherFilePath.trim().isEmpty()) {
						filePath = sameOrAnotherFilePath;
					}
				}
			}
		}
		System.out.println("Программа завершена.");
		scanner.close();
	}
}
