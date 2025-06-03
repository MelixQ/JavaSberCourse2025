package lr8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Lr8_Example6 {
	public static void main(String[] args) {
		var url = "http://fat.urfu.ru/index.html";
		try {
			var doc = Jsoup.connect(url).get();
			var newsParent = doc.select(
					"body > table > tbody > tr > td > div > table > tbody " +
							"> tr:nth-child(5) > td:nth-child(3) > " +
							"table > tbody > tr > td:nth-child(1)"
			);

			for (int i = 3; i < 20; i++) {
				if (!(i % 2 == 0)) {
					if (newsParent.isEmpty()) {
						System.out.println("Элемент не найден. Скорее всего ошибка в CSS-селекторе");
						return;
					}
					var nodes = newsParent.get(0).childNodes();
					System.out.println("Тема: " +
							((Element) nodes.get(i))
									.getElementsByClass("blocktitle")
									.get(0).childNodes().get(0));

					System.out.println("Дата: " +
							((Element) nodes.get(i))
									.getElementsByClass("blockdate")
									.get(0).childNodes().get(0) +
							"\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
