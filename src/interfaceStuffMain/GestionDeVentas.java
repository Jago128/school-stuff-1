package interfaceStuffMain;

import utilidades.Utilidades;

import java.util.ArrayList;

import interfaceStuffClases.*;
import interfaceStuffException.NegativeStockException;

public class GestionDeVentas {

	public static void main(String[] args) {
		ListaArticulo l = new ListaArticulo();
		l.fillData();
		int menu = menu();

		switch (menu) {
		case 1:
			venta(l.getList());
			break;

		case 2:
			show(l.getList());
			break;

		case 3:
			showHealthy(l.getList());
			break;

		case 4:

			break;

		case 5:

			break;

		case 6:

			break;

		case 7:

			break;

		case 0:
			System.out.println("Adios!");
		}
	}

	public static int menu() {
		System.out.println("1. Realizar una venta (crear factura)");
		System.out.println("2. Listar articulos");
		System.out.println("3. Listar articulos sanos");
		System.out.println("4. Pedir un codigo y mostrar los articulos que tienen el precio equivalente del articulo");
		System.out.println("5. Listar los productos mas caros");
		System.out.println("6. Listar los productos con stock bajo");
		System.out.println("7. Pedir codigo de articulo y aumentar stock");
		System.out.println("0. Salir");
		return Utilidades.leerInt(0, 7);
	}

	public static int searchItem(ArrayList<Articulo> l, String code) {
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getCode().equalsIgnoreCase(code)) {
				return i;
			}
		}
		
		return -1;
	}

	public static void venta(ArrayList<Articulo> l) {
		int num, cant, pos;
		String name, surN, code;
		boolean error;
		Factura fI = new Factura();
		
		do {
			System.out.println("Numero Factura:");
			num = Utilidades.leerInt();
			if (num <= 0) {
				System.out.println("El número de factura no puede ser 0 o negativo");
			}
		} while (num <= 0);
		System.out.println("Nombre Cliente:");
		name = Utilidades.introducirCadena();
		System.out.println("Apellido Cliente:");
		surN = Utilidades.introducirCadena();
		fI.setNum(num);
		fI.setName(name);
		fI.setSurN(surN);
		do {
			do {
				System.out.print("Introduce el código del producto (end para acabar): ");
				code = Utilidades.introducirCadena();
				pos = searchItem(l, code);
				if (pos == -1 && !code.equalsIgnoreCase("end")) {
					System.out.println("El código introducido no está asocidado a ningún producto");
				}
			} while (pos == -1 && !code.equalsIgnoreCase("end"));

			do {
				error = false;
				if (!code.equalsIgnoreCase("end")) {
					do {
						System.out.print("Introduce la cantidad de producto: ");
						cant = Utilidades.leerInt();
						if (cant <= 0) {
							System.out.println("La cantidad de producto no puede ser 0 o negativo");
						}
					} while (cant < 0);
					try {
						l.get(pos).quitarStock(cant);
						fI.getReceiptLines().add(new LineaFactura(code, cant, (l.get(pos).getPrice() * cant)));
					} catch (NegativeStockException e) {
						System.out.println("Error: " + e.getMessage());
					}
				}
			} while (error);
		} while (!code.equalsIgnoreCase("end"));

		fI.setTotal(fI.calcularTotal());
		fI.print();
	}

	public static void show(ArrayList<Articulo> l) {
		for (Articulo a : l) {
			System.out.println(a);
		}
	}

	public static void showHealthy(ArrayList<Articulo> l) {
		for (Articulo a : l) {
			if (a.sano()) {
				System.out.println(a);
			}
		}
	}

	public static void equivPrice(ListaArticulo l) {
		ArrayList<Articulo> e;

		System.out.print("Introduce el código: ");
		String code = Utilidades.introducirCadena();
		e = l.equivalentes(code);
		if (e.isEmpty()) {
			System.out.println("No hay ningún artículo con el código introducido");
		} else if (e.size() == 1) {
			System.out.println("No hay ningún artículo con el precio equivalente al del artículo: "
					+ l.getList().get(l.posArticulo(code)));
		} else {
			System.out.println(e.toString());
		}
	}

	public static void incrStock(ListaArticulo l) {
		int pos, stock;
		System.out.print("Introduce el código: ");
		pos = searchItem(l.getList(), Utilidades.introducirCadena());
		if (pos == -1) {
			System.out.println("No hay ningún artículo con el código introducido");
		} else {
			System.out.println("El artículo tiene un stock de " + l.getList().get(pos).getStock());

			do {
				System.out.println("Introduce la cantidad a añadir:");
				stock = Utilidades.leerInt();
				if (stock <= 0) {
					System.out.println("El numero introducido es invalido. Tiene que ser mayor que 0.");
				}
			} while (stock <= 0);
			l.getList().get(pos).sumarStock(stock);
		}
	}
}
