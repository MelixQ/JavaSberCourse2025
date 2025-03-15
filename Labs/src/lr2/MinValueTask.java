package lr2;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class MinValueTask {
	public static void main(String[] args) {
		Random rand = new Random();
		
		int minSize = 5;
		int maxSize = 10;
		// Рандомный размер массива, в диапазоне [minSize, maxSize]
		int randomSize = rand.nextInt((maxSize - minSize) + 1) + minSize;
		int[] nums = new int[randomSize];
		
		// Заполнение рандомными значениями
		for (int i = 0; i < nums.length; i++)
		{
			nums[i] = rand.nextInt(maxSize);
		}
		
		if (nums.length == 0)
		{
			// В нашем случае такой ситуации не будет, но вообще это важный пограничный случай
			System.out.println("Массив пуст, минимального нет");
		}
		
		System.out.println("Значения массива: ");
		for (int num : nums)
		{
			System.out.println(num);
		}
		
		int minValue = nums[0];
		List<Integer> indices = new ArrayList<>();
		
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] < minValue)
			{
				minValue = nums[i];
				indices.clear();
				indices.add(i);
			} else if (nums[i] == minValue) {
				indices.add(i);
			}
		}
		
		System.out.println("Минимальное значение: " + minValue);
		System.out.println("Индексы минимального значения: ");
		for (int index : indices)
		{
			System.out.println(index);
		}
	}
}
