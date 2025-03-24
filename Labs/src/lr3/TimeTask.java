package lr3;

import java.util.*;

/* 
 *  Вариант № 19.
 *  ArrayDeque, SortedSet, SortedMap
 * 	Количество элементов в коллекции: 
	< 19 000 000 >
	Количество элементов для вычисления скорости получения по индексу:
 	< 19 000 000 000 >
 * */
public class TimeTask {
	private static final int COLLECTION_SIZE = 19_000_000;
	private static final long INDEX_ACCESS_ELEMENT_COUNT = 19_000_000_000L;

	public static void main(String[] args) {
		ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
		TreeSet<Integer> treeSet = new TreeSet<>();
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();

		System.out.println("=== ДОБАВЛЕНИЕ ЭЛЕМЕНТОВ ===");

		// 1. Добавление в начало
		System.out.println("\nДобавление в начало:");

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < COLLECTION_SIZE; i++) {
			arrayDeque.addFirst(i);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("ArrayDeque: " + (endTime - startTime) + " мс");
		arrayDeque.clear();

		// TreeSet и TreeMap не имеют прямого метода для добавления в начало
		// Можно добавлять в обратном порядке для имитации
		startTime = System.currentTimeMillis();
		for (int i = COLLECTION_SIZE; i > 0; i--) {
			treeSet.add(i);
		}
		endTime = System.currentTimeMillis();
		System.out.println("TreeSet: " + (endTime - startTime) + " мс");
		treeSet.clear();

		startTime = System.currentTimeMillis();
		for (int i = COLLECTION_SIZE; i > 0; i--) {
			treeMap.put(i, i);
		}
		endTime = System.currentTimeMillis();
		System.out.println("TreeMap: " + (endTime - startTime) + " мс");
		treeMap.clear();

		// 2. Добавление в конец
		System.out.println("\nДобавление в конец:");

		startTime = System.currentTimeMillis();
		for (int i = 0; i < COLLECTION_SIZE; i++) {
			arrayDeque.addLast(i);
		}
		endTime = System.currentTimeMillis();
		System.out.println("ArrayDeque: " + (endTime - startTime) + " мс");

		startTime = System.currentTimeMillis();
		for (int i = 0; i < COLLECTION_SIZE; i++) {
			treeSet.add(i);
		}
		endTime = System.currentTimeMillis();
		System.out.println("TreeSet: " + (endTime - startTime) + " мс");

		startTime = System.currentTimeMillis();
		for (int i = 0; i < COLLECTION_SIZE; i++) {
			treeMap.put(i, i);
		}
		endTime = System.currentTimeMillis();
		System.out.println("TreeMap: " + (endTime - startTime) + " мс");

		// 3. Добавление в середину
		// Для этого теста создадим новые коллекции с половиной элементов
		System.out.println("\nДобавление в середину:");

		ArrayDeque<Integer> halfArrayDeque = new ArrayDeque<>();
		for (int i = 0; i < COLLECTION_SIZE / 2; i++) {
			halfArrayDeque.add(i * 2);
		}

		startTime = System.currentTimeMillis();
		// Для ArrayDeque нет прямого метода вставки в середину, используем итератор
		List<Integer> tempList = new ArrayList<>(halfArrayDeque);
		halfArrayDeque.clear();
		for (int i = 0; i < tempList.size(); i++) {
			halfArrayDeque.add(tempList.get(i));
			if (i < tempList.size() - 1) {
				halfArrayDeque.add(tempList.get(i) + 1);
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("ArrayDeque: " + (endTime - startTime) + " мс");
		halfArrayDeque.clear();

		TreeSet<Integer> halfTreeSet = new TreeSet<>();
		for (int i = 0; i < COLLECTION_SIZE / 2; i++) {
			halfTreeSet.add(i * 2);
		}

		startTime = System.currentTimeMillis();
		for (int i = 0; i < COLLECTION_SIZE / 2; i++) {
			halfTreeSet.add(i * 2 + 1);
		}
		endTime = System.currentTimeMillis();
		System.out.println("TreeSet: " + (endTime - startTime) + " мс");
		halfTreeSet.clear();

		TreeMap<Integer, Integer> halfTreeMap = new TreeMap<>();
		for (int i = 0; i < COLLECTION_SIZE / 2; i++) {
			halfTreeMap.put(i * 2, i * 2);
		}

		startTime = System.currentTimeMillis();
		for (int i = 0; i < COLLECTION_SIZE / 2; i++) {
			halfTreeMap.put(i * 2 + 1, i * 2 + 1);
		}
		endTime = System.currentTimeMillis();
		System.out.println("TreeMap: " + (endTime - startTime) + " мс");
		halfTreeMap.clear();

		System.out.println("\n=== УДАЛЕНИЕ ЭЛЕМЕНТОВ ===");

		// Заполняем коллекции для тестов удаления
		for (int i = 0; i < COLLECTION_SIZE; i++) {
			arrayDeque.add(i);
			treeSet.add(i);
			treeMap.put(i, i);
		}

		// 4. Удаление из начала
		System.out.println("\nУдаление из начала:");

		startTime = System.currentTimeMillis();
		for (int i = 0; i < COLLECTION_SIZE; i++) {
			arrayDeque.removeFirst();
			if (arrayDeque.isEmpty())
				break;
		}
		endTime = System.currentTimeMillis();
		System.out.println("ArrayDeque: " + (endTime - startTime) + " мс");

		startTime = System.currentTimeMillis();
		for (int i = 0; i < COLLECTION_SIZE; i++) {
			if (treeSet.isEmpty())
				break;
			treeSet.pollFirst();
		}
		endTime = System.currentTimeMillis();
		System.out.println("TreeSet: " + (endTime - startTime) + " мс");

		startTime = System.currentTimeMillis();
		for (int i = 0; i < COLLECTION_SIZE; i++) {
			if (treeMap.isEmpty())
				break;
			treeMap.pollFirstEntry();
		}
		endTime = System.currentTimeMillis();
		System.out.println("TreeMap: " + (endTime - startTime) + " мс");

		for (int i = 0; i < COLLECTION_SIZE; i++) {
			arrayDeque.add(i);
			treeSet.add(i);
			treeMap.put(i, i);
		}

		// 5. Удаление из конца
		System.out.println("\nУдаление из конца:");

		startTime = System.currentTimeMillis();
		for (int i = 0; i < COLLECTION_SIZE; i++) {
			arrayDeque.removeLast();
			if (arrayDeque.isEmpty())
				break;
		}
		endTime = System.currentTimeMillis();
		System.out.println("ArrayDeque: " + (endTime - startTime) + " мс");

		startTime = System.currentTimeMillis();
		for (int i = 0; i < COLLECTION_SIZE; i++) {
			if (treeSet.isEmpty())
				break;
			treeSet.pollLast();
		}
		endTime = System.currentTimeMillis();
		System.out.println("TreeSet: " + (endTime - startTime) + " мс");

		startTime = System.currentTimeMillis();
		for (int i = 0; i < COLLECTION_SIZE; i++) {
			if (treeMap.isEmpty())
				break;
			treeMap.pollLastEntry();
		}
		endTime = System.currentTimeMillis();
		System.out.println("TreeMap: " + (endTime - startTime) + " мс");

		for (int i = 0; i < COLLECTION_SIZE; i++) {
			arrayDeque.add(i);
			treeSet.add(i);
			treeMap.put(i, i);
		}

		// 6. Удаление из середины
		System.out.println("\nУдаление из середины:");

		startTime = System.currentTimeMillis();
		// Для ArrayDeque используем итератор для удаления среднего элемента
		Iterator<Integer> iterator = arrayDeque.iterator();
		int count = 0;
		while (iterator.hasNext() && count < COLLECTION_SIZE / 2) {
			iterator.next();
			count++;
		}
		if (iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
		endTime = System.currentTimeMillis();
		System.out.println("ArrayDeque (удаление одного элемента): " + (endTime - startTime) + " мс");

		startTime = System.currentTimeMillis();
		treeSet.remove(COLLECTION_SIZE / 2);
		endTime = System.currentTimeMillis();
		System.out.println("TreeSet (удаление одного элемента): " + (endTime - startTime) + " мс");

		startTime = System.currentTimeMillis();
		treeMap.remove(COLLECTION_SIZE / 2);
		endTime = System.currentTimeMillis();
		System.out.println("TreeMap (удаление одного элемента): " + (endTime - startTime) + " мс");

		// 7. Получение элемента по индексу
		System.out.println("\n=== ПОЛУЧЕНИЕ ПО ИНДЕКСУ ===");

		// ArrayDeque не поддерживает прямой доступ по индексу, используем итератор
		startTime = System.currentTimeMillis();
		for (int i = 0; i < INDEX_ACCESS_ELEMENT_COUNT; i++) {
			int randomIndex = new Random().nextInt(arrayDeque.size());
			Iterator<Integer> it = arrayDeque.iterator();
			for (int j = 0; j < randomIndex && it.hasNext(); j++) {
				it.next();
			}
			if (it.hasNext())
				it.next();
		}
		endTime = System.currentTimeMillis();
		System.out.println("ArrayDeque: " + (endTime - startTime) + " мс");

		// TreeSet не поддерживает прямой доступ по индексу, используем итератор
		startTime = System.currentTimeMillis();
		for (int i = 0; i < INDEX_ACCESS_ELEMENT_COUNT; i++) {
			int randomIndex = new Random().nextInt(treeSet.size());
			Iterator<Integer> it = treeSet.iterator();
			for (int j = 0; j < randomIndex && it.hasNext(); j++) {
				it.next();
			}
			if (it.hasNext())
				it.next();
		}
		endTime = System.currentTimeMillis();
		System.out.println("TreeSet: " + (endTime - startTime) + " мс");

		// TreeMap не поддерживает прямой доступ по индексу, используем итератор
		startTime = System.currentTimeMillis();
		for (int i = 0; i < INDEX_ACCESS_ELEMENT_COUNT; i++) {
			int randomIndex = new Random().nextInt(treeMap.size());
			Iterator<Map.Entry<Integer, Integer>> it = treeMap.entrySet().iterator();
			for (int j = 0; j < randomIndex && it.hasNext(); j++) {
				it.next();
			}
			if (it.hasNext())
				it.next();
		}
		endTime = System.currentTimeMillis();
		System.out.println("TreeMap: " + (endTime - startTime) + " мс");
	}
}
