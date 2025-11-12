package objectStuff;

import java.util.Scanner;

import objectStuffClasses.Persona;

public class ObjectProject2 {

	public static void add(Persona[] p, Scanner sc) {
		for (int i = 0; i < p.length; i++) {
			Persona pI = new Persona();

			p[i] = pI;
			System.out.println("Introduzca los datos de la persona " + (i + 1));
			System.out.println("Nombre:");
			p[i].setNombre(sc.next());
			System.out.println("Edad:");
			p[i].setEdad(sc.nextInt());
			System.out.println("DNI:");
			p[i].setDNI(sc.next());
		}
		System.out.println("Todos los datos han sido introducidos.");
	}

	public static void showHighestAge(Persona[] p) {
		int highest = 0, pos = 0;

		for (int i = 0; i < p.length; i++) {
			if (p[i].getEdad() > highest) {
				pos = i;
			}
		}
		p[pos].mostrar();
	}

	public static void DNIp(Persona[] p, Scanner sc) {
		String DNI;
		boolean check = false;

		do {
			System.out.println("Introduzca el DNI de la persona:");
			DNI = sc.next();
			for (int i = 0; i < p.length && !check; i++) {
				if (p[i].getDNI().equals(DNI)) {
					check = true;
					p[i].mostrar();
				}
			}
			if (!check) {
				System.out.println("ERROR. Introduzca un DNI valido.");
			}
		} while (!check);
	}

	public static void show(Persona[] p) {
		for (int i = 0; i < p.length; i++) {
			p[i].mostrar();
		}
	}

	public static int menu(Scanner sc) {
		int menu;

		System.out.println(
				"1. Introducir los datos de todas las personas\n2. Mostrar la persona con la mayor edad\n3. Introducir DNI y mostrar persona\n4. Mostrar info de todas las personas\n5. Salir.");
		System.out.println("Introduzca una opcion:");
		menu = sc.nextInt();

		return menu;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Persona[] p = new Persona[10];
		int menu;

		do {
			menu = menu(sc);
			switch (menu) {

			case 1:
				add(p, sc);
				break;

			case 2:
				showHighestAge(p);
				break;

			case 3:
				DNIp(p, sc);
				break;

			case 4:
				show(p);
				break;

			case 5:
				System.out.println("Adios!");
				break;

			default:
				System.out.println("ERROR. Elija una opcion valida.");
				break;
			}
		} while (menu != 5);
		sc.close();
	}
}
