package by.epam.tr.task02_decomposition;
import java.util.Scanner;
/*Реализуйте метод, осуществляющий сжатие строки на основе счетчика повторяющихся символов.
 * Например, строка aaabbcccc должна превратиться в a3b2c5.
 * Если сжатая строка оказалась длиннее исходной,
 * то результатом работы алгоритма должна быть исходная строка.
 * Решить задачу с предположением, что в исходной строке нет цифр.
 * Решить задачи для произвольной строки.
*/
public class task1 {

	public static void main(String[] args) {
		String str;
		
		str = inputStringFromConsole ("Enter string ");
		
		print ("Original string: ", str);
		
		str = compress (str);
		
		print ("Compressed string: ", str);

	}
	
	public static String inputStringFromConsole (String message) {
		String st;
		Scanner sc = new Scanner (System.in);
		System.out.print (message);
	
		st = sc.nextLine();
		
		return st;
	}
	
	public static String compress (String st) {
		
		String st1 = st;
		
		for (int i = 0; i < st.length() - 1; i++) {
		
			int j;
			j = 1;
			
			
			while ( j < st.length() - i ) {
				if ( st.charAt (i) != st.charAt(i + j) ) {
					break;
				} else {
					j++;
				}
			}
			
			if ( j != 1 ) {
				if (j == st.length() - i) {
					st = st.substring( 0, i + 1 ) + j;
				} else {
					st = st.substring( 0, i + 1 ) + j + st.substring ( i + j, st.length() );
				}
			}
			
		}
		
		if (st.length() > st1.length()) {
			return st1;
		} else {
			return st;
		}
		
	}

	public static void print(String message, String st) {
		System.out.println (message + st);
	}
	
}
