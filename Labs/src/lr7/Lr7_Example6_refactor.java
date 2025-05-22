package lr7;

import java.io.*;
import java.util.Scanner;


public class Lr7_Example6_refactor {
	public static void main(String[] args) {
		String inputFileName = "Labs/src/lr7/example6/input.txt";
		String outputFileName = "Labs/src/lr7/example6/output.txt";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите текст для записи:");

		try (var inputWriter = new BufferedWriter(new FileWriter(inputFileName))) {
			String line;
			while (!(line = scanner.nextLine()).equals("end")) {
				inputWriter.write(line);
				inputWriter.newLine();
			}
			System.out.println("Данные записаны в input.txt");
		} catch (IOException e) {
			System.out.println("Ошибка при записи во временный файл: " + e.getMessage());
			return;
		}

		try (
				var br = new BufferedReader(new FileReader(inputFileName));
				var pw = new PrintWriter(outputFileName, "UTF-8");
		) {
			String line;
			while ((line = br.readLine()) != null) {
				pw.println(line.toUpperCase());
			}
			System.out.println("Данные записаны в файл: " + outputFileName);
		} catch (IOException e) {
			System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
		}
	}
}
