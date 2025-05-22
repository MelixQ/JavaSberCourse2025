package lr7;

import java.io.*;


public class Lr7_Task3 {
	public static void main(String[] args) throws IOException {
		String fileName = "Labs/src/lr7/tasks_data/data.txt";

		var reader = new BufferedReader(new FileReader(fileName));
		int lineCount = 0;
		while (reader.readLine() != null) {
			lineCount++;
		}
		reader.close();
		System.out.println("Количество строк: " + lineCount);
	}
}
