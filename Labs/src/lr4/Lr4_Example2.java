package lr4;

public class Lr4_Example2 {
	public static void main(String[] args) {
		try {
	        System.out.println("0");
	        throw new RuntimeException("Непроверяемая ошибка");
	        // Недостижимый код, комментируем
	        // System.out.println("1");
	    } catch (Exception e) {
	        System.out.println("2 " + e);
	    }
	    System.out.println("3");
	}
}
