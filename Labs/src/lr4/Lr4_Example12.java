package lr4;

public class Lr4_Example12 {
	public static void m(String str, double chislo) {
        if (str == null) {
            throw new IllegalArgumentException("Строка введена неверно");
        }
        if (chislo > 0.001) {
            throw new IllegalArgumentException("Неверное число");
        }
    }

    public static void main(String[] args) {
        // Дает ошибку
    	// m(null, 0.000001);
    	m("Хорошая строка", 0.00005);
    }
}
