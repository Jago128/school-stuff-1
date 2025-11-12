package hashMap_ExceptionStuff;

import java.util.*;

import hashMap_ExceptionStuffClases.*;
import utilidades.Utilidades;

public class HashMapProject2 {

	public static void main(String[] args) {
		HashMap<String, Socio> lS = new HashMap<String, Socio>();
		ArrayList<Publicacion> p = new ArrayList<Publicacion>();
		ListaSocios s = new ListaSocios(lS);
		Catalogo c = new Catalogo(p);
		int menu;

		s.fillData();
		c.fillData();
		System.out.println("Bienvenido a la libreria virtual.");
		String dni;
		System.out.println("Introduce el DNI:");
		dni = Utilidades.introducirCadena();
		if (!s.esSocio(dni)) {
			System.out.println("Este socio no esta en nuestra base de datos, introduce tus datos por favor:");
			s.hacerSocio();
		}

		do {
			menu = menu();
			switch (menu) {
			case 1:
				showCatalog(c, p);
				break;

			case 2:
				alquilar(dni, lS, c, p);
				break;

			case 3:
				showSocio(lS);
				break;

			case 4:
				add(c, p);
				break;

			case 5:
				showAlquilado(lS);
				break;

			case 0:
				System.out.println("Adios");
			}
		} while (menu != 0);
	}

	public static int menu() {
		System.out.println("0. Salir");
		System.out.println("1. Mostrar el catalogo");
		System.out.println("2. Alquilar algo");
		System.out.println("3. Mostrar todos los socios");
		System.out.println("4. Añadir una revista o un libro");
		System.out.println("5. Mostrar las publicaciones que tiene un socio alquilados");

		return Utilidades.leerInt("¿Que quieres hacer?", 0, 5);
	}

	public static void showCatalog(Catalogo c, ArrayList<Publicacion> p) {
		p.addAll(c.getList());
		for (int i = 0; i < p.size(); i++) {
			if (p.get(i) instanceof Libro) {
				((Libro) p.get(i)).visualizar();
			}
			if (p.get(i) instanceof Revista) {
				((Revista) p.get(i)).visualizar();
			}
		}
	}

	public static void alquilar(String dni, HashMap<String, Socio> lS, Catalogo c, ArrayList<Publicacion> p) {
		String code;

		System.out.println("Introduce el codigo de la publicacion:");
		code = Utilidades.introducirCadena();
		int pos = c.posicionPublicacion(code);
		if (pos != -1) {
			lS.get(dni).añadirPublicacion(p.get(pos));
		} else {
			System.out.println("La publicacion no existe.");
		}
	}

	public static void showSocio(HashMap<String, Socio> lS) {
		for (Socio s : lS.values()) {
			s.print();
		}
	}

	public static void add(Catalogo c, ArrayList<Publicacion> p) {
		String code, title;
		int age;
		char choice;

		System.out.println("¿Es un libro o una revista? (L/R)");
		choice = Utilidades.leerChar('L', 'R');

		switch (choice) {
		case 'L':
			int pageN;

			do {
				System.out.println("Introduce el codigo:");
				code = Utilidades.introducirCadena();
				if (c.posicionPublicacion(code) != -1) {
					System.out.println("Ya existe una publicacion con el codigo introducido.");
				}
			} while (c.posicionPublicacion(code) != -1);
			System.out.println("Introduce el titulo:");
			title = Utilidades.introducirCadena();
			System.out.println("Introduce el año:");
			age = Utilidades.leerInt();
			System.out.println("Introduce el numero de paginas:");
			pageN = Utilidades.leerInt();
			p.add(new Libro(code, title, age, pageN));
			c.setList(p);
			break;

		case 'R':
			int num;

			do {
				System.out.println("Introduce el codigo:");
				code = Utilidades.introducirCadena();
				if (c.posicionPublicacion(code) != -1) {
					System.out.println("Ya existe una publicacion con el codigo introducido.");
				}
			} while (c.posicionPublicacion(code) != -1);
			System.out.println("Introduce el titulo:");
			title = Utilidades.introducirCadena();
			System.out.println("Introduce el año:");
			age = Utilidades.leerInt();
			System.out.println("Introduce el numero:");
			num = Utilidades.leerInt();
			p.add(new Revista(code, title, age, num));
			break;
		}
	}

	public static void showAlquilado(HashMap<String, Socio> lS) {
		int i = 0;

		for (Socio s : lS.values()) {
			if (s.getP().get(i) instanceof Libro) {
				((Revista) s.getP().get(i)).visualizar();
			}
			if (s.getP().get(i) instanceof Revista) {
				((Libro) s.getP().get(i)).visualizar();
			}
			i++;
		}
	}
}
