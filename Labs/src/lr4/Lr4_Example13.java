package lr4;

public class Lr4_Example13 {
	public static void main(String[] args) {
        try {
            int l = args.length;
            System.out.println("размер массива= " + l);
            if (l == 0) {
                System.out.println("Массив пустой, деление на ноль невозможно.");
            } else {
                int h = 10 / l;
                System.out.println("Результат деления: " + h);
            }     
            if (l + 1 < args.length) {
                args[l + 1] = "10"; // Безопасное обращение к массиву
                System.out.println("Значение успешно установлено.");
            } else {
                System.out.println("Индекс " + (l + 1) + " выходит за пределы массива.");
            }          
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индекс не существует");
        }
    }
}
