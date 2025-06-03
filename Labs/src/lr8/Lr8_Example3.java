package lr8;

import java.io.FileWriter;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class Lr8_Example3 {
	public static void main(String[] args) {
		var library = new JSONObject();
		var books = new JSONArray();

		var book1 = new JSONObject();
		book1.put("title", "Война и мир");
		book1.put("author", "Лев Толстой");
		book1.put("year", 1869);

		var book2 = new JSONObject();
		book2.put("title", "Мастер и Маргарита");
		book2.put("author", "Михаил Булгаков");
		book2.put("year", 1967);

		books.add(book1);
		books.add(book2);

		library.put("books", books);

		try (var file = new FileWriter("Labs/src/lr8/example2/example.json")) {
			file.write(library.toJSONString());
			System.out.println("Успешно создан");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
