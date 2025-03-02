package lr1;
import java.util.Scanner;

public class Example4 {
	public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите число: ");
        int num = in.nextInt();

        System.out.println("Ваше число: " + num);
        in.close();
    }
}