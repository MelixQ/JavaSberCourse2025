package lr8;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.*;

public class Lr8_Task1 {
	private static final String FILE_PATH = "Labs/src/lr8/task1/task.xml";

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

	private static class BookUtil {
		static void printBook(Element book) {
			// Удобный способ вывода книг при поиске
			String title = book.getElementsByTagName("title").item(0).getTextContent();
			String author = book.getElementsByTagName("author").item(0).getTextContent();
			String year = book.getElementsByTagName("year").item(0).getTextContent();
			System.out.println("Название: " + title + "\nАвтор: " + author + "\nГод: " + year);
		}
	}

	private static Document parseXML() throws Exception {
		File file = new File(FILE_PATH);
		var factory = DocumentBuilderFactory.newInstance();
		var builder = factory.newDocumentBuilder();
		return builder.parse(file);
	}

	private static void saveXML(Document doc) throws TransformerException {
		doc.setXmlStandalone(true);
		doc.normalizeDocument();

		var tf = TransformerFactory.newInstance();
		var transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

		var source = new DOMSource(doc);
		var result = new StreamResult(new File(FILE_PATH));
		transformer.transform(source, result);
	}

	private static void addBook(Scanner scanner) throws Exception {
		var doc = parseXML();
		var root = doc.getDocumentElement();
		var book = doc.createElement("book");

		System.out.println("Введите название для новой книги: ");
		var title = scanner.nextLine();
		var titleElement = doc.createElement("title");
		titleElement.appendChild(doc.createTextNode(title));
		book.appendChild(titleElement);

		System.out.println("Введите автора данной книги: ");
		var author = scanner.nextLine();
		var authorElement = doc.createElement("author");
		authorElement.appendChild(doc.createTextNode(author));
		book.appendChild(authorElement);

		System.out.println("Ввелите год издания книги: ");
		var year = scanner.nextLine();
		var yearElement = doc.createElement("year");
		yearElement.appendChild(doc.createTextNode(year));
		book.appendChild(yearElement);

		root.appendChild(book);
		saveXML(doc);
		System.out.println("Новая книга успешно добавлена");
	}

	private static void searchBooks(Scanner scanner) throws Exception {
		var doc = parseXML();
		var books = doc.getElementsByTagName("book");

		List<Element> bookList = new ArrayList<>();
		for (int i = 0; i < books.getLength(); i++) {
			if (books.item(i).getNodeType() == Node.ELEMENT_NODE) {
				bookList.add((Element) books.item(i));
			}
		}

		System.out.println("Выберите колюч для поиска:\n1 - Автор | 2 - Год издания");
		var choice = scanner.nextInt();
		scanner.nextLine();

		if (choice == 1) {
			System.out.print("Введите имя автора: ");
			String author = scanner.nextLine();
			bookList.stream()
					.filter(e -> e.getElementsByTagName("author").item(0).getTextContent().equalsIgnoreCase(author))
					.forEach(BookUtil::printBook);
		} else if (choice == 2) {
			System.out.print("Введите год издания: ");
			String year = scanner.nextLine();
			bookList.stream()
					.filter(e -> e.getElementsByTagName("year").item(0).getTextContent().equals(year))
					.forEach(BookUtil::printBook);
		}
	}

	private static void deleteBook(Scanner scanner) throws Exception {
		var doc = parseXML();

		System.out.print("Введите название книги для удаления: ");
		var titleToDelete = scanner.nextLine();
		var books = doc.getElementsByTagName("book");

		for (int i = 0; i < books.getLength(); i++) {
			Element book = (Element) books.item(i);
			var title = book.getElementsByTagName("title").item(0).getTextContent();
			if (title.equalsIgnoreCase(titleToDelete)) {
				var parent = book.getParentNode();
				parent.removeChild(book);
				saveXML(doc);
				System.out.println("Книга \"" + titleToDelete + "\" удалена");
				return;
			}
		}
		System.out.println("Книга не найдена");
	}
}
