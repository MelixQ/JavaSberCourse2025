package lr3;

public class DebuggerExample {
	public static void main(String[] args) {
		NodeDebugger head = null;
		for (int i = 5; i >= 0; i--) {
			head = new NodeDebugger(i, head);
		}
		
		NodeDebugger ref = head;
		while (ref != null) {
			System.out.println(" " + ref.value);
			ref = ref.next;
		}
	}
}

class NodeDebugger {
	public int value;
	public NodeDebugger next;
	
	NodeDebugger(int value, NodeDebugger next) {
		this.value = value;
		this.next = next;
	}
}