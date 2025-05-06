package lr6;


public class Lr6_Task5 {
	public static void main(String[] args) throws InterruptedException {
		int[] array = new int[] {
				436, 2, 3, 4, 1551, 6, 7, 8, 124,
				10, 11, 12, 35123, 14, 125, 16, 17, 18, 19, 20
		};
		System.out.println(findMax(array));
	}

	public static int findMax(int[] array) throws InterruptedException {
		// Получаем доступные ядра
		int cores = Runtime.getRuntime().availableProcessors();
		Thread[] threads = new Thread[cores];
		// Максимумы, найденные каждым потоком
		int[] localMaxs = new int[cores];
		// Разбиваем массив
		int chunkSize = (array.length + cores - 1) / cores;
		for (int i = 0; i < cores; i++) {
			final int threadIndex = i;
			threads[i] = new Thread(() -> {
				int start = threadIndex * chunkSize;
				int end = Math.min(start + chunkSize, array.length);
				int localMax = Integer.MIN_VALUE;
				// Собираем и записываем максимум локально внутри потока
				for (int j = start; j < end; j++) {
					if (array[j] > localMax) {
						localMax = array[j];
					}
				}
				localMaxs[threadIndex] = localMax;
			});

			threads[i].start();
		}

		for (Thread thread : threads) {
			thread.join();
		}
		// Достаем из локальных максимумов наибольшее значение
		int foundMax = Integer.MIN_VALUE;
		for (int localMax : localMaxs) {
			if (localMax > foundMax) {
				foundMax = localMax;
			}
		}
		return foundMax;
	}
}
