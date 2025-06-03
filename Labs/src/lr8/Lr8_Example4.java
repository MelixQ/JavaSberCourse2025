package lr8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;

public class Lr8_Example4 {
	public static void main(String[] args) {
		try {
			var parser = new JSONParser();
			var obj = parser.parse(new FileReader("Labs/src/lr8/example2/example.json"));
			var jsonObject = (JSONObject)obj;

			System.out.println("Корневой элемент: " +
					jsonObject.keySet().iterator().next());
			var jsonArray = (JSONArray)jsonObject.get("books");

			for (var o: jsonArray) {
				var book = (JSONObject)o;
				System.out.printf("\n\nТекущий элемент: book\nНазвание книги: %s\nАвтор: %s\nГод издания: %s",
					book.get("title"), book.get("author"), book.get("year")
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
