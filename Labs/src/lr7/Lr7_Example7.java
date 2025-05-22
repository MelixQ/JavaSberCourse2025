package lr7;

import java.io.*;


public class Lr7_Example7 {
	public static void main(String[] args) {
		Lr7_Person person = new Lr7_Person("Maxim Kuznetsov", 23);

		try  {
			var fileOut = new FileOutputStream("Labs/src/lr7/example7/person.json");
			var out = new ObjectOutputStream(fileOut);
			out.writeObject(person);
			out.close();
			fileOut.close();
			System.out.println("Сериализация успешна. Данные записаны в person.ser");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
