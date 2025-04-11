package lr4;

public class Lr4_Example7 {
	public static void main(String[] args) {
		try {
	        System.out.println("0");
	        throw new NullPointerException("ошибка");
	    } catch (NullPointerException e) {
	    	// Обернули в свой try..catch
	    	try {
	    		System.out.println("1");
	    		throw new ArithmeticException();
	    	} catch (ArithmeticException v) {
		        System.out.println("2");
		    }
	    }
	    System.out.println("3");
	}
}
