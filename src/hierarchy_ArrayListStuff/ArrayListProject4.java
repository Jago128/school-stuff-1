package hierarchy_ArrayListStuff;

import java.time.LocalDate;
import java.util.*;

import hierarchy_ArrayListStuffClases.*;
import utilidades.Utilidades;

public class ArrayListProject4 {

	public static void main(String[] args) {
		ArrayList<Persona> p = new ArrayList<Persona>();
		int menu;
		menu = menu();

		do {
			switch (menu) {
			case 1:
				add(p);
				break;

			case 2:
				showGordi(p);
				break;

			case 3:
				addParejaMedicion(p);
				break;

			case 4:
				statGordis(p);
				break;

			case 0:
				System.out.println("Adios!");
				break;
			}
		} while (menu != 0);
	}

	public static int menu() {
		System.out.println("1. Dar alta a Gordi o Profesor");
		System.out.println("2. Listado de Gordis");
		System.out.println("3. Añadir una medicion a Gordi y ver su evolución");
		System.out.println("4. Estadistica de Gordis");
		System.out.println("0. Salir");

		return Utilidades.leerInt("Elija una opcion", 0, 4);
	}

	public static int searchName(ArrayList<Persona> p, String name) {
		for (int i = 0; i < p.size(); i++) {
			if (p.get(i).getName().equalsIgnoreCase(name)) {
				return i;
			}
		}

		return -1;
	}

	public static double getIMC_withPos(ArrayList<Persona> p, int pos) {
		return ((Gordi) p.get(pos)).getM().get(pos).getWeight() / (((Gordi) p.get(pos)).getHeight())
				* ((Gordi) p.get(pos)).getHeight();
	}

	public static String clasificacionGordis(double imc) {
		String clasificacion = "";

		if (imc < 16) {
			clasificacion = "Infrapeso: Delgadez Severa";
		} else if (imc < 17) {
			clasificacion = "Infrapeso: Delgadez moderada";
		} else if (imc < 18.5) {
			clasificacion = "Infrapeso: Delgadez aceptable";
		} else if (imc < 25) {
			clasificacion = "Peso Normal";
		} else if (imc < 30) {
			clasificacion = "Sobrepeso";
		} else if (imc < 35) {
			clasificacion = "Obeso: Tipo I";
		} else if (imc < 40) {
			clasificacion = "Obeso: Tipo II";
		} else {
			clasificacion = "Obeso: Tipo III";
		}

		return clasificacion;
	}

	public static double getDiffMed(ArrayList<Persona> p, int pos, double lastWeight) {
		double weight = 0;

		for (int i = 0; i < ((Gordi) p.get(pos)).getM().size(); i++) {
			if (Double.compare(((Gordi) p.get(pos)).getM().get(i).getWeight(), lastWeight) == -1) {
				weight = weight + ((Gordi) p.get(pos)).getM().get(i).getWeight();
				lastWeight = ((Gordi) p.get(pos)).getM().get(i).getWeight();
			} else {
				weight = weight - ((Gordi) p.get(pos)).getM().get(i).getWeight();
				lastWeight = ((Gordi) p.get(pos)).getM().get(i).getWeight();
			}
		}

		return weight;
	}

	public static void add(ArrayList<Persona> p) {
		String choice, name, addMore;
		boolean cont = true;
		LocalDate birthDate, date;
		double height, weight;

		do {
			System.out.println("Introduce el nombre:");
			name = Utilidades.introducirCadena();
			if (searchName(p, name) != -1) {
				System.out.println("Ya existe un Gordi/Pesador con el mismo nombre.");
			}
		} while (searchName(p, name) != -1);

		System.out.println("Introduce la fecha de nacimiento:");
		birthDate = Utilidades.leerFechaDMA();
		System.out.println("Escoja una opcion: (Gordi/Pesador)");
		choice = Utilidades.introducirCadena("Gordi", "Pesador");

		switch (choice) {
		case "Gordi":
			do {
				System.out.println("Introduce una altura:");
				height = Utilidades.leerDouble();
				if (height < 0) {
					System.out.println("Una altura no puede ser negativa.");
				}
			} while (height < 0);

			ArrayList<ParejaMedicion> m = new ArrayList<ParejaMedicion>();
			System.out.println("\nEl codigo del Gordi ha sido automaticamente asignado.\n");
			do {
				System.out.println("Introduce una fecha: (dd/MM/AAAA)");
				date = Utilidades.leerFechaDMA();
				do {
					System.out.println("Introduce un peso que no sea 0:");
					weight = Utilidades.leerDouble();
					if (weight == 0) {
						System.out.println("Peso invalido, introduzca un peso que no sea 0.");
					}
				} while (weight == 0);

				m.add(new ParejaMedicion(date, weight));
				System.out.println("¿Quieres seguir añadiendo parejas de medicion? (SI/NO)");
				addMore = Utilidades.introducirCadena("SI", "NO");
				if (addMore.equalsIgnoreCase("NO")) {
					cont = false;
					Gordi gI = new Gordi(name, birthDate, height, m);
					p.add(gI);
					System.out.println("Volviendo a menu principal...");
				}
			} while (cont);
			break;

		case "Pesador":
			LocalDate joinDate;

			System.out.println("Introduce la fecha de alta: (dd/MM/AAAA)");
			joinDate = Utilidades.leerFechaDMA();
			Pesador pI = new Pesador(name, birthDate, joinDate);
			p.add(pI);
			break;
		}
	}

