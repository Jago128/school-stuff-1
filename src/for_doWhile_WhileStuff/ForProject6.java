package for_doWhile_WhileStuff;

import java.util.Scanner;

public class ForProject6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double n1, n2, n3, media;

		do {
			System.out.println("Introduce la nota de la primera asignatura: ");
			n1 = sc.nextDouble();
			if (n1 < 0 || n1 > 10) {
				System.out.println("La nota no puede ser negativa ni mayor de 10. ");
			}
		} while (n1 < 0 || n1 > 10);

		do {
			System.out.println("Introduce la nota de la segunda asignatura: ");
			n2 = sc.nextDouble();
			if (n2 < 0 || n2 > 10) {
				System.out.println("Error! La nota no puede ser negativa ni mayor de 10. ");
			}
		} while (n2 < 0 || n2 > 10);

		do {
			System.out.println("Introduce la nota de la tercera asignatura: ");
			n3 = sc.nextDouble();
			if (n3 < 0 || n3 > 10) {
				System.out.println("Error! La nota no puede ser negativa ni mayor de 10. ");
			}
		} while (n3 < 0 || n3 > 10);

		if (n1 < 5) {
			System.out.println("Asignatura suspendida.");
		} else {
			System.out.println("Asignatura aprobada.");
		}

		if (n2 < 5) {
			System.out.println("Asignatura suspendida.");
		} else {
			System.out.println("Asignatura aprobada.");
		}

		if (n3 < 5) {
			System.out.println("Asignatura suspendida.");
		} else {
			System.out.println("Asignatura aprobada.");
		}

		media = ((n1 + n2 + n3) / 3);
		System.out.println("La nota media del alumno es " + media + ".");
		sc.close();

	}

}
