package lr3;

public class LinkedListMethodsTask {
	public static void main(String[] args) {
		LinkedListWithMethods list = new LinkedListWithMethods();
		
		int[] set1 = {0, 1, 1, 2, 3, 5, 8};
		list.createHead(set1);
		System.out.println("createHead:");
		System.out.println(list);
		list.createTail(set1);
		System.out.println("createTail:");
		System.out.println(list);
		
		System.out.println("==================================");
		
		System.out.println("До: " + list);
		System.out.println("Добавим в начало '42', в конец '69', по index = 3 вставим '11'");
		list.addFirst(42);
		list.addLast(69);
		list.insert(3, 11);
		System.out.println(list);
		list.remove(1);
		list.remove(1);
		list.removeFirst();
		list.removeLast();
		System.out.println("Удалим '42', '69' и два '0' из начала по индексам");
		System.out.println(list);
		
		System.out.println("==================================");
		
		System.out.println("Рекурсивные createHeadRec() + toStringRec():");
		list.createHead(set1);
		System.out.println(list.toStringRec());
		System.out.println("Рекурсивные createTailRec() + toStringRec():");
		int[] set2 = {20, 15, 10, 5};
		list.createTailRec(set2);
		System.out.println(list.toStringRec());
	}
}

class LinkedListWithMethods {
	private class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
			next = null;
		}
	}

	public LinkedListWithMethods() {
		head = null;
	}

	private Node head;

	public void createHead(int[] values) {
		head = null;
		for (int i = 0; i < values.length; i++) {
			Node newNode = new Node(values[i]);
			newNode.next = head;
			head = newNode;
		}
	}

	public void createTail(int[] values) {
		if (values.length == 0)
			return;

		head = new Node(values[0]);
		Node cursor = head;

		for (int i = 0; i < values.length; i++) {
			cursor.next = new Node(values[i]);
			cursor = cursor.next;
		}
	}

	@Override
	public String toString() {
		if (head == null)
			return "[]";

		StringBuilder sb = new StringBuilder("[");
		Node cursor = head;

		while (cursor != null) {
			sb.append(cursor.value);
			if (cursor.next != null) {
				sb.append(", ");
			}
			cursor = cursor.next;
		}

		sb.append("]");
		return sb.toString();
	}

	public void addFirst(int value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
	}

	public void addLast(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			return;
		}

		Node cursor = head;
		while (cursor.next != null) {
			cursor = cursor.next;
		}

		cursor.next = newNode;
	}

	public void insert(int index, int value) {
		if (index == 0) {
			addFirst(value);
			return;
		}

		Node cursor = head;
		int currentIndex = 0;

		while (cursor != null && currentIndex < index - 1) {
			currentIndex++;
			cursor = cursor.next;
		}

		if (cursor == null) {
			throw new IndexOutOfBoundsException(index + " - индекс за пределами списка");
		}

		Node newNode = new Node(value);
		newNode.next = cursor.next;
		cursor.next = newNode;
	}

	public void removeFirst() {
		if (head == null) {
			throw new IllegalStateException("Список пуст. Удаление невозможно");
		}

		head = head.next;
	}

	public void removeLast() {
		if (head == null) {
			throw new IllegalStateException("Список пуст. Удаление невозможно");
		}

		if (head.next == null) {
			head = null;
			return;
		}

		Node cursor = head;
		while (cursor.next.next != null) {
			cursor = cursor.next;
		}
		cursor.next = null;
	}
	
	public void remove(int index) {
		if (head == null) {
			throw new IllegalStateException("Список пуст. Удаление невозможно");
		}
		
		if (index == 0) {
			removeFirst();
			return;
		}
		
		Node cursor = head;
		int currentIndex = 0;
		
		while (cursor != null && currentIndex < index - 1) {
			currentIndex++;
			cursor = cursor.next;
		}
		
		if (cursor == null || cursor.next == null) {
			throw new IndexOutOfBoundsException(index + " - индекс за пределами списка");
        }
		
		cursor.next = cursor.next.next;
	}
	
	public void createHeadRec(int[] values) {
        head = null;
        if (values.length > 0) {
            createHeadRecHelper(values, 0);
        }
    }
    
    private void createHeadRecHelper(int[] values, int index) {
        if (index >= values.length) return;
           
        Node newNode = new Node(values[index]);
        newNode.next = head;
        head = newNode;
        
        createHeadRecHelper(values, index + 1);
    }
    
    public void createTailRec(int[] values) {
        head = null;
        if (values.length > 0) {
            head = createTailRecHelper(values, 0);
        }
    }
    
    private Node createTailRecHelper(int[] values, int index) {
        if (index >= values.length) return null;
        
        Node newNode = new Node(values[index]);
        newNode.next = createTailRecHelper(values, index + 1);
        
        return newNode;
    }
    
    public String toStringRec() {
        if (head == null) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        toStringRecHelper(head, sb);
        sb.append("]");
        return sb.toString();
    }
    
    private void toStringRecHelper(Node current, StringBuilder sb) {
        if (current == null) return;
        
        sb.append(current.value);
        
        if (current.next != null) {
            sb.append(", ");
            toStringRecHelper(current.next, sb);
        }
    }
}