	public static void showGordi(ArrayList<Persona> p) {
		for (int i = 0; i < p.size(); i++) {
			if (p.get(i) instanceof Gordi) {
				System.out.println("Nombre: " + p.get(i).getName());
				System.out.println("Edad: ");
				System.out.println("Codigo del Gordi: " + ((Gordi) p.get(i)).getCodeG());
				System.out.println("IMC: " + ((Gordi) p.get(i)).getM().get(i).getWeight()
						/ (((Gordi) p.get(i)).getHeight()) * ((Gordi) p.get(i)).getHeight());
			}
		}
	}

	public static void addParejaMedicion(ArrayList<Persona> p) {
		String name;
		int pos;
		ArrayList<ParejaMedicion> m = new ArrayList<ParejaMedicion>();

		System.out.println("Introduce el nombre del Gordi:");
		name = Utilidades.introducirCadena();
		pos = searchName(p, name);
		if (pos != -1) {
			LocalDate date;
			double weight, diffLast, diff;

			m.addAll(((Gordi) p.get(pos)).getM());
			System.out.println("Año de nacimiento: " + p.get(pos).getBirthDate());
			System.out.println("Altura: " + ((Gordi) p.get(pos)).getHeight());
			System.out.println(((Gordi) p.get(pos)).getM());
			System.out.println("Introduce la nueva fecha: (dd/MM/AAAA)");
			date = Utilidades.leerFechaDMA();
			System.out.println("Introduce el nuevo peso:");
			weight = Utilidades.leerDouble();
			m.add(new ParejaMedicion(date, weight));
			((Gordi) p.get(pos)).setM(m);
			System.out.println("IMC actual: " + getIMC_withPos(p, pos));
			diffLast = weight - ((Gordi) p.get(pos)).getM().get(pos).getWeight();
			if (diffLast > 0) {
				System.out.println("Diferencia peso última medición: +" + diffLast + " Kg");
			} else {
				System.out.println("Diferencia peso última medición: -" + diffLast + " Kg");
			}
			diff = getDiffMed(p, pos, weight);
			if (diff > 0) {
				System.out.println("Diferencia peso desde el inicio del tratamiento: +" + diff + " Kg");
			} else {
				System.out.println("Diferencia peso desde el inicio del tratamiento: -" + diff + " Kg");
			}
			if (diff < 0.2 || diff == diffLast) {
				System.out.println("REVISION DE DIETA!!");
			} else if (diff > 0.2) {
				System.out.println("LA DIETA ASIGNADA ES CORRECTA!!");
			}
		} else {
			System.out.println("No existe un Gordi con ese nombre.");
		}
	}

	public static void statGordis(ArrayList<Persona> p) {
		ArrayList<PersonaGordiImc> g = new ArrayList<>();
		String classif;
		double imc, height;
		int index = 0;
		boolean exists = false;

		for (Persona gordi : p) {
			if (gordi instanceof Gordi) {
				height = Math.pow(((Gordi) gordi).getHeight(), 2);
				if (height != 0) {
					imc = ((Gordi) gordi).getM().get(0).getWeight() / height;
					classif = clasificacionGordis(imc);
					exists = false;
					for (int i = 0; i < g.size() && !exists; i++) {
						if (g.get(i).getClassif().equalsIgnoreCase(classif)) {
							exists = true;
							index = i;
						}
					}
					if (exists) {
						g.get(index).setNumero(g.get(index).getNumero() + 1);
					} else {
						g.add(new PersonaGordiImc(classif, 1));
					}
				}
			}
		}
		Collections.sort(g);
		System.out.printf("%-35s %-15s\n", "Clasificación", "Nº de gordis");

		for (PersonaGordiImc gordi : g) {
			System.out.printf("%-35s %15d\n", gordi.getClassif(), gordi.getNumero());
		}
	}
}
