package hierarchy_ArrayListStuff;

import java.time.LocalDate;
import java.util.*;

import hierarchy_ArrayListStuffClases.*;

public class HierarchyProject2 {

	public static int mostrarMenu(Scanner teclado) {
		System.out.println(
				"0. Introducir datos de empleade/s y/o jefe/s comprobando que no existan ya (a partir de su DNI). Mensaje de error en caso de que se quiera dar de alta a alguien ya existente.");
		System.out.println(
				"1. Visualizar todos los datos (con sueldo final) de todes les empleades (les jefes son empleades)");
		System.out.println("2. Visualizar les jefes.");
		System.out.println(
				"3. Visualizar les jefe/s de un departamento concreto: se introduce el departamento y se mostrará el nombre/s de les jefe/s (1 departamento puede tener más de un jefe). Usar como cabecera: Jefe/s del departamento XXXXXXX\". Si no hay aún ningún jefe para ese departamento, se indicará y no saldrá la cabecera tampoco.");
		System.out.println(
				"4. Introducir nombre o al menos un grupo de caracteres del nombre y visualizar el DNI/s y los años que lleva/n en la empresa indicando si es/son o no jefe. Mensaje de error si no se encuentra.");
		System.out.println(
				"5. Introducir un salario y mostrar aquelles empleades cuyo salario final es igual o superior al introducido. Indicar también cuáles de elles son jefe/s. Mensaje de aviso si no se encuentran");
		System.out.println("6. Introducir un nº de años y mostrar les jefes que lleven en la empresa esos o más años.");
		System.out.println("7. Dar de baja a un empleade/jefe a partir de su DNI, mensaje de error si no existe.");
		System.out.println("8. SALIR");
		System.out.println("Elija una opcion:");

		return teclado.nextInt();
	}

