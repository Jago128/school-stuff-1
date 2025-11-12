package objectStuff;

import java.util.Scanner;

import objectStuffClasses.Libro;

public class ObjectProject6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Libro[] l = new Libro[250];
		int count = 0, menu;

		do {
			switch (menu = menu(sc)) {
			case 1:
				count = add(l, sc, count);
				break;

			case 2:
				if (count > 0) {

				} else {
					System.out.println("No hay libros añadidos");
				}
				break;

			case 3:
				if (count > 0) {

				} else {
					System.out.println("No hay libros añadidos");
				}
				break;

			case 4:
				if (count > 0) {

				} else {
					System.out.println("No hay libros añadidos");
				}
				break;

			case 5:
				if (count > 0) {

				} else {
					System.out.println("No hay libros añadidos");
				}
				break;

			case 6:
				if (count > 0) {

				} else {
					System.out.println("No hay libros añadidos");
				}
				break;

			case 7:
				System.out.println("Adios!");
				break;
			}
		} while (menu != 7);
		sc.close();
	}

	public static int menu(Scanner sc) {
		int menu;

		System.out.println("1. Introducir libro");
		System.out.println("2. Mostrar libros de un autor");
		System.out.println("3. Ordenar los libros SuperVentas por numero de ejemplares vendidos");
		System.out.println("4. Eliminar un libro");
		System.out.println("5. Mostrar todas los libros introducidos");
		System.out.println("6. Modificar un libro basado en su ISBN");
		System.out.println("7. Salir");
		System.out.println("Introduzca una opcion:");
		menu = sc.nextInt();

		return menu;
	}

	public static int searchAuthor(Libro[] l, String a, int count) {
		for (int i = 0; i < count; i++) {
			if (l[i].getAuthor().equalsIgnoreCase(a)) {
				return i;
			}
		}

		return -1;
	}

	public static int search(Libro[] l, String isbn, int count) {
		for (int i = 0; i < count; i++) {
			if (l[i].getISBN().equalsIgnoreCase(isbn)) {
				return i;
			}
		}

		return -1;
	}

	public static int add(Libro[] l, Scanner sc, int count) {
		boolean cont = false;
		String ISBN, next = "";
		int sold;
		double price;

		if (count > l.length) {
			System.out.println("El numero de libros esta al limite establecido. No puede añadir mas.");
		} else {
			System.out.println("Introduzca la ISBN del libro:");
			ISBN = sc.next();
			if (search(l, ISBN, count) == -1) {
				for (int i = 0; i < l.length && !cont; i++) {
					Libro lI = new Libro(ISBN);
					l[i] = lI;
					System.out.println("Introduzca el titulo:");
					l[i].setTitle(sc.next());
					System.out.println("Introduzca el nombre del autor:");
					l[i].setAuthor(sc.next());
					do {
						System.out.println("Introduzca el numero de ejemplares vendidos:");
						sold = sc.nextInt();
						if (sold < 0) {
							System.out.println("No puedes introducir un numero negativo.");
						} else {
							l[i].setSold(sold);
						}
					} while (sold < 0);
					do {
						System.out.println("Introduzca el precio:");
						price = sc.nextDouble();
						if (price < 0) {
							System.out.println("No puedes introducir un precio negativo.");
						} else {
							l[i].setPrice(price);
						}
					} while (price < 0);
					do {
						System.out.println("¿Quiere añadir mas libros?");
						next = sc.next();
						if (!next.equalsIgnoreCase("SI") && !next.equalsIgnoreCase("NO")) {
							System.out.println("Opcion invalida.");
						}
					} while (!next.equalsIgnoreCase("SI") && !next.equalsIgnoreCase("NO"));
					if (next.equalsIgnoreCase("NO")) {
						cont = true;
					}
				}
			} else {
				System.out.println("Ya hay un libro con este ISBN.");
			}
		}

		return count;
	}
}
