package lr5;

import java.util.List;
import java.util.stream.Collectors;


public class Lr5_Task3 {
	public static void main(String[] args) {
		String string = "Элементы для будущего списка, содержащего строки. "
				+ "Планеты гиганты. чтобы ещё написать... Ухты!";
		List<String> strings = List.of(string.split(" "));
		int threshold = 8;
		
		List<String> res = filterByLength(strings, threshold);
		System.out.println(res.toString());
	}
	
	public static List<String> filterByLength(List<String> list, int threshold) {
		 return list.stream()
                 .filter(s -> s.length() > threshold)
                 .collect(Collectors.toList());
	}
}
