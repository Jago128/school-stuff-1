package for_doWhile_WhileStuff;

import java.util.Scanner;

public class ForProject5_StringvalueOf {

	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);

		System.out.println("Escribe un numero: ");
		num = sc.nextInt();

		String count = String.valueOf(num);
		int length = count.length();

		System.out.println("El numero " + count + " tiene " + length + " digitos.");
		sc.close();
	}
}
