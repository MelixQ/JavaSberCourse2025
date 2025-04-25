package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Lr5_Example4 {
	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<>();
		Random rnd = new Random();
		
		System.out.println("До: ");
		
		for (int i = 0; i < 10; i++) {
			ints.add(rnd.nextInt(1000));
			System.out.println(ints.get(i));	
		}
		
		List<Integer> intsAfter = squareList(ints);
		System.out.println("После:");
		
		for (Integer e : intsAfter) {
			System.out.println(e);	
		}
		
	}
	
	public static List<Integer> squareList(List<Integer> list) {
		return list.stream().map(x -> x*x).collect(Collectors.toList());
	}
}