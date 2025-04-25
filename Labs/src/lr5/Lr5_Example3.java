package lr5;

import java.util.List;
import java.util.stream.Collectors;


public class Lr5_Example3 {
	public static void main(String[] args) {
		String string = "Функция, которая Принимает Список и Возвращает" +
					"Новый список. Содержащй только строки С Большой Буквы.";
		
		List<String> strings = List.of(string.split(" "));
		
		System.out.println("После сплита: \n");
		for (String e: strings) {
			System.out.println(e);
		}
		
		List<String> listResult = filterCapitalizedStrings(strings);
		
		System.out.println("После преобразования: \n");
		for (String e: listResult) {
			System.out.println(e);
		}
	}
	
	public static List<String> filterCapitalizedStrings(List<String> list) {
		return list.stream()
				.filter(s -> Character.isUpperCase(s.charAt(0)))
				.collect(Collectors.toList());
	}
}
