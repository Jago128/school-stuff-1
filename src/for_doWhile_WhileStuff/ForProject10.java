package for_doWhile_WhileStuff;

import java.util.Scanner;

public class ForProject10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int min, max;

		System.out.print("Introduzca un numero minimo: ");
		min = sc.nextInt();
		System.out.println("Minimo: " + min);
		System.out.print("Introduzca un numero maximo: ");
		max = sc.nextInt();
		System.out.println("Maximo: " + max);

		for (int n = min; n <= max; n++) {
			System.out.println(n);
			if (n % 2 == 0) {
				System.out.println("Suma de pares: " + (n + n));
			}
			if (n % 2 == 1) {
				System.out.println("Multiplicacion de impares: " + (n * n));
			}
		}
		sc.close();
	}

}
