package examNivel;

import java.util.Scanner;

public class ExamNivel {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name, surN, fruitN, pass = " ", fruit;
		int age, choice;
		double p1, p2, p3;

		System.out.println("Introduce nombre:");
		name = sc.next();
		System.out.println("Introduce apellido:");
		surN = sc.next();
		System.out.println("Introduce la edad:");
		age = sc.nextInt();
		if (age >= 18) {
			System.out.println("Bienvenido " + name + " " + surN + " a la fruteria.");
			System.out.println("1. Realizar una nueva compra");
			System.out.println("2. Comprobar si existe fruta");
			System.out.println("3. Introducir fruta");
			System.out.println("4. Salir");
			System.out.println("¿Que quieres realizar?");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("**Realizar compra**");
				do {
					System.out.println("Introduce el precio del primer producto:");
					p1 = sc.nextDouble();

					if (p1 < 0) {
						System.out.println("ERROR, introducelo de nuevo.");
					}
				} while (p1 < 0);

				do {
					System.out.println("Introduce el precio del segundo producto:");
					p2 = sc.nextDouble();

					if (p2 < 0) {
						System.out.println("ERROR, introducelo de nuevo.");
					}
				} while (p2 < 0);

				do {
					System.out.println("Introduce el precio del tercer producto:");
					p3 = sc.nextDouble();

					if (p3 < 0) {
						System.out.println("ERROR, introducelo de nuevo.");
					}
				} while (p3 < 0);
				System.out.println("Total:" + (p1 + p2 + p3));
				break;

			case 2:
				System.out.println("**Comprobar si existe fruta**");
				System.out.println("Introduce el nombre de una fruta:");
				fruitN = sc.next();
				fruitN.toLowerCase();
				if (fruitN.equalsIgnoreCase("manzana")) {
					System.out.println("Si tenemos esta fruta");
				} else {
					System.out.println("No tenemos esta fruta");
				}
				break;
			case 3:
				System.out.println("**Introducir Fruta**");
				do {
					System.out
							.print("Para realizar esta accion necesitas ser administrador. Introduce la contraseña: ");
					pass = sc.next();
				} while (!pass.equals("abc"));

				System.out.println("Eres administrador");
				System.out.print("Introduce el nombre de la fruta: ");
				fruit = sc.next();

				for (int i = 0; i < 3; i++) {
					System.out.println("La fruta " + fruit + " se ha guardado.");
				}

				break;
			case 4:
				System.out.println("**Salir**");
				System.out.println("Hasta luego " + name + "");

			default:
				System.out.println("ERROR");
				break;
			}

		} else {
			System.out.println("No puedes introducirte en el sistema.");
		}

		sc.close();
	}
}
