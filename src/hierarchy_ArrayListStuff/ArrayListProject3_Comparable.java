package hierarchy_ArrayListStuff;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import hierarchy_ArrayListStuffClases.*;

public class ArrayListProject3_Comparable {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Profesor> p = new ArrayList<Profesor>();
		int menu;

		do {
			menu = menu(sc);

			switch (menu) {

			case 1:
				addTeacher(p, sc);
				break;

			case 2:
				addPubl(p, sc);
				break;

			case 3:
				searchYearandIfPrized(p, sc);
				break;

			case 4:
				showDeptDescendentPubl(p, sc);
				break;

			case 5:
				showTeacher(p);
				break;

			case 6:
				System.out.println("Adios!");
				break;

			default:
				System.out.println("ERROR. Opcion invalida.");
			}
		} while (menu != 6);
		sc.close();
	}

	public static boolean seachTitle(ArrayList<Profesor> a, String title) {
		ArrayList<Publicacion> publ = new ArrayList<Publicacion>();

		for (int h = 0; h < a.size(); h++) {
			publ.addAll(a.get(h).getP());
		}
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; i < publ.size(); j++) {
				if (publ.get(j).getTitle().equals(title)) {
					return false;
				}
			}
		}

		return true;
	}

	public static int menu(Scanner sc) {
		int menu;

		System.out.println("1. Introducir un profesor");
		System.out.println("2. Añadir publicación");
		System.out.println("3. Mostrar los libros premiados de un año concreto");
		System.out
				.println("4. Mostrar un listado por departamento de los profesores con mayor numero de publicaciones");
		System.out.println("5. Listado de profesores");
		System.out.println("6. Salir");
		menu = sc.nextInt();

		return menu;
	}

	public static boolean emailCheck(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

		return email.matches(emailRegex);
	}

	public static int searchEmail(ArrayList<Profesor> p, String email) {
		for (int i = 0; i < p.size(); i++) {
			if (p.get(i).getEmail().equalsIgnoreCase(email)) {
				return i;
			}
		}

		return -1;
	}

	public static void addTeacher(ArrayList<Profesor> p, Scanner sc) {
		String email, name, dept;

		do {
			System.out.println("Introduce el email:");
			email = sc.next();
			if (!emailCheck(email)) {
				System.out.println("Email invalido. Introduce un email valido.");
			}
		} while (!emailCheck(email));
		System.out.println("Introduce el nombre:");
		name = sc.next();
		System.out.println("Introduce el nombre del departamento:");
		dept = sc.next();
		ArrayList<Publicacion> publ = new ArrayList<Publicacion>();
		Profesor pI = new Profesor(email, name, dept, publ);
		p.add(pI);
		System.out.println("Profesor añadido correctamente");
	}

	public static void addPubl(ArrayList<Profesor> p, Scanner sc) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DD-MM-YYYY");
		String email, cont, title;
		int choice;
		CharSequence setDate;
		ArrayList<Publicacion> publ = new ArrayList<Publicacion>();

		System.out.println("Introduce el email del profesor:");
		email = sc.next();
		int pos = searchEmail(p, email);
		if (pos != -1) {
			do {
				System.out.println("Introduce el titulo:");
				title = sc.next();
				System.out.println("Introduce la fecha de publicacion: (DD/MM/AAAA)");
				setDate = sc.next();
				LocalDate date = LocalDate.parse(setDate, formatter);
				do {
					System.out.println("¿Quiere introducir un libro or un articulo?");
					choice = sc.nextInt();

					switch (choice) {
					case 1:
						String ISBN, setPrized;
						boolean prized = false;
						System.out.println("Introduce el ISBN:");
						ISBN = sc.next();
						do {
							System.out.println("¿Es premiado o no? (SI/NO)");
							setPrized = sc.next();
							if (!setPrized.equalsIgnoreCase("SI") && !setPrized.equalsIgnoreCase("NO")) {
								System.out.println("ERROR. Opcion invalida.");
							} else if (setPrized.equalsIgnoreCase("SI")) {
								prized = true;
							} else {
								prized = false;
							}
							publ.addAll(p.get(pos).getP());
							publ.add(new Libro(date, title, ISBN, prized));
						} while (!setPrized.equalsIgnoreCase("SI") && !setPrized.equalsIgnoreCase("NO"));
						break;

					case 2:
						String media;
						System.out.println("Introduce el medio:");
						media = sc.next();
						publ.addAll(p.get(pos).getP());
						publ.add(new Articulo(date, title, media));
						break;

					default:
						System.out.println("Opcion invalida.");
					}

				} while (choice != 1 && choice != 2);

				System.out.println("Quiere añadir mas publicaciones?");
				cont = sc.next();
			} while (!cont.equalsIgnoreCase("NO"));
		}
	}

	public static void searchYearandIfPrized(ArrayList<Profesor> p, Scanner sc) {
		int year = 0;
		ArrayList<Publicacion> publ = new ArrayList<Publicacion>();
		System.out.println("Introduzca el año del que quiera ver los libros galardonados:");
		for (Profesor e : p) {
			for (int i = 0; i < e.getP().size(); i++) {
				if (year == e.getP().get(i).getDate().getYear()) {
					if (((Libro) publ.get(i)).isPrized()) {
						System.out.println(publ.get(i).toString());
					}
				}
			}
		}
	}

	public static void showDeptDescendentPubl(ArrayList<Profesor> p, Scanner sc) {
		int check = 0;
		ArrayList<ComparingP> dept = new ArrayList<ComparingP>();
		ComparingP ph;

		for (Profesor prof : p) {
			check = 0;
			for (int i = 0; i < dept.size() && check == 0; i++) {
				if (dept.get(i).getDept().equalsIgnoreCase(prof.getDept())) {
					check = 1;
					if (dept.get(i).getNum() < prof.getP().size()) {
						dept.get(i).setNameP(prof.getName());
						dept.get(i).setNum(prof.getP().size());
					}
				}
			}

			if (check == 0) {
				if (prof.getP().size() > 0) {
					ph = new ComparingP();
					ph.setDept(prof.getDept());
					ph.setNameP(prof.getName());
					ph.setNum(prof.getP().size());
					dept.add(ph);
				}
			}
		}

		if (dept.size() > 0) {
			Collections.sort(dept);
			System.out.println("Nombre departamento Nombre profesor Número de publicaciones");
			for (int i = 0; i < p.size(); i++) {
				System.out.println(dept.get(i).getDept() + " " + dept.get(i).getNameP() + " " + dept.get(i).getNum());
			}
		} else {
			System.out.println("Aún no hay publicaciones de ningún profesor por lo que no hay listado");
		}
	}

	public static void showTeacher(ArrayList<Profesor> p) {
		// ForEach
		for (Profesor profesor : p) {
			System.out.println(profesor.toString());
		}

		// ListIterator
		ListIterator<Profesor> li = p.listIterator();
		while (li.hasNext()) {
			System.out.println(li.next().toString());
		}
	}
}
