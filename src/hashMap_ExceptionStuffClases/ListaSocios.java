package hashMap_ExceptionStuffClases;

import java.util.ArrayList;
import java.util.HashMap;

import utilidades.Utilidades;

public class ListaSocios {
	private HashMap<String, Socio> listSocios;

	public ListaSocios(HashMap<String, Socio> listSocios) {
		this.listSocios = listSocios;
	}

	public HashMap<String, Socio> getListSocios() {
		return listSocios;
	}

	public void setListSocios(HashMap<String, Socio> listSocios) {
		this.listSocios = listSocios;
	}

	@Override
	public String toString() {
		return "ListaSocios [listSocios=" + listSocios + "]";
	}

	public void fillData() {
		ArrayList<Publicacion> p1 = new ArrayList<>();
		p1.add(new Libro("L001", "Java Basics", 2020, 300));
		p1.add(new Revista("R001", "Tech Today", 2023, 1));

		ArrayList<Publicacion> p2 = new ArrayList<>();
		p2.add(new Libro("L002", "Advanced Java", 2021, 450));
		p2.add(new Revista("R002", "Science Monthly", 2022, 5));

		ArrayList<Publicacion> p3 = new ArrayList<>();
		p3.add(new Libro("L003", "Python for Beginners", 2019, 200));
		p3.add(new Revista("R003", "AI Trends", 2023, 3));

		ArrayList<Publicacion> p4 = new ArrayList<>();
		p4.add(new Libro("L004", "Data Structures", 2018, 350));
		p4.add(new Revista("R004", "Health Weekly", 2021, 7));

		ArrayList<Publicacion> p5 = new ArrayList<>();
		p5.add(new Libro("L005", "Machine Learning", 2020, 400));
		p5.add(new Revista("R005", "Coding Chronicles", 2023, 2));

		this.listSocios.put("12345678A", new Socio("12345678A", "Juan", "Pérez", 30, p1));
		this.listSocios.put("23456789B", new Socio("23456789B", "María", "Gómez", 25, p2));
		this.listSocios.put("34567890C", new Socio("34567890C", "Luis", "Martínez", 35, p3));
		this.listSocios.put("45678901D", new Socio("45678901D", "Ana", "López", 28, p4));
		this.listSocios.put("56789012E", new Socio("56789012E", "Carlos", "Hernández", 40, p5));
	}

	public boolean esSocio(String dni) {
		return this.listSocios.containsKey(dni);
	}

	public void hacerSocio() {
		String dni, name, surN;
		int age;
		ArrayList<Publicacion> p = new ArrayList<Publicacion>();
		System.out.println("Introduce tu DNI:");
		dni = Utilidades.introducirCadena();
		System.out.println("Nombre:");
		name = Utilidades.introducirCadena();
		System.out.println("Apellido:");
		surN = Utilidades.introducirCadena();
		age = Utilidades.leerInt("Edad:", 0, 117);
		if (age < 0) {
			do {
				System.err.println("Error. Edad incorrecta.");
				System.out.println("Introduce de nuevo tu edad (un numero positivo):");
				age = Utilidades.leerInt();
			} while (age < 0);
		}
		Socio s = new Socio(dni, name, surN, age, p);
		this.listSocios.put(dni, s);
		System.out.println("Los datos del socio se han guardado.");
	}

	public int posicionSocio(String dni) {
		for (int i = 0; i < listSocios.size(); i++) {
			if (listSocios.containsKey(dni)) {
				return i;
			}
		}
		
		return -1;
	}
}
