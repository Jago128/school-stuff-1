package for_doWhile_WhileStuff;

import java.util.Scanner;

public class GestionNotas {

	public static void main(String[] args) {
		String user, pass, name, surN, result = " ";
		int opcion;
		double n1, n2, n3, nFinal, nWork, n;
		Scanner teclado = new Scanner(System.in);

		System.out.print("Introduce tu usuario: ");
		user = teclado.next();
		System.out.print("Introduce to contraseña: ");
		pass = teclado.next();

		while (pass.toLowerCase().indexOf('e') != -1) {
			System.out.println("Error: La contraseña no debe tener la letra e. Introducelo de nuevo");
			System.out.print("Introduce tu usuario: ");
			user = teclado.next();
			System.out.print("Introduce to contraseña: ");
			pass = teclado.next();
		}

		System.out.println("Hola, " + user + ". Elija una opcion:");
		System.out.println("1. Introducir notas.");
		System.out.println("2. Salir del programa.");
		opcion = teclado.nextInt();

		switch (opcion) {
		case 1:
			System.out.print("Introduzca el nombre del alumno: ");
			name = teclado.next();
			System.out.print("Introduzca el apellido del alumno: ");
			surN = teclado.next();

			System.out.print("Introduzca la nota del examen 1: ");
			n1 = teclado.nextDouble();

			do {
				System.out.println("Introduce la nota del primer examen: ");
				n1 = teclado.nextDouble();
				if (n1 < 0 || n1 > 10) {
					System.out.println("Error! La nota no puede ser negativa ni mayor de 10. ");
				}
			} while (n1 < 0 || n1 > 10);

			do {
				System.out.println("Introduce la nota del segundo examen: ");
				n2 = teclado.nextDouble();
				if (n2 < 0 || n2 > 10) {
					System.out.println("Error! La nota no puede ser negativa ni mayor de 10. ");
				}
			} while (n2 < 0 || n2 > 10);

			do {
				System.out.println("Introduce la nota del tercer examen: ");
				n3 = teclado.nextDouble();
				if (n3 < 0 || n3 > 10) {
					System.out.println("Error! La nota no puede ser negativa ni mayor de 10. ");
				}
			} while (n3 < 0 || n3 > 10);

			do {
				System.out.println("Introduce la nota del cuarto examen: ");
				nFinal = teclado.nextDouble();
				if (nFinal < 0 || nFinal > 10) {
					System.out.println("Error! La nota no puede ser negativa ni mayor de 10. ");
				}
			} while (nFinal < 0 || nFinal > 10);

			do {
				System.out.println("Introduce la nota del ultimo trabajo: ");
				nWork = teclado.nextDouble();
				if (nWork < 0 || nWork > 10) {
					System.out.println("Error! La nota no puede ser negativa ni mayor de 10. ");
				}
			} while (nWork < 0 || nWork > 10);

			n = ((n1 * 0.55 + n2 * 0.55 + n3 * 0.55 / 3)) + nFinal * 0.3 + nWork * 0.15;

			if (n >= 0 && n <= 4.9) {
				result = "SUSPENSO";
			} else if (n >= 5 && n <= 5.9) {
				result = "SUFICIENTE";
			} else if (n >= 6 && n <= 6.9) {
				result = "BIEN";
			} else if (n >= 7 && n <= 8.9) {
				result = "NOTABLE";
			} else if (n >= 9 && n <= 10) {
				result = "SOBRESALIENTE";
			}

			System.out.println("La nota de " + name + " " + surN + " es " + n + ", " + result + "");
			break;

		case 2:
			System.out.println("Adios!");
			break;

		default:
			System.out.println("Error. Introduzca otra opcion:");
			opcion = teclado.nextInt();
			break;
		}
		teclado.close();
	}
}
