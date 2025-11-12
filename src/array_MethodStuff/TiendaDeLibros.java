package array_MethodStuff;

import java.util.Scanner;

public class TiendaDeLibros {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a[] = new String[20];
		a[0] = "Nada";
		a[1] = "Tímidamente de la oscuridad a la luz";
		a[2] = "Pájaros a golpes";
		a[3] = "Caperucita Roja";
		a[4] = "12 cuentos clásicos";
		a[5] = "Pepe y Mila";
		a[6] = "Enojaos";
		a[7] = "En casa vacía";
		a[8] = "123";
		a[9] = "Día Negro";
		a[10] = "El Hobbit";
		a[11] = "Calle Judía";

		int b[] = new int[20];
		b[0] = 15;
		b[1] = 12;
		b[2] = 15;
		b[3] = 25;
		b[4] = 19;
		b[5] = 17;
		b[6] = 25;
		b[7] = 13;
		b[8] = 11;
		b[9] = 18;
		b[10] = 25;
		b[11] = 35;
		int menu, bookP;
		String cont = " ", bookN, newName;
		boolean found = false, set = false, check = false, full = false;

		System.out.println("Bienvenido, usuario. Elija una opcion");
		do {
			do {
				cont = " ";
				System.out.println("1. Mostrar el título de todos los libros");
				System.out.println("2. Mostrar el título y el precio de todos los libros");
				System.out.println("3. Mostrar el precio de un libro");
				System.out.println("4. Introducir un nuevo libro");
				System.out.println("5. Eliminar un libro");
				System.out.println("6. Modificar el precio de un libro");
				System.out.println("7. Modificar el título de un libro");
				System.out.println("8. Salir del programa");
				menu = sc.nextInt();
				
				switch (menu) {
				case 1:
					for (int i = 0; i < a.length && a[i] != null; i++) {
						System.out.println("Titulo del libro " + (i + 1) + ": " + a[i]);
					}
					break;

				case 2:
					for (int i = 0; i < a.length && a[i] != null; i++) {
						System.out.println("Titulo del libro " + (i + 1) + ": " + a[i]);
						System.out.println("Precio del libro " + (i + 1) + ": " + b[i] + "€");
					}
					break;

				case 3:
					found = false;
					
					System.out.println("Introduce el titulo de un libro:");
					sc.nextLine();
					bookN = sc.nextLine();
					for (int i = 0; i < a.length && !found; i++) {
						if (bookN.equalsIgnoreCase(a[i])) {
							found = true;
							System.out.println("El precio de " + bookN + " es " + b[i]);
						}
					}
					if (!found) {
						System.out.println("El libro especificado no existe.");
					}
					break;

				case 4:
					check = false;
					full = false;
					
					for (int i = 0; i < a.length && !check; i++) {
						if (a[i] == null) {
							check = true;
						} else if (i == a.length - 1 && !check) {
							System.out.println("Tienes muchos libros en la tienda, elimina un libro.");
							check = true;
							full = true;
						}
					}
					if (!full) {
						set = false;
						
						System.out.println("Introduce el titulo del nuevo libro:");
						sc.nextLine();
						bookN = sc.nextLine();
						do {
							System.out.println("Introduce el precio del nuevo libro:");
							bookP = sc.nextInt();
							if (bookP < 0) {
								System.out.println("ERROR. El precio no puede ser negativo.");
							}
						} while (bookP < 0);

						for (int i = 0; i < a.length && !set; i++) {
							if (a[i] == null) {
								a[i] = bookN;
								b[i] = bookP;
								set = true;
							}
						}
						System.out.println("El libro ha sido guardado.");
					}
					break;

				case 5:
					found = false;
					
					System.out.println("Introduce el titulo del libro a eliminar:");
					sc.nextLine();
					bookN = sc.nextLine();
					for (int i = 0; i < a.length && !found; i++) {
						if (bookN.equalsIgnoreCase(a[i])) {
							found = true;
							a[i] = null;
							b[i] = 0;
							
							for (int j = i + 1; j < a.length; j++) {
								a[j - 1] = a[j];
								b[j - 1] = b[j];
							}
							a[a.length - 1] = null;
							b[b.length - 1] = 0;
						}
					}
					if (found) {
						System.out.println("El libro " + bookN + " ha sido eliminado.");

					} else {
						System.out.println("El libro especificado no existe.");
					}
					break;

				case 6:
					found = false;
					
					System.out.println("Introduce el titulo de un libro:");
					sc.nextLine();
					bookN = sc.nextLine();
					for (int i = 0; i < a.length && !found; i++) {
						if (bookN.equalsIgnoreCase(a[i])) {
							found = true;
							System.out.println("El precio de " + bookN + " es " + b[i]);
							do {
								System.out.println("Introduce el nuevo precio:");
								bookP = sc.nextInt();
								if (bookP < 0) {
									System.out.println("ERROR. El precio no puede ser negativo.");
								}
							} while (bookP < 0);
							b[i] = bookP;
							System.out.println("El nuevo precio de del libro " + bookN + " es " + b[i] + " euros.");
						}
					}
					if (!found) {
						System.out.println("El libro especificado no existe.");
					}
					break;

				case 7:
					found = false;
					
					System.out.println("Introduce el titulo de un libro:");
					sc.nextLine();
					bookN = sc.nextLine();
					for (int i = 0; i < a.length && !found; i++) {
						if (bookN.equalsIgnoreCase(a[i])) {
							found = true;
							System.out.println("Introduce el nuevo titulo:");
							newName = sc.nextLine();
							a[i] = newName;
							System.out.println("El nuevo nombre de del libro " + bookN + " es " + a[i]);
						}
					}
					if (!found) {
						System.out.println("El libro especificado no existe.");
					}
					break;

				case 8:
					System.out.println("Adios!");
					break;

				default:
					System.out.println("ERROR. Elija otra opcion.");
					break;
				}
			} while (menu != 1 && menu != 2 && menu != 3 && menu != 4 && menu != 5 && menu != 6 && menu != 7
					&& menu != 8);
			if (menu != 8) {
				System.out.println("¿Quieres continuar en el programa? (SI/NO)");
				cont = sc.next();
				while (!cont.equalsIgnoreCase("NO") && !cont.equalsIgnoreCase("SI")) {
					System.out.println("ERROR. Di SI o NO.");
					cont = sc.next();
				}
			}
		} while (cont.equalsIgnoreCase("SI") && menu != 8);
		if (cont.equalsIgnoreCase("NO")) {
			System.out.println("Adios!");
		}
		sc.close();
	}
}
