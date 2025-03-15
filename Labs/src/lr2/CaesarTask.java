package lr2;

import java.util.Scanner;

public class CaesarTask {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Введите текст для шифрования: ");
		String data = in.nextLine();
		
		System.out.println("Введите ключ для шифрования: ");
		int key = in.nextInt();
		
		String encrypted = caesarShiftEncrypt(data, key);
		
		System.out.println("Текст после преобразование: " + encrypted);
		System.out.println("Преобразовать обратно? (y/n) | n by default");
		
		while (true) {
            String answer = in.nextLine().trim().toLowerCase();

            if (answer.equals("y")) {
                String decrypted = caesarShiftDecrypt(encrypted, key);
                System.out.println("Текст после обратного преобразования: " + decrypted);
                break;
            } else if (answer.equals("n")) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Введите корректный ответ");
            }
        }
		
		in.close();
	}

	private static String caesarShiftEncrypt(String data, int key) {
		char[] charsRepresentation = data.toCharArray();
		char[] shiftedChars = new char[charsRepresentation.length];
		
		for (int i = 0; i < charsRepresentation.length; i++) 
		{
			shiftedChars[i] = (char)(charsRepresentation[i] + key);
		}
		
		String resultString = new String(shiftedChars);
		return resultString;
	}
	
	private static String caesarShiftDecrypt(String data, int key)
	{
		return caesarShiftEncrypt(data, -key);
	}
}
