package lr4;

public class Lr4_Example8 {
	public static int m() {
        try {
            System.out.println("0");
            throw new RuntimeException();
        } catch (RuntimeException e) {
        	System.out.println("Добавили обработку");
        }
        finally {
            System.out.println("1");
        }
        return 2;
    }

	public static void main(String[] args) {
        System.out.println(m());
	}
}
