package for_doWhile_WhileStuff;

import java.util.Scanner;

public class WhileProject2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int n, i;

		System.out.print("Introduzca un numero entero: ");
		n = teclado.nextInt();
		i = 1;
		while (i <= n) {
			System.out.println(i);
			i++;
		}
		teclado.close();
	}
}
