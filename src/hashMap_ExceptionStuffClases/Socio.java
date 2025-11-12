package hashMap_ExceptionStuffClases;

import java.util.ArrayList;

public class Socio {
	private String dni;
	private String name;
	private String surN;
	private int age;
	private ArrayList<Publicacion> p;

	public Socio(String dni, String name, String surN, int age, ArrayList<Publicacion> p) {
		this.dni = dni;
		this.name = name;
		this.surN = surN;
		this.age = age;
		this.p = p;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurN() {
		return surN;
	}

	public void setSurN(String surN) {
		this.surN = surN;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<Publicacion> getP() {
		return p;
	}

	public void setP(ArrayList<Publicacion> p) {
		this.p = p;
	}

	public void añadirPublicacion(Publicacion publ) {
		this.p.add(publ);
		System.out.println("La publicacion ha sido alquilada.");
	}

	public void print() {
		System.out.println("DNI: " + this.dni);
		System.out.println("Nombre: " + this.name);
		System.out.println("Apellido: " + this.surN);
		System.out.println("Edad: " + this.age);
		for (int i = 0; i < p.size(); i++) {
			if (this.p.get(i) instanceof Libro) {
				((Libro) this.p.get(i)).visualizar();
			}
			if (this.p.get(i) instanceof Revista) {
				((Revista) this.p.get(i)).visualizar();
			}
		}
	}
}
