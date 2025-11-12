package hashMap_ExceptionStuff;

import java.util.HashMap;

import hashMap_ExceptionStuffClases.*;
import utilidades.Utilidades;

public class HashMapProject1 {

	public static void main(String[] args) {
		HashMap<Integer, PublicacionP1> p = new HashMap<Integer, PublicacionP1>();
		int menu = menu();

		switch (menu) {
		case 1:
			add(p);
			break;

		case 2:
			show(p);
			break;

		case 3:
			modify(p);
			break;

		case 4:
			eliminar(p);
			break;

		case 5:
			System.out.println("Adios!");
			break;
		}
	}

	public static int menu() {
		System.out.println("1. Introducir nueva publicacion");
		System.out.println("2. Mostrar publicaciones");
		System.out.println("3. Modificacion dado su id");
		System.out.println("4. Eliminar publicacion dado su id");
		System.out.println("5. Salir");
		
		return Utilidades.leerInt("Introduce una opcion:", 1, 5);
	}

	public static void add(HashMap<Integer, PublicacionP1> p) {
		String name;
		int id;
		int menu;
		Tipo type = Tipo.INFANTIL;
		
		do {
			System.out.println("Introduce el ID:");
			id = Utilidades.leerInt();
			if (p.containsKey(id)) {
				System.err.println("Ya hay una publicacion con ese ID.");
			}
		} while (p.containsKey(id));
		System.out.println("Introduce el nombre:");
		name = Utilidades.introducirCadena();

		System.out.println("Elija el tipo:");
		System.out.println("1. Infantil");
		System.out.println("2. Adulto");
		System.out.println("3. Senior");
		menu = Utilidades.leerInt(1, 3);
		
		switch (menu) {
		case 1:
			type = Tipo.INFANTIL;
			break;

		case 2:
			type = Tipo.ADULTO;
			break;

		case 3:
			type = Tipo.SENIOR;
			break;
		}
		PublicacionP1 pI = new PublicacionP1(id, name, type);
		p.put(id, pI);
	}

	public static void show(HashMap<Integer, PublicacionP1> p) {
		for (PublicacionP1 i : p.values()) {
			System.out.println(i.toString());
		}
	}

	public static void modify(HashMap<Integer, PublicacionP1> p) {
		int setT = 0, id;
		String name = null;
		Tipo type = Tipo.INFANTIL;

		System.out.println("Id:");
		id = Utilidades.leerInt();

		if (p.containsKey(id)) {
			PublicacionP1 modified = p.get(id);
			do {
				System.out.println("Codigo:");
				id = Utilidades.leerInt();

				if (p.containsKey(id)) {
					System.err.println("Ese codigo ya existe.");
				}
			} while (p.containsKey(id));
			System.out.println("Titulo:");
			name = Utilidades.introducirCadena();
			System.out.println("--Tipo de publicacion--");
			System.out.println("1. Infantil");
			System.out.println("2. Adulto");
			System.out.println("3. Senior");
			setT = Utilidades.leerInt("Tipo:", 1, 3);
			switch (setT) {
			case 1:
				type = Tipo.INFANTIL;
				break;
			case 2:
				type = Tipo.ADULTO;
				break;
			case 3:
				type = Tipo.SENIOR;
				break;
			}
			modified.setId(id);
			modified.setName(name);
			modified.setType(type);

			p.remove(id);
			p.put(modified.getId(), modified);
		} else {
			System.err.println("Esa publicacion no existe");
		}
	}

	public static void eliminar(HashMap<Integer, PublicacionP1> p) {
		int id;
		
		System.out.println("Map contents: " + p);
		System.out.print("Id: ");
		id = Utilidades.leerInt();

		if (p.containsKey(id)) {
			p.remove(id);
			System.out.println("Publicacion con id " + id + " eliminado.");
		} else {
			System.err.println("Esa publicacion no existe");
		}
	}
}
