package objectStuff;

import java.util.Scanner;

import objectStuffClasses.Tren;

public class ObjectProject4 {

	public static int searchR(Tren[] t, Scanner sc, int count) {
		String ref;
		System.out.println("Introduzca la referencia del tren:");
		ref = sc.next();
		for (int i = 0; i < count; i++) {
			if (t[i].getRef().equalsIgnoreCase(ref) && !t[i].trenLleno()) {
				return i;
			}
		}

		return -1;
	}

	public static int search(Tren[] t, String r, int count) {
		for (int i = 0; i < count; i++) {
			if (t[i].getRef().equalsIgnoreCase(r)) {
				return i;
			}
		}

		return -1;
	}

	public static int add(Tren[] t, Scanner sc, int count) {
		boolean cont = false;
		String next = "", type = "", ref = "";
		int occupiedS, KM, durMin;

		if (count > t.length) {
			System.out.println("El numero the trenes esta al maximo. No puede añadir mas.");
		} else {
			for (int i = 0; i < t.length && !cont; i++) {
				next = "";
				System.out.println("Introduzca la referencia:");
				ref = sc.next();
				if (search(t, ref, count) == -1) {
					System.out.println("Introduzca el tipo de tren (Cercanias, Ave o Mercancias):");
					type = sc.next();
					if (!type.equalsIgnoreCase("Cercanias") && !type.equalsIgnoreCase("Ave")
							&& !type.equalsIgnoreCase("Mercancias")) {
						type = "Indefinido";
						System.out.println(
								"El tipo introducido no coincide con los mostrados. Por defecto, el tipo del tren queda indefinido.");
						do {
							System.out.println("Introduzca los asientos ocupados (Max capacidad: 400):");
							occupiedS = sc.nextInt();
							if (occupiedS > 400) {
								System.out.println("Numero invalido, introduzca uno menor que 400.");
							}
						} while (occupiedS > 400);
						System.out.println("Introduzca los KM recorridos:");
						KM = sc.nextInt();
						System.out.println("Introduzca la duracion del viaje (en minutos):");
						durMin = sc.nextInt();
						Tren tI = new Tren(type, ref, occupiedS, KM, durMin);
						t[i] = tI;
						count++;
					} else {
						System.out.println("Ya existe un tren con la referencia introducida");
					}

					do {
						System.out.println("¿Quiere añadir mas trenes? (SI/NO)");
						next = sc.next();
						if (!next.equalsIgnoreCase("SI") && !next.equalsIgnoreCase("NO")) {
							System.out.println("Opcion invalida.");
						} else if (next.equalsIgnoreCase("NO")) {
							cont = true;
						}
					} while (!next.equalsIgnoreCase("SI") && !next.equalsIgnoreCase("NO"));
				}
				System.out.println("Los datos han sido introducidos correctamente.");
			}
		}

		return count;
	}

	public static void show(Tren[] t, int count) {
		for (int i = 0; i < count; i++) {
			System.out.println(t[i].toString());
		}
	}

	public static void higherS(Tren[] t, Scanner sc, int count) {
		double speed;
		boolean found = false;

		System.out.println("Introduzca la velocidad:");
		speed = sc.nextDouble();
		for (int i = 0; i < count; i++) {
			if (t[i].obtenerVelocidadtotal() > speed) {
				System.out.println(t[i].getRef());
				System.out.println(t[i].obtenerVelocidadtotal());
				found = true;
			}
		}
		if (!found) {
			System.out.println("No hay trenes con mas de " + speed + "km/h de velocidad.");
		}
	}

	public static void orderDur(Tren[] t, Scanner sc, int count) {
		Tren temp = new Tren("");
		for (int i = 0; i < t.length - 1; i++) {
			for (int j = 0; j < t.length - i - 1 && t[j + 1] != null; j++) {
				if (t[j].getDurMin() < t[j + 1].getDurMin()) {
					temp = t[j];
					t[j] = t[j + 1];
					t[j + 1] = temp;
				}
			}
		}
		show(t, count);
	}

	public static void reserve(Tren[] t, Scanner sc, int count) {
		int pos = searchR(t, sc, count), seatC;

		if (pos == -1) {
			System.out.println("El tren esta lleno o no existe.");
		} else {
			System.out.println("Introduzca el numero de asientos para reservar:");
			seatC = sc.nextInt();
			if (seatC > 400 - t[pos].getOccupiedS()) {
				System.out.println("No se pueden reservar " + seatC + " asientos en el momento.");
			} else {
				t[pos].setOccupiedS(t[pos].getOccupiedS() + seatC);
				System.out.println("Los asientos han sido reservados.");
			}
		}
	}

	public static int delete(Tren[] t, Scanner sc, int count) {
		String r;

		System.out.println("Introduzca la referencia:");
		r = sc.next();
		int pos = search(t, r, count);
		if (pos != -1) {
			t[pos] = null;
			count--;
			System.out.println("El tren ha sido eliminado.");
			for (int i = pos; i < count; i++) {
				t[i] = t[i + 1];
			}
			t[count] = null;
		} else {
			System.out.println("El tren no existe.");
		}

		return count;
	}

	public static int menu(Scanner sc) {
		int menu;

		System.out.println("1. Introducir los trenes");
		System.out.println("2. Mostrar trenes que superen una velocidad");
		System.out.println("3. Ordenar trenes de cercanias por duracion de viaje");
		System.out.println("4. Reserva de asientos");
		System.out.println("5. Mostrar todos los trenes introducidos");
		System.out.println("6. Eliminar un tren");
		System.out.println("7. Salir");
		System.out.println("Introduzca una opcion:");
		menu = sc.nextInt();

		return menu;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Tren t[] = new Tren[30];
		int menu, count = 0;

		do {
			menu = menu(sc);
			switch (menu) {
			case 1:
				count = add(t, sc, count);
				break;

			case 2:
				if (count > 0) {
					higherS(t, sc, count);
				} else {
					System.out.println("No hay cuentas introducidas.");
				}
				break;

			case 3:
				if (count > 0) {
					orderDur(t, sc, count);
				} else {
					System.out.println("No hay cuentas introducidas.");
				}
				break;

			case 4:
				if (count > 0) {
					reserve(t, sc, count);
				} else {
					System.out.println("No hay cuentas introducidas.");
				}
				break;

			case 5:
				if (count > 0) {
					show(t, count);
				} else {
					System.out.println("No hay cuentas introducidas.");
				}
				break;

			case 6:
				if (count > 0) {
					delete(t, sc, count);
				} else {
					System.out.println("No hay cuentas introducidas.");
				}
				break;

			case 7:
				System.out.println("Adios!");
				break;

			default:
				System.out.println("Opcion invalida.");
				break;
			}
		} while (menu != 6);
		sc.close();
	}
}
