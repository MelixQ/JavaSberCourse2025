package lr4;

public class Lr4_Example6 {
	public static void main(String[] args) {
		try {
	        System.out.println("0");
	        throw new NullPointerException("ошибка");
	    } catch (ArithmeticException e) {
	        System.out.println("1");
	    } catch (RuntimeException e) {
	        System.out.println("2 - ТЕПЕРЬ 2");
	    } catch (Exception e) {
	        System.out.println("3 - ТЕПЕРЬ 3");
	    }
	    System.out.println("4");
	}
}
