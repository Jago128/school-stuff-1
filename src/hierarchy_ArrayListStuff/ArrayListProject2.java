package hierarchy_ArrayListStuff;

import java.util.*;
import java.util.regex.*;

import hierarchy_ArrayListStuffClasses.*;

public class ArrayListProject2 {

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

				break;

			case 3:

				break;

			case 4:

				break;

			case 5:

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

	public static void addTeacher(ArrayList<Profesor> p, Scanner sc) {
		String email, name, dept;
		
		do {
			System.out.println("Introduce el email:");
			email = sc.next();
			if (!isValidEmail(email)) {
				System.out.println("Email invalido. Introduce un email valido.");
			}
		} while (!isValidEmail(email));
		System.out.println("Introduce el nombre:");
		name = sc.next();
		System.out.println("Introduce el nombre del departamento:");
		dept = sc.next();
		ArrayList<Publicacion> publ = new ArrayList<Publicacion>();
		Profesor pI = new Profesor(email, name, dept, publ);
		p.add(pI);
		System.out.println("Profesor añadido correctamente");
	}

	public static boolean isValidEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		Pattern pattern = Pattern.compile(emailRegex);
		
		if (email == null) {
			return false;
		}
		Matcher matcher = pattern.matcher(email);
		
		return matcher.matches();
	}

}
