package fileStuff2Main;

import java.io.*;
import java.util.*;

import fileStuff2Clases.*;
import utilidades.Utilidades;

public class Main {

	public static void main(String[] args) {
		File esc = new File("escuderias.dat");
		File staff = new File("staff.dat");
		File winner = new File("ganadores.dat");
		ArrayList<Escuderia> e = new ArrayList<>();
		ArrayList<Staff> s = new ArrayList<>();
		ArrayList<Ganadores> g = new ArrayList<>();
		int menu = menu();

		if (!esc.exists() || !staff.exists()) {
			fillDataFiles(esc, staff);
		}
		fillArrayLists(e, s, esc, staff);

		switch (menu) {
		case 1:
			showWinEsc(esc, staff, winner, g);
			break;

		case 2:
			modifyNameEsc(esc);
			break;

		case 3:
			addMechanic(s, e, staff);
			break;

		case 4:
			visualize(e, s);
			break;

		case 0:
			System.out.println("Adios!");
		}
	}

	public static int menu() {
		System.out.println("0. Salir");
		System.out.println("1. Mostrar los ganadores por escudería ordenados por carrera");
		System.out.println("2. Modificar nombre de la escudería.");
		System.out.println("3. Insertar mecánico");
		System.out.println("4. Visualizar Staff y Escuderias");
		return Utilidades.leerInt(0, 4);
	}