	public static void buscarNom(ArrayList<Empleado> a, Scanner teclado) {
		String nombre;
		boolean encontrado = false;

		System.out.println("Caracteres o nombre a buscar:");
		nombre = teclado.next();
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).getNom_empleado().contains(nombre)) {
				System.out.println("DNI: " + a.get(i).getDni().toString());
				System.out.println("Años de antigüedad " + (LocalDate.now().getYear() - a.get(i).getAnio()));
				if (a.get(i) instanceof Jefe) {
					System.out.println("Es jefe");
				} else {
					System.out.println("No es jefe");
				}
				encontrado = true;
			}
		}

		if (!encontrado) {
			System.out.println("No existe");
		}
	}

	public static void salario_min(ArrayList<Empleado> a, Scanner teclado) {
		int minima = 0;
		boolean hay = false;

		System.out.println("Introduce el salario minimo:");
		minima = teclado.nextInt();
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).calcularSueldoTotal() > minima) {
				System.out.println(a.get(i).toString());
				System.out.println("Salario: " + a.get(i).calcularSueldoTotal());
				hay = true;
				if (a.get(i) instanceof Jefe) {
					System.out.println("Es jefe");
				}
			}
		}

		if (!hay) {
			System.out.println("No se encontraron empleados con sueldo superior a " + minima);
		}
	}

	public static void anios_min(ArrayList<Empleado> a, Scanner teclado) {
		int minima = 0;
		boolean hay = false;

		System.out.println("Introduce los años minimos:");
		minima = teclado.nextInt();
		for (int i = 0; i < a.size(); i++) {
			if (((LocalDate.now().getYear()) - a.get(i).getAnio()) > minima) {
				System.out.println(a.get(i).toString());
				hay = true;
			}
		}

		if (!hay) {
			System.out.println("No se encontraron empleados con antiguedad superior a " + minima);
		}
	}

	public static void eliminar(ArrayList<Empleado> a, Scanner teclado) {
		String dni;
		int pos = -1;

		System.out.println("Introduzca el DNI del empleado que quiera eliminar: ");
		dni = teclado.next();
		pos = buscarPorDni(a, dni);
		if (pos != -1) {
			a.remove(pos);
			System.out.println("Esa persona ha sido borrada.");
		} else {
			System.out.println("No existe ese empleado.");
		}
	}

	public static void mostrarJefesDep(ArrayList<Empleado> a, Scanner teclado) {
		String dep = null;
		boolean encontrado = false;
		System.out.println("Departamento:");
		dep = teclado.next();

		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) instanceof Jefe) {
				if (dep.equalsIgnoreCase(((Jefe) a.get(i)).getNom_dep())) {
					System.out.println(a.get(i).toString());
					encontrado = true;
				}
			}
		}

		if (!encontrado) {
			System.out.println("No hay jefes en ese departamento");
		}
	}

	public static void mostrarJefes(ArrayList<Empleado> a) {
		/*
		 * for(int i=0; i<a.size();i++) { if(a.get(i) instanceof Jefe) {
		 * System.out.println( a.get(i).toString()); } }
		 */

		for (Empleado e : a) {
			if (e instanceof Jefe) {
				System.out.println(e.toString());
			}
		}
	}

	public static void mostrarTodos(ArrayList<Empleado> a) {
		/*
		 * for(int i=0; i<a.size();i++) { System.out.println(a.get(i).toString()); }
		 */

		for (Empleado e : a) {
			System.out.println(e.toString());
		}
	}

	public static int buscarPorDni(ArrayList<Empleado> a, String dni) {
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).getDni().equalsIgnoreCase(dni)) {
				return i;
			}
		}

		return -1;
	}

	public static void introducir(ArrayList<Empleado> a, Scanner teclado) {
		int pos = 0;
		String dni, nom_empleado, nom_dep;
		int mes_entrada, anio;
		double incremento;

		System.out.println("DNI:");
		dni = teclado.next();
		pos = buscarPorDni(a, dni);

		if (pos != -1) {
			System.out.println("Esa persona ya existe.");
		} else {
			System.out.println("Nombre:");
			nom_empleado = teclado.next();
			System.out.println("Mes de entrada:");
			mes_entrada = teclado.nextInt();
			System.out.println("Anio de entrada:");
			anio = teclado.nextInt();
			System.out.println("Incremento");
			incremento = teclado.nextDouble();
			System.out.println("¿Es jefe?");
			if (teclado.next().equalsIgnoreCase("si")) {
				System.out.println("Nombre del depeartamento:");
				nom_dep = teclado.next();
				a.add(new Jefe(dni, nom_empleado, mes_entrada, anio, incremento, nom_dep));
			} else {
				a.add(new Empleado(dni, nom_empleado, mes_entrada, anio, incremento));
			}
		}
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int op = -1;
		ArrayList<Empleado> a = new ArrayList<Empleado>();

		do {
			switch (op = mostrarMenu(teclado)) {
			case 0:
				introducir(a, teclado);
				break;

			case 1:
				if (!a.isEmpty()) {
					mostrarTodos(a);
				} else {
					System.out.println("Debe introducir primero.");
				}
				break;

			case 2:
				if (!a.isEmpty()) {
					mostrarJefes(a);
				} else {
					System.out.println("Debe introducir primero.");
				}
				break;

			case 3:
				if (!a.isEmpty()) {
					mostrarJefesDep(a, teclado);
				} else {
					System.out.println("Debe introducir primero.");
				}
				break;

			case 4:
				if (!a.isEmpty()) {
					buscarNom(a, teclado);
				} else {
					System.out.println("Debe introducir primero.");
				}
				break;

			case 5:
				if (!a.isEmpty()) {
					salario_min(a, teclado);
				} else {
					System.out.println("Debe introducir primero.");
				}
				break;

			case 6:
				if (!a.isEmpty()) {
					anios_min(a, teclado);
				} else {
					System.out.println("Debe introducir primero.");
				}
				break;

			case 7:
				if (!a.isEmpty()) {
					eliminar(a, teclado);
				} else {
					System.out.println("Debe introducir primero.");
				}
				break;

			case 8:
				System.out.println("Agur");
				break;

			default:
				System.out.println("Esa op no esta");
			}
		} while (op != 8);
		teclado.close();
	}
}
