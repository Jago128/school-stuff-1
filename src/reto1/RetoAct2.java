package reto1;

import java.util.Scanner;

public class RetoAct2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int worker, wDay, dTask, wTask, bTask = 0;
		double total, bonusT = 0, cost = 0;

		do {
			System.out.println("Introduce el numero de trabajadores:");
			worker = sc.nextInt();
			if (worker < 1) {
				System.out.println("ERROR. Introduce un numero valido.");
			}
		} while (worker < 1);

		for (int i = 0; i < worker; i++) {

			do {
				System.out.println("Introduce el numero de dias trabajados de este trabajador durante esta semana:");
				wDay = sc.nextInt();
				if (wDay < 1 || wDay > 7) {
					System.out.println("ERROR. Introduce un numero entre 1 y 7.");
				}
			} while (wDay < 1 || wDay > 7);

			System.out.println("Este trabajador ha trabajado " + wDay + " dias esta semana.");
			do {
				System.out.println("Introduce el numero de tareas completadas por dia:");
				dTask = sc.nextInt();
				if (dTask < 0) {
					System.out.println("ERROR. Introduce un numero valido.");
				}
			} while (dTask < 0);
			wTask = dTask * wDay;
			System.out.println("Este trabajador ha hecho " + wTask + " tareas esta semana.");

			if (dTask > 10) {
				bTask = (dTask - 10) * wDay;
				System.out.println("El trabajador ha hecho " + bTask + " tareas extra esta semana.");
				wTask = wTask - bTask;
			}
			total = wTask * 12.5;

			if (dTask < 10) {
				System.out.println("El sueldo total de este trabajador es " + total + "€");
				cost = cost + total;

			} else {
				bonusT = total + (1.25 * bTask);

				if (bonusT > total * 0.25) {
					total = wTask * 12.5;
					System.out.println(
							"El sueldo total con bonus excede el 25% del sueldo total sin bonus. El sueldo de este trabajador es "
									+ total + "€");
					cost = cost + total;

				} else {
					System.out.println("El sueldo total de este trabajador es " + bonusT + "€");
					cost = cost + bonusT;
				}
			}
		}
		System.out.println("El coste total para la empresa es " + cost + "€");
		sc.close();
	}
}
