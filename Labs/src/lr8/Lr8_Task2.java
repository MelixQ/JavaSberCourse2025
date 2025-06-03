package lr8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Lr8_Task2 {
	private static final String FILE_PATH = "Labs/src/lr8/task2/task.json";
	public static void main(String[] args) {
		try {
			// Объединим весь необходимый функционал в одно "приложение"
			while (true) {
				System.out.println("\nВыберите действие с библиотекой:");
				System.out.println("1 - Добавить книгу");
				System.out.println("2 - Поиск книги");
				System.out.println("3 - Удалить книгу");
				System.out.println("4 - Завершить работу");
				Scanner scanner = new Scanner(System.in);
				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
					case 1:
						addBook(scanner);
						break;
					case 2:
						searchBooks(scanner);
						break;
					case 3:
						deleteBook(scanner);
						break;
					case 4:
						System.out.println("Выход");
						return;
					default:
						System.out.println("Некорректный ввод");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static JSONObject parseJson() throws Exception {
		var parser = new JSONParser();
		return (JSONObject) parser.parse(new FileReader(FILE_PATH));
	}

	private static void saveJson(JSONObject jsonObject) throws Exception {
		try (var file = new FileWriter(FILE_PATH)) {
			file.write(jsonObject.toJSONString());
			System.out.println("Файл сохранен");
		}
	}

	private static void addBook(Scanner scanner) throws Exception {
		var jsonObject = parseJson();
		var books = (JSONArray) jsonObject.get("books");

		var newBook = new JSONObject();
		System.out.print("Введите название книги: ");
		newBook.put("title", scanner.nextLine());

		System.out.print("Введите автора книги: ");
		newBook.put("author", scanner.nextLine());

		System.out.print("Введите год издания: ");
		newBook.put("year", Integer.parseInt(scanner.nextLine()));

		books.add(newBook);
		jsonObject.put("books", books);

		saveJson(jsonObject);
		System.out.println("Книга добавлена");
	}

	private static void searchBooks(Scanner scanner) throws Exception {
		JSONObject jsonObject = parseJson();
		var books = (JSONArray) jsonObject.get("books");

		System.out.print("Введите имя автора для поиска: ");
		String author = scanner.nextLine();

        for (Object o : books) {
            var book = (JSONObject) o;
            if (author.equals(book.get("author"))) {
                System.out.println("\n--- Книга ---");
                System.out.println("Название: " + book.get("title"));
                System.out.println("Автор: " + book.get("author"));
                System.out.println("Год: " + book.get("year"));
            }
        }
	}

	private static void deleteBook(Scanner scanner) throws Exception {
		var jsonObject = parseJson();
		var books = (JSONArray) jsonObject.get("books");

		System.out.print("Введите название книги для удаления: ");
		var titleToDelete = scanner.nextLine();

		var iterator = books.iterator();
		boolean found = false;

		while (iterator.hasNext()) {
			JSONObject book = (JSONObject) iterator.next();
			String title = (String) book.get("title");
			if (title.equalsIgnoreCase(titleToDelete)) {
				iterator.remove();
				found = true;
				break;
			}
		}

		if (found) {
			jsonObject.put("books", books);
			saveJson(jsonObject);
			System.out.println("Книга \"" + titleToDelete + "\" удалена.");
		} else {
			System.out.println("Книга не найдена.");
		}
	}
}
