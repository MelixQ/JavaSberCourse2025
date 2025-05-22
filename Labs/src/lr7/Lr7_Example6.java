package lr7;

import java.io.*;


public class Lr7_Example6 {
	public static void main(String[] args) {
		String inputFileName = "Labs/src/lr7/example6/input.txt";
		String outputFileName = "Labs/src/lr7/example6/output.txt";

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
