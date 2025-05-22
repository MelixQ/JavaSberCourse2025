package lr7;

import java.io.*;


public class Lr7_Example5 {
	public static void main(String[] args) {
		String inputFileName = "Labs/src/lr7/example5/input.txt";
		String outputFileName = "Labs/src/lr7/example5/output.txt";

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
