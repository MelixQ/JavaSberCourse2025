package lr8;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Lr8_Example2 {
	public static void main(String[] args) throws InterruptedException {
		try {
			var file = new File("Labs/src/lr8/example1/example.xml");
			var dbFactory = DocumentBuilderFactory.newInstance();
			var dBuilder = dbFactory.newDocumentBuilder();
			var doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();

			System.out.println("Корневой элемент: " + doc.getDocumentElement().getNodeName());

			var nodeList = doc.getElementsByTagName("book");
			for (int i = 0; i < nodeList.getLength(); i++) {
				var node = nodeList.item(i);
				var nodeName = node.getNodeName();
				System.out.println("\nТекущий элемент: " + nodeName);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					var element = (Element) node;
					System.out.println("Название книги: " + element.getElementsByTagName("title").item(0).getTextContent());
					System.out.println("Автор: " + element.getElementsByTagName("author").item(0).getTextContent());
					System.out.println("Год издания: " + element.getElementsByTagName("year").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
