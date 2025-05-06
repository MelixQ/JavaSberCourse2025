package lr6;


public class Lr6_Task2 {
	public static void main(String[] args) throws InterruptedException {
		var t1 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t1.join();
	}
}
