package array_MethodStuff;

import java.util.Scanner;

public class ArrayProject4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a[] = { "Xabi", "Jago", "Ekaitz", "Xabi", "Jago" };
		String choice;
		int menu, count = 0;
		boolean found = false;
		
		do {
			System.out.println(
					"1. Salir\n2. Mostrar lista\n3. Pedir un nombre y contar las veces que aparece\n4. Pedir un nombre y decir si existe\n5. Eliminar");
			System.out.println("Introduzca una opcion:");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				System.out.println("Adios!");
				break;

			case 2:
				for (int i = 0; i < a.length; i++) {
					System.out.print(a[i] + " ");
				}
				break;

			case 3:
				do {
					System.out.println("Diga un nombre entre Xabi, Jago, y Ekaitz:");
					choice = sc.next();
					if (!choice.equalsIgnoreCase("Xabi") && !choice.equalsIgnoreCase("Jago")
							&& !choice.equalsIgnoreCase("Ekaitz")) {
						System.out.println("ERROR. Escriba el nombre de nuevo.");
					}
				} while (!choice.equalsIgnoreCase("Xabi") && !choice.equalsIgnoreCase("Jago")
						&& !choice.equalsIgnoreCase("Ekaitz"));
				for (int i = 0; i < a.length; i++) {
					if (choice.equals(a[i])) {
						count++;
					}
				}
				System.out.println("El nombre " + choice + " ha aparecido " + count + " veces.");
				break;

			case 4:
				System.out.println("Diga un nombre entre Xabi, Jago, y Ekaitz:");
				choice = sc.next();

				for (int i = 0; i < a.length && !found; i++) {
					if (choice.equals(a[i])) {
						found = true;
					}
				}
				if (found) {
					System.out.println("El nombre " + choice + " existe.");
				} else {
					System.out.println("El nombre " + choice + " no existe.");
				}
				break;

			case 5:
				System.out.println("Diga un nombre entre Xabi, Jago, y Ekaitz:");
				choice = sc.next();

				for (int i = 0; i < a.length && !found; i++) {
					if (choice.equals(a[i])) {
						found = true;
						a[i] = null;
					}
				}
				if (found) {
					System.out.println("El nombre fue borrado.");
				} else {
					System.out.println("El nombre no fue borrado.");
				}
				break;

			default:
				System.out.println("ERROR. Elija otra opcion.");
				break;
			}
		} while (menu != 1 && menu != 2 && menu != 3 && menu != 4 && menu != 5);
		sc.close();
	}
}
