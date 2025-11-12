package reto1;

import java.util.Scanner;

public class RetoAct1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num, mul1, mul2;

		do {
			System.out.println("Introduce un numero entre 50 y 350:");
			num = sc.nextInt();
			if (num < 50 || num > 350) {
				System.out.println("ERROR. Introduce otro numero.");
			}
		} while (num < 50 || num > 350);

		do {
			System.out.println("Introduce dos numeros entre 1 y 10. No pueden ser iguales.");
			do {
				System.out.println("Multiplo 1:");
				mul1 = sc.nextInt();
				if (mul1 < 1 || mul1 > 10) {
					System.out.println("ERROR. Introduce otro numero.");
				}
			} while (mul1 < 1 || mul1 > 10);

			do {
				System.out.println("Multiplo 2:");
				mul2 = sc.nextInt();
				if (mul2 < 1 || mul2 > 10) {
					System.out.println("ERROR. Introduce otro numero.");
				}
			} while (mul2 < 1 || mul2 > 10);
		} while (mul1 == mul2);

		for (int i = 1; i <= num; i++) {
			if (i % mul1 == 0) {
				System.out.println("El numero " + i + " es multiplo de " + mul1);
			}
			if (i % mul2 == 0) {
				System.out.println("El numero " + i + " es multiplo de " + mul2);
			}
		}
		sc.close();
	}
}
