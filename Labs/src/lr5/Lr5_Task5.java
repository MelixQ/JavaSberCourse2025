package lr5;

import java.util.List;
import java.util.stream.Collectors;

// 10
public class Lr5_Task5 {
	public static void main(String[] args) {
		String string = "Элементы для будущего списка, содержащего строки. "
				+ "Планеты гиганты. чтобы ещё написать... Ухты!" 
				+ "123 125 &*#$% dlksflks $%";
		List<String> strings = List.of(string.split(" "));
		
		List<String> res = filterOnlyLetters(strings);
		System.out.println(res.toString());
	}
	
	public static List<String> filterOnlyLetters(List<String> list) {
		return list.stream()
				.filter(s -> s.chars()
						.allMatch(Character::isLetter))
				.collect(Collectors.toList());
	}
}
