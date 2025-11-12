package hierarchy_ArrayListStuffClases;

public class PersonaP1 {
	protected String dni;
	protected String nombre;
	public static int contador = 0;

	public PersonaP1() {
		this.dni = "";
		this.nombre = "";
	}

	public PersonaP1(String d, String n) {
		this.dni = d;
		this.nombre = n;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void visualizar() {
		System.out.println("DNI: " + this.dni);
		System.out.println("Nombre: " + this.nombre);
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + "";
	}
}
