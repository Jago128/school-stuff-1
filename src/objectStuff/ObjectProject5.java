package objectStuff;

import java.util.Scanner;

import objectStuffClasses.Asignatura;

public class ObjectProject5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Asignatura a[] = new Asignatura[100];
		int menu, count = 0;

		do {
			switch (menu = menu(sc)) {

			case 1:
				count = add(a, sc, count);
				break;

			case 2:
				if (count > 0) {
					obtainApprove(a, sc, count);
				} else {
					System.out.println("No hay asignaturas introducidas");
				}
				break;

			case 3:
				if (count > 0) {
					orderApprove(a, sc, count);
				} else {
					System.out.println("No hay asignaturas introducidas");
				}
				break;

			case 4:
				if (count > 0) {
					modify(a, sc, count);
				} else {
					System.out.println("No hay asignaturas introducidas");
				}
				break;

			case 5:
				if (count > 0) {
					show(a, count);
				} else {
					System.out.println("No hay asignaturas introducidas");
				}
				break;

			case 6:
				if (count > 0) {
					delete(a, sc, count);
				} else {
					System.out.println("No hay asignaturas introducidas");
				}
				break;

			case 7:
				System.out.println("Adios!");
				break;

			default:
				System.out.println("Opcion invalida.");
				break;
			}
		} while (menu != 7);

		sc.close();
	}

	public static int menu(Scanner sc) {
		int menu;

		System.out.println("1. Introducir asignaturas");
		System.out.println("2. Mostrar porcentajes de aprobados en curso");
		System.out.println("3. Ordenar asignaturas por numero de aprobados");
		System.out.println("4. Modificar datos de asignatura");
		System.out.println("5. Mostrar todas las asignaturas introducidas");
		System.out.println("6. Eliminar asignatura");
		System.out.println("7. Salir");
		System.out.println("Introduzca una opcion:");
		menu = sc.nextInt();

		return menu;
	}

	public static int searchAsig(Asignatura[] a, String n, int count) {
		for (int i = 0; i < count; i++) {
			if (a[i].getName().equalsIgnoreCase(n)) {
				return i;
			}
		}

		return -1;
	}

	public static int search(Asignatura[] a, String n, int count) {
		for (int i = 0; i < count; i++) {
			if (a[i].getCourse().equalsIgnoreCase(n)) {
				return i;
			}
		}

		return -1;
	}

	public static int add(Asignatura[] a, Scanner sc, int count) {
		boolean cont = false;
		String next, name, course;
		int student, failed;

		for (int i = 0; i < a.length && !cont; i++) {
			System.out.println("Introduzca el nombre de la asignatura:");
			name = sc.next();
			if (searchAsig(a, name, count) == -1) {
				System.out.println("Introduzca el curso:");
				course = sc.next();
				do {
					System.out.println("Introduzca el numero de alumnos:");
					student = sc.nextInt();
					System.out.println("Introduzca el num de suspensos:");
					failed = sc.nextInt();
					if (failed > student) {
						System.out.println("No puede haber mas suspensos que alumnos.");
					}
				} while (failed > student);

				Asignatura aI = new Asignatura(name, course, student, failed);
				a[i] = aI;
				count++;
				do {
					System.out.println("¿Quiere añadir mas asignaturas? (SI/NO)");
					next = sc.next();
					if (!next.equalsIgnoreCase("SI") && !next.equalsIgnoreCase("NO")) {
						System.out.println("Opcion invalida.");
					}
				} while (!next.equalsIgnoreCase("SI") && !next.equalsIgnoreCase("NO"));

				if (next.equalsIgnoreCase("NO")) {
					cont = true;
				}
			} else {
				System.out.println("La asignatura ya existe.");
			}
		}
		return count;
	}

	public static void obtainApprove(Asignatura[] a, Scanner sc, int count) {
		String course;

		System.out.println("Introduzca el nombre del curso:");
		course = sc.next();
		int pos = search(a, course, count);
		if (pos != -1) {
			a[pos].porcentajeAprobados();
		} else {
			System.out.println("La asignatura introducida no existe.");
		}
	}

	public static void orderApprove(Asignatura[] a, Scanner sc, int count) {
		Asignatura temp = new Asignatura("", "", 0, 0);
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1 && a[j + 1] != null; j++) {
				if (a[j].getCfailed() < a[j + 1].getCfailed()) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		show(a, count);
	}

	public static void modify(Asignatura[] a, Scanner sc, int count) {
		int pos, students, failed;
		String choice;

		System.out.println("Nombre de la asignatura a modificar:");
		String name = sc.next();
		pos = search(a, name, count);
		if (pos == -1) {
			System.out.println("Esa asignatura no existe.");
		} else {
			do {
				System.out.print("¿Quieres cambiar el número de alumnos matriculados?(SI/NO): ");
				choice = sc.next();
				if (!choice.equalsIgnoreCase("SI") && !choice.equalsIgnoreCase("no")) {
					System.out.println("Las opciones válidas son SI/NO");
				}
			} while (!choice.equalsIgnoreCase("SI") && !choice.equalsIgnoreCase("no"));

			if (!choice.equalsIgnoreCase("NO")) {
				do {
					System.out.print("Introduce el nuevo número de alumnos matriculados: ");
					students = sc.nextInt();
					if (students < 0) {
						System.out.println("El número de alumnos no puede ser negativo");
					}
				} while (students < 0);

				a[pos].setStudents(students);
				System.out.println("El número de alumnos se ha modificado correctamente");
			}

			do {
				System.out.print("¿Quieres cambiar el número de suspensos?(SI/NO): ");
				choice = sc.next();

				if (!choice.equalsIgnoreCase("SI") && !choice.equalsIgnoreCase("NO")) {
					System.out.println("Las opciones válidas son SI/NO");
				}
			} while (!choice.equalsIgnoreCase("SI") && !choice.equalsIgnoreCase("SI"));

			if (!choice.equalsIgnoreCase("no")) {
				do {
					System.out.print("Introduce el nuevo número de suspensos: ");
					failed = sc.nextInt();

					if (failed < 0) {
						System.out.println("El número de suspensos no puede ser negativo");
					} else if (failed > a[pos].getStudents()) {
						System.out.println("El número de suspensos no puede ser mayor que el número de alumnos");
					}
				} while (failed < 0 || failed > a[pos].getStudents());

				a[pos].setCfailed(failed);
				System.out.println("El número de suspensos se ha modificado correctamente");
			}
		}
	}

	public static void show(Asignatura[] a, int count) {
		for (int i = 0; i < count; i++) {
			System.out.println(a[i].toString());
		}
	}

	public static int delete(Asignatura[] a, Scanner sc, int count) {
		String name;
		System.out.println("Introduzca la asignatura:");
		name = sc.next();
		int pos = search(a, name, count);
		if (pos != -1) {
			a[pos] = null;
			count--;
			System.out.println("El tren ha sido eliminado.");
			for (int i = pos; i < count; i++) {
				a[i] = a[i + 1];
			}
			a[count] = null;
		} else {
			System.out.println("La asignatura introducida no existe.");
		}

		return count;
	}
}
