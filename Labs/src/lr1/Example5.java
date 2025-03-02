package lr1;
import java.util.Scanner;

public class Example5 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите имя: ");
        String name = in.nextLine();

        System.out.println("Введите возраст: ");
        int age = in.nextInt();

        System.out.println("Введите рост: ");
        float height = in.nextFloat();

        System.out.printf("Имя: %s\nВозраст: %d\nРост: %.2f\n",name, age, height);
        in.close();
    }
}