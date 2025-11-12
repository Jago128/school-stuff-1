package reto1;

import java.util.Scanner;

public class RetoAct6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numAtl, recover, rythmStart, rythmRace, rythmBreak, highestR = -1;
		String atl = " ", bestConAtl = " ";

		do {
			System.out.println("Introduzca el numero de atletas:");
			numAtl = sc.nextInt();
			if (numAtl < 1) {
				System.out.println("ERROR. Introduce un numero valido.");
			}
		} while (numAtl < 1);

		for (int i = 0; i < numAtl; i++) {

			System.out.println("Introduzca el nombre del atleta:");
			atl = sc.next();

			do {
				System.out.println("Introduce su frequencia cardiaca en reposo.");
				rythmStart = sc.nextInt();
				if (rythmStart < 1) {
					System.out.println("ERROR. Introduce un numero valido.");
				}
			} while (rythmStart < 1);

			do {
				System.out.println("Introduce su frequencia cardiaca despues de una carrera intensa.)");
				rythmRace = sc.nextInt();
				if (rythmRace < 1) {
					System.out.println("ERROR. Introduce un numero valido.");
				}
			} while (rythmRace < 1);

			do {
				System.out.println("Introduce su frequencia cardiaca en reposo.");
				rythmBreak = sc.nextInt();
				if (rythmBreak < 1) {
					System.out.println("ERROR. Introduce un numero valido.");
				}
			} while (rythmBreak < 1);

			recover = 100 * (rythmRace - rythmBreak) / (rythmRace - rythmStart);
			System.out.println(recover);

			if (recover == 100) {
				System.out.println("El atleta esta en excelente condicion.");
			} else if (recover >= 60 && recover <= 99) {
				System.out.println("El atleta esta en buena condición, pero necesita mejorar.");
			} else {
				System.out.println("El atleta esta en mala condición, requiere atención médica.");
			}

			if (recover > highestR) {
				highestR = recover;
				bestConAtl = atl;
			}
		}
		System.out.println(
				"El atleta con la mejor recuperacion es " + bestConAtl + " con una recuperacion de " + highestR + "%");
		sc.close();
	}
}
