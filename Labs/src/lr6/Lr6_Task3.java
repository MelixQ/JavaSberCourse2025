package lr6;


public class Lr6_Task3 {
	private static final Object lock = new Object();
	private static int number = 1;

	public static void main(String[] args) throws InterruptedException {
		var evenThread = new Thread(() -> {
			synchronized (lock) {
				while (number < 10) {
					if (number % 2 == 0) {
						System.out.println(Thread.currentThread().getName() + ": " + number);
						number++;
					} else {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					lock.notifyAll();
				}
			}
		});

		var oddThread = new Thread(() -> {
			synchronized (lock) {
				while (number < 10) {
					if (number % 2 != 0) {
						System.out.println(Thread.currentThread().getName() + ": " + number);
						number++;
					} else {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					lock.notifyAll();
				}
			}
		});

		evenThread.setName("evenThread");
		oddThread.setName("oddThread");

		evenThread.start();
		oddThread.start();
	}
}
