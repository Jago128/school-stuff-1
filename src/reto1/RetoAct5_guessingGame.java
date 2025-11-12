package reto1;

import java.util.Scanner;

public class RetoAct5_guessingGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int limU, limL, range, chance, guess = 0, rng, i, rChances;

		do {
			System.out.println("Introduce el limite inferior:");
			limL = sc.nextInt();

			System.out.println("Introduce el limite superior:");
			limU = sc.nextInt();
			if (limL > limU) {
				System.out.println("ERROR. El limite inferior es mayor que el limite superior.");
			} else if (limL == limU) {
				System.out.println("ERROR. Los limites son iguales.");
			}
		} while (limL > limU || limL == limU);
		range = limU - limL + 1;
		sc.close();
		if (range <= 10) {
			chance = 4;
		} else if (11 >= range || range <= 50) {
			chance = 6;
		} else {
			chance = 9;
		}
		rng = (int) Math.floor(Math.random() * (limU - limL + 1) + limL);
		System.out.println("Tiene " + chance + " oportunidades.");
		rChances = chance;

		for (i = 1; i <= chance; i++) {
			System.out.println("Introduzca un numero entre " + limL + " y " + limU + ".");
			guess = sc.nextInt();

			if (guess < rng) {
				System.out.println("El numero es menor que el numero generado.");
				rChances--;
				if (rChances != 1) {
					System.out.println("Te quedan " + rChances + " oportunidades.");
				} else {
					System.out.println("Te quedan " + rChances + " oportunidad.");
				}
			} else if (guess > rng) {
				System.out.println("El numero es mayor que el numero generado,");
				rChances--;
				if (rChances != 1) {
					System.out.println("Te quedan " + rChances + " oportunidades.");
				} else {
					System.out.println("Te quedan " + rChances + " oportunidad.");
				}
			} else {
				System.out.println("Has adivinado el numero!");
				System.out.println("El numero generado era " + rng + ".");
				i = chance;
			}
		}
		sc.close();

		if (guess != rng && chance == i) {
			System.out.println("Has perdido. El numero generado era " + rng + ".");
		}
	}
}
