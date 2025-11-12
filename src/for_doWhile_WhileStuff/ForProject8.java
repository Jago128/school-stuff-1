package for_doWhile_WhileStuff;

import java.util.Scanner;

public class ForProject8 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcion, age;
		String surname, dni, name, bookN, cont = "NO";
		double p1, p2;

		System.out.print("Introduce tu nombre: ");
		name = sc.next();
		System.out.print("Introduce tu apellido: ");
		surname = sc.next();
		System.out.print("Introduce tu DNI: ");
		dni = sc.next();
		System.out.print("Introduce tu edad: ");
		age = sc.nextInt();
		System.out.println("Hola, " + name + " " + surname + "");
		System.out.println("Tu DNI: " + dni);

		if (age > 18) {
			do {
				do {
					System.out.println(
							"1. Comprar libro\r\n" + "2. Comprobar si hay stock\r\n" + "3. Salir del programa");
					opcion = sc.nextInt();
					if (opcion < 1 || opcion > 3) {
						System.out.println("Error, introduzca un numero valido");
					}
				} while (opcion < 1 || opcion > 3);

				switch (opcion) {
				case 1:
					do {
						System.out.print("Introduce el primer numero: ");
						p1 = sc.nextDouble();
						System.out.print("Introduce el segundo numero: ");
						p2 = sc.nextDouble();
						if (p1 < 0 || p2 < 0) {
							System.out.println("Error, introduzca un numero valido");
						}
					} while (p1 < 0 || p2 < 0);
					System.out.println("El precio total es: " + (p1 + p2));

					System.out.println("¿Quieres seguir en el programa?");
					cont = sc.next();
					while (!cont.equalsIgnoreCase("NO") && !cont.equalsIgnoreCase("SI")) {
						System.out.print("ERROR. Di SI o NO: ");
						cont = sc.next();
					}
					break;

				case 2:
					System.out.print("Introduce el nombre del libro: ");
					bookN = sc.next();

					if (bookN.equalsIgnoreCase("Tiburon")) {
						System.out.println("El libro esta disponible.");
					} else {
						System.out.println("El libro no esta disponible.");
					}
					System.out.println("¿Quieres seguir en el programa?");
					cont = sc.next();
					while (!cont.equalsIgnoreCase("NO") && !cont.equalsIgnoreCase("SI")) {
						System.out.println("ERROR. Di SI o NO.");
						cont = sc.next();
					}
					break;

				case 3:
					System.out.println("Adios!");
					break;
				}
			} while (cont.equalsIgnoreCase("SI"));
		} else {
			System.out.println("Eres menor");
		}
		sc.close();
	}
}
