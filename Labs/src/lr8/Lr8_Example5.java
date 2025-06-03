package lr8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Lr8_Example5 {
	public static void main(String[] args) {
		var url = "https://itlearn.ru/first-steps";
		try {
			var doc = Jsoup.connect(url).get();
			var links = doc.select("a[href]");
			for (var link : links) {
				System.out.println(link.attr("abs:href"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
