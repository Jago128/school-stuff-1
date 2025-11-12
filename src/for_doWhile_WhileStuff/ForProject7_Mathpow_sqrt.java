package for_doWhile_WhileStuff;

import java.util.Scanner;

public class ForProject7_Mathpow_sqrt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tipoOp;
		double n1, n2, pot, sq;
		String opcion;

		System.out.println("1. Operaciones basicas");
		System.out.println("2. Operaciones complejas");
		System.out.println("3. Terminar programa");
		System.out.print("Escoja una opcion: ");
		tipoOp = sc.nextInt();

		switch (tipoOp) {
		case 1:
			System.out.println("Introduzca dos numeros:");
			n1 = sc.nextDouble();
			System.out.println("Primer numero: " + n1);
			n2 = sc.nextDouble();
			System.out.println("Segundo numero: " + n2);

			System.out.println("a. Suma");
			System.out.println("b. Resta");
			System.out.println("c. Multiplicación");
			System.out.println("d. División");
			System.out.print("Escoja una opcion: ");
			opcion = sc.next();

			switch (opcion) {
			case "a":
				System.out.println(n1 + n2);
				break;

			case "b":
				System.out.println(n1 - n2);
				break;

			case "c":
				System.out.println(n1 - n2);
				break;

			case "d":
				System.out.println(n1 / n2);
				break;

			default:
				System.out.println("Error. Escoja otra opcion.");
				opcion = sc.next();
				break;
			}
			break;

		case 2:
			System.out.println("Introduzca dos numeros:");
			n1 = sc.nextDouble();
			System.out.println("Primer numero: " + n1);
			n2 = sc.nextDouble();
			System.out.println("Segundo numero: " + n2);

			System.out.println("a. Potencia");
			System.out.println("b. Raiz cuadrada");
			System.out.print("Escoja una opcion: ");
			opcion = sc.next();

			switch (opcion) {
			case "a":
				pot = Math.pow(n1, n2);
				System.out.println(pot);
				break;

			case "b":
				sq = Math.sqrt(n1);
				System.out.println(sq);
				break;
			}
			break;

		case 3:
			System.out.println("Adios!");
			break;

		default:
			System.out.println("Error. Escoja otra opcion.");
			tipoOp = sc.nextInt();
			break;
		}
		sc.close();
	}

}
