package lr8;


import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Lr8_Task3 {
	private static final int MAX_RETRIES = 5;
	private static final String URL_SOURCE = "https://itlearn.ru/first-steps";

	public static void main(String[] args) {
		var isSuccess = false;
		for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
			try {
				System.out.println("Попытка №" + attempt);

				var doc = Jsoup.connect(URL_SOURCE).get();
				var links = doc.select("a[href]");

				saveResults(links, "Labs/src/lr8/task3/result.txt");
				isSuccess = true;
				break;
			} catch (IOException e) {
				System.err.println("Ошибка подключения к URL: " + URL_SOURCE + "\nОшибка: " + e.getMessage());

				if (attempt < MAX_RETRIES) {
					System.out.println("Ошибка подключения, повторная попытка...");
				} else {
					System.err.println("Не удалось подключиться по URL: " + URL_SOURCE + "\nВсего попыток: " + MAX_RETRIES);
				}
            }
        }

		if (isSuccess) {
			System.out.println("Программа завершена успешно");
		} else {
			System.out.println("Программа завершена с ошибками");
		}
	}

	private static void saveResults(Elements links, String filename) throws IOException {
		try (var writer = new BufferedWriter(new FileWriter(filename))) {
			for (var link : links) {
				var url = link.attr("abs:href");
				writer.write(url);
				writer.newLine();
			}
		}
	}
}
