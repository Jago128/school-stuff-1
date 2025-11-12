package objectStuff;

import java.util.Scanner;

import objectStuffClasses.Cuenta;

public class ObjectProject3_Contains {

	public static int search(Cuenta[] c, Scanner sc, int count) {
		String title;
		
		System.out.println("Introduzca el nombre del titular:");
		title = sc.next();
		for (int i = 0; i < count; i++) {
			if (title.equalsIgnoreCase(c[i].getTitle())) {
				return i;
			}
		}
		
		return -1;
	}

	public static int add(Cuenta[] c, Scanner sc, int count) {
		boolean cont = false;
		String next = "", title;
		
		if (count > c.length) {
			System.out.println("El numero de cuentas esta a maxima capacidad. No puede añadir mas cuentas.");
		} else {
			for (int i = count; i < c.length && !cont; i++) {
				Cuenta cI = new Cuenta();
				c[i] = cI;
				System.out.println("Introduzca el titular:");
				title = sc.next();
				if (search(c, sc, count) == -1) {
					c[i].setTitle(title);
					System.out.println("Introduzca la cantidad de dinero:");
					c[i].setCant(sc.nextDouble());
					count++;
				} else {
					System.out.println("El titular ya existe");
				}
				System.out.println("Quieres continuar añadiendo cuentas? (SI/NO)");
				next = sc.next();
				while (!next.equalsIgnoreCase("SI") && !next.equalsIgnoreCase("NO")) {
					System.out.println("ERROR. Introduzca SI o NO.");
					next = sc.next();
				}
				if (next.equalsIgnoreCase("NO")) {
					cont = true;
				}
			}
			System.out.println("Todos los datos han sido introducidos.");
		}
		
		return count;
	}

	public static void show(Cuenta[] c, int count) {
		for (int i = 0; i < count; i++) {
			System.out.println(c[i].toString());
		}
	}

	public static void ingC(Cuenta[] c, Scanner sc, int count) {
		int pos = search(c, sc, count);
		
		if (pos != -1) {
			System.out.println("Introduzca la cantidad de saldo que quiera añadir:");
			c[pos].ingresar(sc.nextDouble());
			System.out.println("Dinero introducido correctamente.");
		} else {
			System.out.println("ERROR. Cuenta no encontrada.");
		}
	}

	public static void retire12(Cuenta[] c, int count) {
		for (int i = 0; i < count && c[i] != null; i++) {
			c[i].retirar(12);
		}
		System.out.println("Comision de 12€ retirada correctamente a todas las cuentas.");
	}

	public static void highest(Cuenta[] c, int count) {
		int pos = 0;
		double highest = 0;
		
		for (int i = 0; i < count; i++) {
			if (c[i].getCant() > highest) {
				pos = i;
			}
		}
		System.out.println(
				"La cuenta con mayor saldo es " + c[pos].getTitle() + " con " + c[pos].getCant() + "€ de saldo.");
	}

	public static void higherCantTitles(Cuenta[] c, Scanner sc, int count) {
		int cant;
		boolean found = false;

		System.out.println("Introduce una cantidad:");
		cant = sc.nextInt();
		for (int i = 0; i < count; i++) {
			if (c[i].getCant() < cant) {
				System.out.println(c[i].toString());
				found = true;
			}
		}
		if (!found) {
			System.out.println("No se han encontrado cuentas con mayor cantidad a la introducida.");
		}
	}

	public static void showTitle(Cuenta[] c, Scanner sc, int count) {
		int pos = search(c, sc, count);
		
		if (pos != -1) {
			System.out.println(c[pos].toString());
		} else {
			System.out.println("La cuenta no ha sido encontrada.");
		}
	}

	public static void charShow(Cuenta[] c, Scanner sc, int count) {
		String ch;
		boolean found = false;
		
		System.out.println("Introduce la cadena de caracteres:");
		ch = sc.next().toLowerCase();
		for (int i = 0; i < count; i++) {
			if (c[i].getTitle().toLowerCase().contains(ch)) {
				System.out.println(c[i].toString());
				found = true;
			}
		}
		if (!found) {
			System.out.println("No hay cuentas con el caracter o grupo de letras introducido.");
		}
	}

	public static void order(Cuenta[] c, Scanner sc, int count) {
		Cuenta temp = new Cuenta("", 0);
		
		for (int i = 0; i < c.length - 1; i++) {
			for (int j = 0; j < (c.length - 1 - i) && c[j + 1] != null; j++) {
				if (c[j].getCant() < c[j + 1].getCant()) {
					temp = c[j];
					c[j] = c[j + 1];
					c[j + 1] = temp;
				}
			}
		}
		show(c, count);
	}

	public static int delete(Cuenta[] c, Scanner sc, int count) {
		int pos = search(c, sc, count);
		
		if (pos != -1) {
			c[pos] = null;
			count--;
			System.out.println("La cuenta ha sido eliminada.");
			for (int i = pos; i < count; i++) {
				c[i] = c[i + 1];
			}
			c[count] = null;
		} else {
			System.out.println("La cuenta no existe.");
		}
		return count;
	}

	public static int menu(Scanner sc) {
		int menu;
		
		System.out.println(
				"1. Introducir cuentas\n2. Mostrar las cuentas introducidas\n3. Ingresar saldo a un titular\n4. Retirar comision de 12€ a todas las cuentas\n5. Mostrar la cuenta con mayor saldo\n6. Introducirm cantidad y mostrar cuentas con cantidad mayor a la introducida\n7. Mostrar cuenta introduciendo titulo\n8. Mostrar cuentas con titulares que contengan un character/grupo de letras\n9. Ordenar segun saldo\n10. Borrar cuenta\n11. Salir.");
		System.out.println("Introduzca una opcion:");
		menu = sc.nextInt();
		
		return menu;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menu, count = 0;
		Cuenta[] c = new Cuenta[50];
		
		do {
			menu = menu(sc);
			switch (menu) {
			case 1:
				count = add(c, sc, count);
				break;

			case 2:
				if (count > 0) {
					show(c, count);
				} else {
					System.out.println("No hay cuentas introducidas");
				}
				break;

			case 3:
				if (count > 0) {
					ingC(c, sc, count);
				} else {
					System.out.println("No hay cuentas introducidas");
				}
				break;

			case 4:
				if (count > 0) {
					retire12(c, count);
				} else {
					System.out.println("No hay cuentas introducidas");
				}
				break;

			case 5:
				if (count > 0) {
					highest(c, count);
				} else {
					System.out.println("No hay cuentas introducidas");
				}
				break;

			case 6:
				if (count > 0) {
					higherCantTitles(c, sc, count);
				} else {
					System.out.println("No hay cuentas introducidas");
				}
				break;

			case 7:
				if (count > 0) {
					showTitle(c, sc, count);
				} else {
					System.out.println("No hay cuentas introducidas");
				}
				break;

			case 8:
				if (count > 0) {
					charShow(c, sc, count);
				} else {
					System.out.println("No hay cuentas introducidas");
				}
				break;

			case 9:
				if (count > 0) {
					order(c, sc, count);
				} else {
					System.out.println("No hay cuentas introducidas");
				}
				break;

			case 10:
				if (count > 0) {
					count = delete(c, sc, count);
				} else {
					System.out.println("No hay cuentas introducidas");
				}
				break;

			case 11:
				System.out.println("Adios!");
				break;

			default:
				System.out.println("ERROR. Elija una opcion valida.");
				break;
			}
		} while (menu != 11);
		sc.close();
	}
}
