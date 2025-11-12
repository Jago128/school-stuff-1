package databaseTestMain;

import java.util.*;

import databaseTestModelo.*;
import utilidades.Utilidades;

public class Main {

	public static void main(String[] args) {
		int menu;
		String name, password;
		ImplementacionDB i = new ImplementacionDB();

		System.out.println("Introduce el nombre:");
		name = Utilidades.introducirCadena();
		System.out.println("Introduce la contraseña:");
		password = Utilidades.introducirCadena();
		if (i.comprobarUsuario(new Usuario(name, password))) {
			do {
				menu = menu();
				switch (menu) {
				case 1:
					insert(i);
					break;

				case 2:
					update(i);
					break;

				case 3:
					delete(i);
					break;

				case 4:
					show(i);
					break;

				case 0:
					System.out.println("Adios!");
				}
			} while (menu != 0);
		} else {
			System.out.println("Las credenciales introducidas son incorrectas.");
		}
	}

	public static int menu() {
		System.out.println("1. Insertar");
		System.out.println("2. Modificar");
		System.out.println("3. Borrar");
		System.out.println("4. Mostrar");
		System.out.println("0. Salir");

		return Utilidades.leerInt("Elija una opcion:", 0, 4);
	}

	public static void insert(ImplementacionDB i) {
		String nom, pass;

		System.out.println("Introduce el nombre:");
		nom = Utilidades.introducirCadena();
		System.out.println("Introduce la contraseña:");
		pass = Utilidades.introducirCadena();
		if (i.insert(new Usuario(nom, pass))) {
			System.out.println("El usuario ha sido introducido correctamente.");
		} else {
			System.out.println("Error al introducir el usuario.");
		}
	}

	public static void update(ImplementacionDB i) {
		String nom, pass;

		System.out.println("Introduce el nombre del usuario a modificar:");
		nom = Utilidades.introducirCadena();
		System.out.println("Introduce la nueva contraseña:");
		pass = Utilidades.introducirCadena();
		if (i.update(new Usuario(nom, pass))) {
			System.out.println("El usuario ha sido actualizado correctamente.");
		} else {
			System.out.println("Error al actualizar el usuario.");
		}
	}

	public static void delete(ImplementacionDB i) {
		System.out.println("Introduce el nombre del usuario a eliminar:");
		if (i.delete(Utilidades.introducirCadena())) {
			System.out.println("El usuario ha sido eliminado correctamente.");
		} else {
			System.out.println("Error al eliminar el usuario.");
		}
	}

	public static void show(ImplementacionDB i) {
		Map<String, Usuario> users = new TreeMap<>();

		users = i.consultaUsuarios();
		for (Usuario user : users.values()) {
			System.out.println(user.toString());
		}
	}
}
