package lr6;


public class Lr6_Task6 {
	public static void main(String[] args) throws InterruptedException {
		int[] array = new int[] {
				0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89,
				144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946,

		};
		System.out.println(sumElements(array));
	}

	public static int sumElements(int[] array) throws InterruptedException {
		// Получаем доступные ядра
		int cores = Runtime.getRuntime().availableProcessors();
		Thread[] threads = new Thread[cores];
		// Суммы, сложенные в каждом потоке
		int[] localSums = new int[cores];
		// Разбиваем массив
		int chunkSize = (array.length + cores - 1) / cores;
		for (int i = 0; i < cores; i++) {
			final int threadIndex = i;
			threads[i] = new Thread(() -> {
				int start = threadIndex * chunkSize;
				int end = Math.min(start + chunkSize, array.length);
				int localSum = 0;
				// Суммируем элементы части массива
				for (int j = start; j < end; j++) {
					localSum += array[j];
				}
				localSums[threadIndex] = localSum;
			});

			threads[i].start();
		}

		for (Thread thread : threads) {
			thread.join();
		}
		// Собираем общую сумму
		int sum = 0;
		for (int localSum : localSums) {
			sum += localSum;
		}
		return sum;
	}
}