	public static void fillDataFiles(File esc, File staff) {
		ObjectOutputStream oos;

		if (!esc.exists()) {
			try {
				oos = new ObjectOutputStream(new FileOutputStream(esc));
				oos.writeObject(new Escuderia(1, "Ferrari"));
				oos.writeObject(new Escuderia(2, "Red Bull"));
				oos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (!staff.exists()) {
			try {
				oos = new ObjectOutputStream(new FileOutputStream(staff));
				ArrayList<Carrera> c1 = new ArrayList<>();
				c1.add(new Carrera(1, "Suzuka", false));
				c1.add(new Carrera(2, "Silverstone", true));
				c1.add(new Carrera(3, "Monza", true));
				oos.writeObject(new Piloto(1, "Carlos Sainz", "España", c1));
				ArrayList<Carrera> c2 = new ArrayList<>();
				c2.add(new Carrera(1, "Suzuka", true));
				c2.add(new Carrera(2, "Silverstone", false));
				c2.add(new Carrera(3, "Monza", false));
				oos.writeObject(new Piloto(2, "Mark Webber", "Francia", c2));
				oos.writeObject(new Mecanico(1, "Laura", "Finlandia", Puesto.JUNIOR));
				oos.writeObject(new Mecanico(1, "Sara", "Rumania", Puesto.SENIOR));
				oos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void fillArrayLists(ArrayList<Escuderia> es, ArrayList<Staff> st, File esc, File staff) {
		ObjectInputStream ois;
		boolean end = false;

		try {
			ois = new ObjectInputStream(new FileInputStream(esc));
			while (!end) {
				try {
					Escuderia e = (Escuderia) ois.readObject();
					es.add(e);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (EOFException e) {
					end = true;
				}
			}
			ois.close();
			end = false;
			ois = new ObjectInputStream(new FileInputStream(staff));
			while (!end) {
				try {
					Staff s = (Staff) ois.readObject();
					st.add(s);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (EOFException e) {
					end = true;
				}
			}
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void showWinEsc(File esc, File staff, File winner, ArrayList<Ganadores> g) {
		ObjectOutputStream oos;
		ObjectInputStream ois;
		boolean end = false;

		try {
			ois = new ObjectInputStream(new FileInputStream(staff));
			oos = new ObjectOutputStream(new FileOutputStream(winner));
			try {
				while (!end) {
					Staff s = (Staff) ois.readObject();
					if (s instanceof Piloto) {
						for (Carrera c : ((Piloto) s).getC()) {
							if (c.hasWon()) {
								g.add(new Ganadores(generateCodeWin(s, c, g), s.getName(), getNomEsc(esc, s),
										c.getName()));
								oos.writeObject(g);
							}
						}
					}
				}
				ois.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (EOFException e) {
				end = true;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Collections.sort(g);

		for (int i = 0; i < g.size(); i++) {
			System.out.println(g.get(i).toString());
		}
	}

	public static String generateCodeWin(Staff s, Carrera c, ArrayList<Ganadores> g) {
		return s.getName().substring(0, 2) + "-" + c.getName().substring(0, 2) + "-" + String.format("%04d", g.size());
	}

	public static String getNomEsc(File esc, Staff s) {
		ObjectInputStream ois;
		boolean end = false;
		try {
			ois = new ObjectInputStream(new FileInputStream(esc));
			while (!end) {
				try {
					Escuderia e = (Escuderia) ois.readObject();
					if (e.getCode() == s.getCodeEsc()) {
						return e.getName();
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (EOFException e) {
					end = true;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void modifyNameEsc(File esc) {
		File temp = new File("temp.dat");
		ObjectInputStream ois;
		ObjectOutputStream oos;
		String name;
		boolean end = false, found = false;
		System.out.println("Introduce el nombre de la escuderia:");
		name = Utilidades.introducirCadena();

		try {
			oos = new ObjectOutputStream(new FileOutputStream(temp));
			ois = new ObjectInputStream(new FileInputStream(esc));
			while (!end || !found) {
				try {
					Escuderia tempE = (Escuderia) ois.readObject();
					if (tempE.getName().equalsIgnoreCase(name)) {
						found = true;
						System.out.println("Introduce el nuevo nombre:");
						tempE.setName(Utilidades.introducirCadena());
					}
					oos.writeObject(tempE);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (EOFException e) {
					end = true;
				}
			}
			ois.close();
			oos.close();
			if (found) {
				System.out.println("El nombre ha sido modificado.");
				if (esc.delete()) {
					temp.renameTo(esc);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (!found) {
			System.out.println("No se ha encontrado la escuderia introducida.");
		}
	}

	public static void addMechanic(ArrayList<Staff> s, ArrayList<Escuderia> e, File staff) {
		String name, country, post;
		int codeEsc;
		boolean found = false, error = false;
		Puesto setPost = null;

		System.out.println("Introduce el nombre:");
		name = Utilidades.introducirCadena();
		System.out.println("Introduce el pais:");
		country = Utilidades.introducirCadena();
		do {
			System.out.println("Introduce el codigo de la Escuderia:");
			codeEsc = Utilidades.leerInt();
			for (int i = 0; i < e.size(); i++) {
				if (e.get(i).getCode() == codeEsc) {
					found = true;
				}
			}
			if (!found) {
				System.out.println("La escuderia no se ha encontrado. Introduce un codigo valido entre 1 y "
						+ (e.size() + 1) + ".");
			}
		} while (!found);

		do {
			error = false;
			try {
				System.out.println("Introduce el puesto: (JUNIOR/SENIOR)");
				post = Utilidades.introducirCadena().toUpperCase();
				switch (post) {
				case "JUNIOR":
					setPost = Puesto.JUNIOR;
					break;

				case "SENIOR":
					setPost = Puesto.SENIOR;
					break;

				default:
					throw new IllegalArgumentException("El puesto introducido es invalido.");
				}
			} catch (IllegalArgumentException e1) {
				System.out.println("ERROR: " + e1.getMessage());
				error = true;
			}
		} while (!error);
		s.add(new Mecanico(codeEsc, name, country, setPost));
		updateStaff(s, staff);
	}

	public static void visualize(ArrayList<Escuderia> e, ArrayList<Staff> s) {
		System.out.println("ESCUDERIAS");
		for (int i = 0; i < e.size(); i++) {
			System.out.println(e.get(i).toString());
		}
		System.out.println("STAFF");
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i) instanceof Piloto) {
				((Piloto) s.get(i)).visualizar();
			}
			if (s.get(i) instanceof Mecanico) {
				((Mecanico) s.get(i)).visualizar();
			}
		}
	}

	public static void updateStaff(ArrayList<Staff> s, File staff) {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(staff));
			for (int i = 0; i < s.size(); i++) {
				oos.writeObject(s.get(i));
			}
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
