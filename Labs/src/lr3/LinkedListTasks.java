package lr3;

public class LinkedListTasks {
	public static void main(String[] args) {
		LinkedListFromHead list = new LinkedListFromHead();
		list.addToHead(10);
		list.addToHead(5);
		list.addToHead(1);
		list.print(); // Отработает по принципу LIFO -> 1 - 5 - 10
		
		LinkedListFromTail list2 = new LinkedListFromTail();
		list2.addToTail(10);
		list2.addToTail(5);
		list2.addToTail(1);
		list2.print(); // Отработает по принципу FIFO -> 10 - 5 - 1
	}
}

class LinkedListFromHead {
	private static class Node {
		int value;
		Node next;
		
		Node(int value) {
			this.value = value;
			next = null;
		}
	}
	
	private Node head;
	
	public LinkedListFromHead() {
		this.head = null;
	}
	
	public void addToHead(int value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
	}
	
	public void print() {
		Node cursor = head;
		
		while (cursor != null) {
			System.out.println(cursor.value);
			cursor = cursor.next;
		}
		System.out.println();
	}
}

class LinkedListFromTail {
	private static class Node {
		int value;
		Node next;
		
		Node(int value) {
			this.value = value;
			next = null;
		}
	}
	
	private Node head;
	private Node tail;
	
	public LinkedListFromTail() {
		head = null;
		tail = null;
	}
	
	public void addToTail(int value) {
		Node newNode = new Node(value);
		
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public void print() {
		Node cursor = head;
		
		while (cursor != null) {
			System.out.println(cursor.value);
			cursor = cursor.next;
		}
		System.out.println();
	}
}