package lr7;

import java.io.*;


public class Lr7_Task4 {
	public static void main(String[] args) throws IOException {
		String fileName = "Labs/src/lr7/tasks_data/data.txt";
		String outputFileName = "Labs/src/lr7/tasks_data/output_task_4.txt";

		var reader = new FileReader(fileName);
		var writer = new FileWriter(outputFileName);
		int c;
		while ((c = reader.read()) != -1) {
			writer.write(c);
		}
		reader.close();
		writer.close();
		System.out.println("Скопировано успешно!");
	}
}
