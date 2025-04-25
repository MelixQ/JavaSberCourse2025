package lr5;

import java.util.List;
import java.util.stream.Collectors;


public class Lr5_Task1 {
	public static void main(String[] args) {
		String string = "Элементы для будущего списка, содержащего строки. "
				+ "Планеты гиганты. чтобы ещё написать... Ухты!";
		List<String> strings = List.of(string.split(" "));
		String sub = "ты";
		
		List<String> res = filterSubstrings(strings, sub);
		System.out.println(res.toString());
	}
	
	public static List<String> filterSubstrings(List<String> list, String substring) {
		return list.stream()
				.filter(s -> s.contains(substring))
				.collect(Collectors.toList());
	}
}
