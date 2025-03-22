package lr3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapTask {
	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<>();
		hm.put(0, "Zero");
		hm.put(1, "HelloWorld");
		hm.put(2, "Amat Victoria Curam");
		hm.put(3, "Veni Vidi Vici");
		hm.put(4, "Small");
		hm.put(5, "Text");
		hm.put(6, "camelCase");
		hm.put(7, "ru-RU");
		hm.put(8, "Lorem Ipsum");
		hm.put(9, "HashMapJava");
		
		List<String> keyOverFive = new ArrayList<>();
		List<String> keyIsZero = new ArrayList<>();
		long product = 1;
		
		for (var entry : hm.entrySet()) {
			int key = entry.getKey();
			String value = entry.getValue();
			
			if (key > 5) keyOverFive.add(value);
			if (key == 0) keyIsZero.add(value);
			if (value.length() > 5) product *= key;
		}
		
		System.out.println("С ключом > 5: " + keyOverFive);
		System.out.println("Строки для ключа = 0: " + keyIsZero);
		System.out.println("Произведение ключей: " + product);
	}
}
