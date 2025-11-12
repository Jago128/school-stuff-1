package objectStuffClasses;

public class Persona {

	private String nombre;
	private String DNI;
	private int edad;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dni) {
		DNI = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Persona() {
		this.DNI = "";
		this.edad = 0;
		this.nombre = "";
	}

	public void mostrar() {
		System.out.println("Datos:");
		System.out.println(this.nombre);
		System.out.println(this.edad);
		System.out.println(this.DNI);
	}

	public boolean esMayordeEdad() {
		if (this.edad < 18) {
			return true;
		} else {
			return false;
		}
	}
}
