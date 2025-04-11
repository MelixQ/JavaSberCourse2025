package lr4;

public class Lr4_Example5 {
	public static void main(String[] args) {
		try {
	        System.out.println("0");
	        throw new RuntimeException("ошибка");
	    } catch (NullPointerException e) {
	        System.out.println("1");
	    } catch (Exception e) {
	    	System.out.println("ФИКС ОШИБКИ");
	    }
	    System.out.println("2");
	}
}
