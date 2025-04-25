package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

// 11
public class Lr5_Task6 {
	public static void main(String[] args) {
		ArrayList<Integer> ints = new ArrayList<Integer>();
		Random rnd = new Random();
		for (int i = 0; i < rnd.nextInt(10, 50); i++) {
			ints.add(rnd.nextInt(50));
		}
		
		int threshold = rnd.nextInt(10, 50);
		System.out.println("Ищем меньше числа: " + threshold);
		System.out.println("Вот они:");
		List<Integer> res = filterByLength(ints, threshold);
		System.out.println(res.toString());
	}
	
	public static List<Integer> filterByLength(List<Integer> list, int threshold) {
		return list.stream()
				.filter(s -> s < threshold)
				.collect(Collectors.toList());
	}
}
