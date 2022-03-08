package by.epam.tr.task02_decomposition;

import java.util.Scanner;

//Шифр "Сэндвич".  Дан текст. Осуществить шифрование и дешифрование следующим образом: 
//текст разбивается на две одинаковых по количеству символов части и 
//результатом шифрования является строка, в которой символы из первой части чередуются символами из второй части.


public class task2 {

	public static void main(String[] args) {
		String str;
		
		str = inputStringFromConsole ("Enter string ");
		
		print ("Original string: ", str);
		
		str = encryption (str);
		
		print ("Encrypted string: ", str);
		
		str = decryption (str);
		
		print ("Decrypted string: ", str);


	}

	public static String inputStringFromConsole (String message) {
		String st;
		Scanner sc = new Scanner (System.in);
		System.out.print (message);
	
		st = sc.nextLine();
		
		return st;
	}
	
	public static String encryption (String st) {
		if (st.length() % 2 != 0) {
			st = st + " ";
		}
		
		char [] mas;
		mas = st.toCharArray();
		
	
		char [] mas1 = new char [mas.length / 2];
		char [] mas2 = new char [mas.length - mas1.length];
		
		for (int i = 0; i < mas1.length; i++) {
			mas1[i] = mas[i];
		}
		
		for (int i = mas2.length - 1; i >= 0; i--) {
			mas2[i] = mas[mas.length - 1 - i];
		}
		
		char [] masEncr = new char [mas1.length + mas2.length];
		
		for (int i = 0, j = 0; i < masEncr.length - 1; i = i + 2) {
			masEncr[i] = mas1[j];
			masEncr[i + 1] = mas2[j];
			j++;
		}
		
		String st1 = "";
		
		for (int i = 0; i < masEncr.length; i++) {
			st1 = st1 + masEncr[i];
		}
		
		return st1;
	}
	
	public static String decryption (String st) {
		char [] mas;
		mas = st.toCharArray();
	
		char [] mas1 = new char [mas.length / 2];
		char [] mas2 = new char [mas.length - mas1.length];
		
		for (int i = 0, j = 0; i < mas1.length; i++) {
			mas1[i] = mas[j];
			mas2[i] = mas[mas.length - 1 - j];
			j = j + 2;
		}
	
		String st1 = "";
		
		for (int i = 0; i < mas1.length; i++) {
			st1 = st1 + mas1[i];
		}
		
		for (int i = 0; i < mas2.length; i++) {
			st1 = st1 + mas2[i];
		}
		
		return st1;
	}
	
	public static void print(String message, String st) {
		System.out.println (message + st);
	}
	
}
