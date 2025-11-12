package for_doWhile_WhileStuff;

import java.util.Scanner;

public class ForProject4_Factorial {

	public static void main(String[] args) {
		int result = 1, num;
		Scanner teclado = new Scanner(System.in);

		System.out.print("Introduzca un numero mayor que 0: ");
		num = teclado.nextInt();
		teclado.close();
		if (num < 1) {
			System.out.println("Error: Introduzca un numero mas grande:");
			num = teclado.nextInt();
		}

		for (int i = 1; i <= num; i++) {
			result = result * i;
		}

		System.out.println("El factorial de " + num + " es: " + result);
	}
}
