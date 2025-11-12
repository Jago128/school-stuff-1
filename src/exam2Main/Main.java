package exam2Main;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.*;

import exam2Clases.*;
import exam2Exception.IncorrectDNIException;
import utilidades.*;

public class Main {

	public static void main(String[] args) {
		File persona = new File("personas.dat");
		ArrayList<Cliente> c = new ArrayList<>();
		int menu;

		if (!persona.exists()) {
			crearFichero(persona);
		}

		leerFichero(persona, c);
		login(persona);
		do {
			menu = menu();
			switch (menu) {
			case 1:
				showWorkers(persona);
				break;

			case 2:
				showClientsSortByName(c);
				break;

			case 3:
				addTraining(c);
				break;

			case 4:
				addWorker(persona);
				break;

			case 5:
				System.out.println("Adios!");
				endProgram(persona, c);
			}
		} while (menu != 5);
	}

	public static int menu() {
		System.out.println("1. Ver trabajadores");
		System.out.println("2. Ver clientes ordenados por nombre");
		System.out.println("3. Añadir entrenamiento a un cliente");
		System.out.println("4. Añadir trabajador");
		System.out.println("5. Salir");

		return Utilidades.leerInt("Introduce la opcion a elegir:", 1, 5);
	}

	public static void login(File persona) {
		boolean correct = false, end = false;
		String username, password;
		ObjectInputStream ois;

		do {
			end = false;
			System.out.println("Introduzca tu nombre de usuario:");
			username = Utilidades.introducirCadena();
			System.out.println("Introduzca tu contraseña:");
			password = Utilidades.introducirCadena();
			try {
				ois = new ObjectInputStream(new FileInputStream(persona));
				try {
					do {
						Trabajador t = (Trabajador) ois.readObject();
						if (((Trabajador) t).getUsername().equals(username)
								&& ((Trabajador) t).getPassword().equals(password)) {
							correct = true;
						}
					} while (!end);
				} catch (EOFException e) {
					end = true;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				ois.close();
				if (!correct) {
					System.out.println("El usuario o la contraseña son incorrectas.");
				} else {
					System.out.println("Acceso autorizado.");
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("UN ERROR FATAL HA OCURRIDO");
			}
		} while (!correct);
	}

	public static void crearFichero(File persona) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(persona));
			HashMap<String, Entrenamiento> entrenamientos = new HashMap<String, Entrenamiento>();
			Entrenamiento ent;
			Cliente cliente;
			Trabajador trabajador;

			ent = new Entrenamiento("WOD-100", LocalDate.now(), "Sentadillas", 100);
			entrenamientos.put(ent.getCode(), ent);
			ent = new Entrenamiento("WOD-101", LocalDate.now(), "Flexiones", 200);
			entrenamientos.put(ent.getCode(), ent);
			ent = new Entrenamiento("WOD-102", LocalDate.now(), "Abdominales", 500);
			entrenamientos.put(ent.getCode(), ent);
			cliente = new Cliente("160654812A", "Pedro", LocalDate.now(), entrenamientos);
			oos.writeObject(cliente);
			entrenamientos.clear();
			ent = new Entrenamiento("WOD-101", LocalDate.now(), "Sentadillas", 400);
			entrenamientos.put(ent.getCode(), ent);
			ent = new Entrenamiento("WOD-102", LocalDate.now(), "Planchas", 250);
			entrenamientos.put(ent.getCode(), ent);
			ent = new Entrenamiento("WOD-103", LocalDate.now(), "Burpees", 500);
			entrenamientos.put(ent.getCode(), ent);
			cliente = new Cliente("76543214A", "Laura", LocalDate.now(), entrenamientos);
			oos.writeObject(cliente);
			trabajador = new Trabajador("65432173A", "Sandra", "usuarioS", "1234", Cargo.MONITOR);
			oos.writeObject(trabajador);
			trabajador = new Trabajador("85432173A", "Jorge", "usuarioJ", "1234", Cargo.MONITOR);
			oos.writeObject(trabajador);
		} catch (FileNotFoundException e1) {
			System.out.println("Error, fichero no encontrado, consulta la ruta especificada");
		} catch (IOException e2) {
			System.err.println("UN ERROR FATAL HA OCURRIDO");
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				System.err.println("UN ERROR FATAL HA OCURRIDO");
			}
		}
	}

	public static void leerFichero(File persona, ArrayList<Cliente> cliente) {
		File aux = new File("toMove.dat");
		ObjectInputStream ois;
		ObjectOutputStream oos;
		boolean end = false;

		try {
			ois = new ObjectInputStream(new FileInputStream(persona));
			oos = new ObjectOutputStream(new FileOutputStream(aux));
			try {
				do {
					Persona p = (Persona) ois.readObject();
					if (p instanceof Cliente) {
						cliente.add((Cliente) p);
					}

					if (p instanceof Trabajador) {
						oos.writeObject(p);
					}
				} while (!end);
			} catch (EOFException e) {
				end = true;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			oos.close();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("UN ERROR FATAL HA OCURRIDO");
		}
		if (persona.delete()) {
			aux.renameTo(persona);
		}
	}

	public static void showWorkers(File persona) {
		ObjectInputStream ois;
		boolean end = false;

		try {
			ois = new ObjectInputStream(new FileInputStream(persona));
			try {
				do {
					Persona p = (Persona) ois.readObject();
					((Trabajador) p).visualizar();
				} while (!end);
			} catch (EOFException e) {
				end = true;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void testShowClientes(ArrayList<Cliente> c) {
		for (int i = 0; i < c.size(); i++) {
			((Cliente) c.get(i)).visualizar();
		}
	}

	public static void showClientsSortByName(ArrayList<Cliente> c) {
		Collections.sort(c);
		for (int i = 0; i < c.size(); i++) {
			((Cliente) c.get(i)).visualizar();
		}
	}

	public static void addTraining(ArrayList<Cliente> c) {
		String dni, training;
		int repetitionCount;
		LocalDate trainingDate;
		boolean found = false;

		System.out.println("Introduce el DNI del Cliente a buscar:");
		dni = Utilidades.introducirCadena();
		for (int i = 0; i < c.size() && !found; i++) {
			if (((Cliente) c.get(i)).getDni().equals(dni)) {
				found = true;
				System.out.println("Introduce el ejercicio:");
				training = Utilidades.introducirCadena();
				System.out.println("Introduce la fecha en el que el ejercicio se realizó: (DD/MM/AAAA)");
				trainingDate = Utilidades.leerFechaDMA();
				do {
					System.out.println("Introduce las repeticiones:");
					repetitionCount = Utilidades.leerInt();
					if (repetitionCount < 0) {
						System.err.println("El numero de repeticiones no puede ser negativo.");
					}
				} while (repetitionCount < 0);
				((Cliente) c.get(i)).getTrainings().put(training, new Entrenamiento(setTrainingCode((Cliente) c.get(i)),
						trainingDate, training, repetitionCount));
				System.out.println("El entrenamiento ha sido añadido correctamente.");
			}
		}

		if (!found) {
			System.err.println("El cliente no ha sido encontrado.");
		}
	}

	public static String setTrainingCode(Cliente c) {
		int num = 100;
		for (@SuppressWarnings("unused")
		Entrenamiento e : c.getTrainings().values()) {
			num++;
		}
		return "WOD-" + num;
	}

	public static void addWorker(File persona) {
		ObjectInputStream ois;
		MyObjectOutputStream moos;
		String dni = null, name, username, password, setCargo;
		Cargo cargo = null;
		boolean incorrectDNI = false, error = false, exists = false, end = false;

		do {
			incorrectDNI = false;
			try {
				System.out.println("Introduce el DNI del trabajador:");
				dni = Utilidades.introducirCadena();
				checkDNI(dni);
			} catch (IncorrectDNIException e) {
				e.getMessage();
				incorrectDNI = true;
			}
		} while (incorrectDNI);

		try {
			ois = new ObjectInputStream(new FileInputStream(persona));
			try {
				do {
					Persona p = (Persona) ois.readObject();
					if (p.getDni().equals(dni)) {
						exists = true;
						System.out.println("Ese trabajador ya existe.");
					}
				} while (!end || !exists);
			} catch (EOFException e) {
				end = true;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (!exists) {
			System.out.println("Introduce el nombre:");
			name = Utilidades.introducirCadena();
			System.out.println("Introduce el nombre de usuario:");
			username = Utilidades.introducirCadena();
			System.out.println("Introduce la contraseña:");
			password = Utilidades.introducirCadena();
			do {
				error = false;
				try {
					System.out.println("Introduce el cargo: (Monitor/Recepcionista)");
					setCargo = Utilidades.introducirCadena().toUpperCase();

					switch (setCargo) {

					case "MONITOR":
						cargo = Cargo.MONITOR;
						break;

					case "RECEPCIONISTA":
						cargo = Cargo.RECEPCIONISTA;
						break;

					default:
						throw new IllegalArgumentException(
								"El cargo introducido es invalido. Debe ser 'Monitor' o 'Recepcionista'.");
					}
				} catch (IllegalArgumentException e) {
					e.getMessage();
					error = true;
				}
			} while (error);

			try {
				moos = new MyObjectOutputStream(new FileOutputStream(persona, true));
				moos.writeObject(new Trabajador(dni, name, username, password, cargo));
				moos.close();
				System.out.println("El trabajador ha sido añadido correctamente.");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void checkDNI(String dni) throws IncorrectDNIException {
		Pattern modelo = Pattern.compile("\\d{8}[A-HJ-NP-TV-Z]");
		Matcher matcher = modelo.matcher(dni);

		if (!matcher.matches()) {
			throw new IncorrectDNIException("El formato del DNI es invalido.");
		}
	}

	public static void endProgram(File persona, ArrayList<Cliente> c) {
		MyObjectOutputStream moos;
		try {
			moos = new MyObjectOutputStream(new FileOutputStream(persona, true));
			for (int i = 0; i < c.size(); i++) {
				moos.writeObject(c.get(i));
			}
			moos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
