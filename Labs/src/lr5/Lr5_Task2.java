package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Lr5_Task2 {
	public static void main(String[] args) {
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for (int i = 0; i < 25; i++) {
			ints.add(i);
		}
		
		int divisor = 5;
		
		List<Integer> res = filterIntegersWithNoRemainder(ints, divisor);
		System.out.println(res.toString());
	}
	
	public static List<Integer> filterIntegersWithNoRemainder(List<Integer> list, int divisor) {
		return list.stream()
				.filter(s -> s % divisor == 0)
				.collect(Collectors.toList());
	}
}
