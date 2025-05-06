package lr6;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;


public class Lr6_Task1 {
	public static void main(String[] args) throws InterruptedException {
		var t1 = createThread();
		var t2 = createThread();

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}

	private static Thread createThread() {
			return new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + ": "
						+ LocalTime.now());

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
