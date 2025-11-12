package hierarchy_ArrayListStuff;

import java.util.*;

public class ArrayListProject1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> a = new ArrayList<String>();
		int menu;
		String search;

		System.out.println("1. Añadir String");
		System.out.println("2. Buscar String");
		System.out.println("3. Borrar String");
		System.out.println("4. Mostrar Strings");
		System.out.println("5. Salir");
		menu = sc.nextInt();

		switch (menu) {
		case 1:
			System.out.println("Introduce un String:");
			a.add(sc.next());
			break;

		case 2:
			System.out.println("Introduce el String para buscar:");
			search = sc.next();
			if (a.contains(search)) {
				System.out.println("Esta en el array.");
			} else {
				System.out.println("No esta en el array.");
			}
			break;

		case 3:
			System.out.println("Introduce el String a borrar:");
			search = sc.next();
			a.remove(search);
			break;

		case 4:
			System.out.println("Bucle For:");
			for (int i = 0; i < a.size(); i++) {
				System.out.println(a.get(i));
			}

			System.out.println("Bucle ForEach:");
			for (String show : a) {
				System.out.println(show);
			}

			System.out.println("Iterator:");
			Iterator<String> i = a.iterator();
			while (i.hasNext()) {
				System.out.println(i.next());
			}

			System.out.println("ListIterator:");
			ListIterator<String> li = a.listIterator();
			while (li.hasNext()) {
				System.out.println(li.next());
			}
			break;

		case 5:
			System.out.println("Adios!");
			break;

		}
		sc.close();
	}
}
