package for_doWhile_WhileStuff;

import java.util.Scanner;

public class DoWhileProject4 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int n, i = 0;

		System.out.print("Introduzca un numero entero: ");
		n = teclado.nextInt();

		do {
			if (n % 2 == 0) {
				System.out.print(n + "+");
				i = i + n;
			}
		} while (n >= 0);

		n--;
		System.out.println("\nResultado: " + i);
		teclado.close();
	}
}
