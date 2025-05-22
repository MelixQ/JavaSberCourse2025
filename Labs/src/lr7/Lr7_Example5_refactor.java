package lr7;

import java.io.*;
import java.util.Scanner;


public class Lr7_Example5_refactor {
	public static void main(String[] args) {
		String inputFileName = "Labs/src/lr7/example5/input.txt";
		String outputFileName = "Labs/src/lr7/example5/output.txt";

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
				var is = new FileInputStream(inputFileName);
				var isr = new InputStreamReader(is, "UTF-8");
				var br = new BufferedReader(isr);

				var os = new FileOutputStream(outputFileName);
				var osw = new OutputStreamWriter(os, "UTF-8");
				var bw = new BufferedWriter(osw);
		) {
			String line;
			while ((line = br.readLine()) != null) {
				bw.write(line.toUpperCase());
				bw.newLine();
			}
			System.out.println("Данные записаны в файл: " + outputFileName);
		} catch (IOException e) {
			System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
		}
	}
}
