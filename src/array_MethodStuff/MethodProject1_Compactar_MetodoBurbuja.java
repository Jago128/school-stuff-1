package array_MethodStuff;

import java.util.Scanner;

public class MethodProject1_Compactar_MetodoBurbuja {
	static Scanner sc = new Scanner(System.in);

	public static void add(String prod[], int price[]) {
		boolean check = false, full = false;
		String a, ask = "";
		int b;

		do {
			ask = "";
			for (int i = 0; i < prod.length && !check; i++) {
				if (prod[i] == null) {
					check = true;
				} else if (i == prod.length - 1 && !check) {
					System.out.println("No hay espacio libre.");
					check = true;
					full = true;
				}
			}
			if (!full) {
				System.out.println("Introduce el nombre del producto:");
				sc.nextLine();
				a = sc.nextLine();
				System.out.println("Introduce el precio del producto:");
				b = sc.nextInt();

				check = false;
				for (int i = 0; i < prod.length && !check; i++) {
					if (prod[i] == null) {
						prod[i] = a;
						price[i] = b;
						check = true;
					}
				}

				System.out.println("¿Quiere añadir mas productos? (SI/NO)");
				ask = sc.next();
				while (!ask.equalsIgnoreCase("NO") && !ask.equalsIgnoreCase("SI")) {
					System.out.println("ERROR. Di SI o NO.");
					ask = sc.next();
				}
			}
		} while (ask.equalsIgnoreCase("SI"));
	}

	public static void showProd(String prod[], int price[]) {
		boolean check = false, empty = false;

		for (int i = 0; i < prod.length && !check; i++) {
			if (prod[i] != null) {
				check = true;
			} else if (i == prod.length - 1 && !check) {
				System.out.println("No hay articulos en la tienda.");
				check = true;
				empty = true;
			}
		}
		if (!empty) {
			for (int i = 0; i < prod.length && prod[i] != null; i++) {
				System.out.println("Producto " + (i + 1) + ": " + prod[i]);
				System.out.println("Precio: " + price[i]);
			}
		}
	}

	public static void seeP_prod(String prod[], int price[]) {
		boolean check = false, empty = false, found = false;
		String prodN;

		for (int i = 0; i < prod.length && !check; i++) {
			if (prod[i] != null) {
				check = true;
			} else if (i == prod.length - 1 && !check) {
				System.out.println("No hay articulos en la tienda.");
				check = true;
				empty = true;
			}
		}

		if (!empty) {
			found = false;
			System.out.println("Introduce el nombre del producto:");
			sc.nextLine();
			prodN = sc.nextLine();

			for (int i = 0; i < prod.length && !found; i++) {
				if (prodN.equalsIgnoreCase(prod[i])) {
					found = true;
					System.out.println("El precio de " + prodN + " es " + price[i] + "€");
				}
			}
			if (!found) {
				System.out.println("El articulo no existe.");
			}
		}
	}

	public static void seeIVA(String prod[], int price[]) {
		boolean check = false, empty = false, found = false;
		String prodN;

		for (int i = 0; i < prod.length && !check; i++) {
			if (prod[i] != null) {
				check = true;
			} else if (i == prod.length - 1 && !check) {
				System.out.println("No hay articulos en la tienda.");
				check = true;
				empty = true;
			}
		}
		if (!empty) {
			found = false;
			System.out.println("Introduce el nombre del producto:");
			sc.nextLine();
			prodN = sc.nextLine();

			for (int i = 0; i < prod.length && !found; i++) {
				if (prodN.equalsIgnoreCase(prod[i])) {
					found = true;
					System.out.println("La IVA de " + prodN + " es 21%");
				}
			}
			if (!found) {
				System.out.println("El articulo no existe.");
			}
		}
	}

	public static void modifyP(String prod[], int price[]) {
		boolean check = false, empty = false, found = false;
		String prodN;
		int prodP;

		for (int i = 0; i < prod.length && !check; i++) {
			if (prod[i] != null) {
				check = true;
			} else if (i == prod.length - 1 && !check) {
				System.out.println("No hay articulos en la tienda.");
				check = true;
				empty = true;
			}
		}

		if (!empty) {
			found = false;
			System.out.println("Introduce el nombre del producto:");
			sc.nextLine();
			prodN = sc.nextLine();

			for (int i = 0; i < prod.length && !found; i++) {
				if (prodN.equalsIgnoreCase(prod[i])) {
					found = true;
					System.out.println("El precio de " + prodN + " es " + price[i]);
					do {
						System.out.println("Introduce el nuevo precio:");
						prodP = sc.nextInt();
						if (prodP < 0) {
							System.out.println("ERROR. El precio no puede ser negativo.");
						}
					} while (prodP < 0);
					price[i] = prodP;
					System.out.println("El nuevo precio de del articulo " + prodN + " es " + price[i] + " euros.");
				}
			}

			if (!found) {
				System.out.println("El articulo no existe.");
			}
		}
	}

