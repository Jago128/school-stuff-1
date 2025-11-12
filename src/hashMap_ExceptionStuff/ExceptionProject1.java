package hashMap_ExceptionStuff;

import java.util.HashMap;

import hashMap_ExceptionStuffClases.Cuenta;
import hashMap_ExceptionStuffExceptions.NegativeSalaryException;
import utilidades.Utilidades;

public class ExceptionProject1 {

	public static void main(String[] args) {
		HashMap<String, Cuenta> c = new HashMap<String, Cuenta>();
		int menu = menu();

		switch (menu) {
		case 1:
			add(c);
			break;

		case 2:
			show(c);
			break;

		case 3:
			insert(c);
			break;

		case 4:
			retire(c);
			break;

		case 5:
			showDNIFromName(c);
			break;

		case 6:
			System.out.println("Adios!");
		}
	}

	public static int menu() {
		System.out.println("1. Introducir nueva cuenta");
		System.out.println("2. Mostrar cuentas");
		System.out.println("3. Insertar dinero");
		System.out.println("4. Retirar dinero");
		System.out.println("5. Obtener DNI de las cuentas por nombre de cuenta");
		System.out.println("6. Salir");

		return Utilidades.leerInt("Elija una opcion:", 1, 6);
	}

	public static void negativeSalary(double salario, Cuenta c) throws NegativeSalaryException {
		if (c.getSalary() - salario < 0) {
			throw new NegativeSalaryException();
		}
	}

	public static void add(HashMap<String, Cuenta> c) {
		String dni;
		String name;
		double salary = 0;

		do {
			System.out.println("Introduce el DNI:");
			dni = Utilidades.introducirCadena();
			if (c.containsKey(dni)) {
				System.out.println("Ya existe una cuenta con ese DNI.");
			}
		} while (c.containsKey(dni));
		System.out.println("Introduce el nombre de la cuenta:");
		name = Utilidades.introducirCadena();
		c.put(dni, new Cuenta(dni, name, salary));
		System.out.println("Cuenta añadida.");
	}

	public static void show(HashMap<String, Cuenta> c) {
		for (Cuenta a : c.values()) {
			System.out.println(a.toString());
		}
	}

	public static void insert(HashMap<String, Cuenta> c) {
		String dni;
		double add;

		System.out.println("Introduce el DNI:");
		dni = Utilidades.introducirCadena();

		if (c.containsKey(dni)) {
			System.out.println("¿Cuanto dinero quieres añadir?");
			add = Utilidades.leerDouble();
			c.get(dni).setSalary(add + c.get(dni).getSalary());
			System.out.println("El dinero ha sido añadido correctamente.");
		} else {
			System.out.println("No hay cuenta con el DNI introducido.");
		}
	}

	public static void retire(HashMap<String, Cuenta> c) {
		String dni;
		double remove = 0;
		boolean error = false;

		System.out.println("Introduce el DNI:");
		dni = Utilidades.introducirCadena();
		if (c.containsKey(dni)) {
			do {
				try {
					System.out.println("¿Cuanto dinero quieres quitar?");
					remove = Utilidades.leerDouble();
					negativeSalary(remove, c.get(dni));
					error = false;
				} catch (NegativeSalaryException e) {
					e.NegativeSalaryExceptionMessage(remove);
					error = true;
				}
			} while (error);
			c.get(dni).setSalary(c.get(dni).getSalary() - remove);
			System.out.println("El dinero ha sido añadido correctamente.");
		} else {
			System.out.println("No hay cuenta con el DNI introducido.");
		}
	}

	public static void showDNIFromName(HashMap<String, Cuenta> c) {
		String name;
		boolean found = false;

		System.out.println("Introduce un nombre.");
		name = Utilidades.introducirCadena();

		for (Cuenta e : c.values()) {
			if (e.getName().equalsIgnoreCase(name)) {
				System.out.println("DNI de una cuenta de " + name + ": " + e.getDni());
				found = true;
			}
		}

		if (!found) {
			System.out.println("No hay cuentas con ese nombre.");
		}
	}
}
