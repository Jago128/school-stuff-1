package exam2Clases;

import java.io.Serializable;

public abstract class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	protected String dni;
	protected String name;

	public Persona(String dni, String name) {
		this.dni = dni;
		this.name = name;
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

	@Override
	public String toString() {
		return "\nDNI: " + dni + "\n Nombre: " + name + "";
	}

	public abstract void visualizar();
}