	public static void delete(String prod[], int price[]) {
		boolean check = false, empty = false, found = false;
		String prodN, areyousure = "";

		for (int i = 0; i < prod.length && !check; i++) {
			if (prod[i] != null) {
				check = true;
			} else if (i == prod.length - 1 && !check) {
				System.out.println("No hay articulos en la tienda.");
				check = true;
				empty = true;
			}
		}
		if (!empty) {
			System.out.println("Introduce el nombre del producto para eliminar:");
			sc.nextLine();
			prodN = sc.nextLine();
			for (int i = 0; i < prod.length && !found; i++) {
				if (prodN.equalsIgnoreCase(prod[i])) {
					found = true;
					System.out.println("¿Esta seguro de que quieres eliminar el producto? (SI/NO)");
					areyousure = sc.next();
					while (!areyousure.equalsIgnoreCase("NO") && !areyousure.equalsIgnoreCase("SI")) {
						System.out.println("ERROR. Di SI o NO.");
						areyousure = sc.next();
					}
					if (areyousure.equalsIgnoreCase("SI")) {
						prod[i] = null;
						price[i] = 0;
						for (int j = i + 1; j < prod.length; j++) {
							prod[j - 1] = prod[j];
							price[j - 1] = price[j];
						}
						prod[prod.length - 1] = null;
						price[price.length - 1] = 0;
						System.out.println("El producto " + prodN + " ha sido eliminado.");
					} else {
						System.out.println("La accion ha sido cancelada.");
					}
				}
			}
			if (!found) {
				System.out.println("El producto no existe.");
			}
		}
	}

	public static void ordenar(String prod[], int price[]) {
		int choice, tempP;
		String tempN, ordenar;
		do {
			System.out.println("¿De que manera quiere ordenar los productos?");
			System.out.println("1. Por precio\n2. Por nombre.");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("En ascendente o descendente? (Escribe uno de los dos)");
				ordenar = sc.next();
				while (!ordenar.equalsIgnoreCase("Ascendente") && ordenar.equalsIgnoreCase("Descendente")) {
					System.out.println("ERROR. Escriba Ascendente o Descendente");
				}

				if (ordenar.equalsIgnoreCase("Ascendente")) {
					for (int i = 0; i < price.length - 1; i++) {
						for (int j = 0; j < price.length - i - 1; j++) {
							if (price[j + 1] < price[j]) {
								tempP = price[j];
								tempN = prod[j];
								price[j] = price[j + 1];
								prod[j] = prod[j + 1];
								price[j + 1] = tempP;
								prod[j + 1] = tempN;
							}
						}
					}
					System.out.println("Productos re-ordenados por precio de menor a mayor.");
				} else if (ordenar.equalsIgnoreCase("Descendente")) {
					for (int i = 0; i < price.length - 1; i++) {
						for (int j = 0; j < price.length - i - 1; j++) {
							if (price[j + 1] > price[j]) {
								tempP = price[j];
								tempN = prod[j];
								price[j] = price[j + 1];
								prod[j] = prod[j + 1];
								price[j + 1] = tempP;
								prod[j + 1] = tempN;
							}
						}
					}
					System.out.println("Productos re-ordenados por precio de mayor a menor.");
				}
				break;

			case 2:
				System.out.println("En ascendente o descendente? (Escribe uno de los dos)");
				ordenar = sc.next();
				while (!ordenar.equalsIgnoreCase("Ascendente") && ordenar.equalsIgnoreCase("Descendente")) {
					System.out.println("ERROR. Escriba Ascendente o Descendente");
				}

				if (ordenar.equalsIgnoreCase("Ascendente")) {
					for (int i = 0; i <= prod.length - 1; i++) {
						for (int j = 0; j < prod.length - i - 1; j++) {
							if (prod[j].compareTo(prod[j + 1]) > 0) {
								tempN = prod[j];
								tempP = price[j];
								prod[j] = prod[j + 1];
								price[j] = price[j + 1];
								prod[j + 1] = tempN;
								price[j + 1] = tempP;
							}
						}
					}
					System.out.println("Productos re-ordenados por nombre en ascendente.");
				} else if (ordenar.equalsIgnoreCase("Descendente")) {
					for (int i = 0; i <= prod.length - 1; i++) {
						for (int j = 0; j < prod.length - i - 1; j++) {
							if (prod[j + 1].compareTo(prod[j]) > 0) {
								tempN = prod[j + 1];
								tempP = price[j + 1];
								prod[j + 1] = prod[j];
								price[j + 1] = price[j];
								prod[j] = tempN;
								price[j] = tempP;
							}
						}
					}
					System.out.println("Productos re-ordenados por nombre en descendente.");
				}
				break;

			default:
				System.out.println("ERROR. Introduzca otra opcion.");
				break;
			}
		} while (choice != 1 && choice != 2);
	}

	public static void main(String[] args) {
		String prod[] = new String[10];
		int price[] = new int[10];
		int menu;

		do {
			do {
				System.out.println(
						"1. Añadir articulos\n2. Mostrar productos de la tienda\n3. Obtener el precio de un producto\n4. Obtener el IVA de un producto\n5. Modificar el precio de un producto\n6. Eliminar un producto\n7. Ordenar productos\n8. Salir");
				System.out.println("¿Que quieres hacer?");
				menu = sc.nextInt();

				switch (menu) {
				case 1:
					add(prod, price);
					break;

				case 2:
					showProd(prod, price);
					break;

				case 3:
					seeP_prod(prod, price);
					break;

				case 4:
					seeIVA(prod, price);
					break;

				case 5:
					modifyP(prod, price);
					break;

				case 6:
					delete(prod, price);
					break;

				case 7:
					ordenar(prod, price);
					break;

				case 8:
					System.out.println("Adios!");
					break;

				default:
					System.out.println("ERROR. Introduzca otra opcion.");
					break;
				}
			} while (menu != 1 && menu != 2 && menu != 3 && menu != 4 && menu != 5 && menu != 6 && menu != 7
					&& menu != 8);
		} while (menu != 8);
		sc.close();
	}
}
