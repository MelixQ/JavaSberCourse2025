package lr7;

import java.io.*;
import java.util.Scanner;


public class Lr7_Task8 {
	public static void main(String[] args) throws IOException {
		Lr7_Dog doggy = new Lr7_Dog("Сеня", "Чихуахуа", 2);

		try (var oos = new ObjectOutputStream(new FileOutputStream("Labs/src/lr7/tasks_data/dog.json"))) {
			oos.writeObject(doggy);
			System.out.println("Сериализация успешна. Данные записаны в dog.json");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (var ois = new ObjectInputStream(new FileInputStream("Labs/src/lr7/tasks_data/dog.json"))){
			var doggy_deserialized = (Lr7_Dog)ois.readObject();
			System.out.println("----------------------------------------------------------------------");
			System.out.printf(
                    "Проверка полей после десериализации.\n\n%s - Кличка\n%s - Порода\n%s - Возраст%n",
					doggy_deserialized.getNickname(), doggy_deserialized.getBreed(), doggy_deserialized.getAge());
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
