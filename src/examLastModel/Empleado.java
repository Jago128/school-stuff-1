package examLastModel;

public class Empleado {
	private String dni;
	private String nombre;
	private String contrasena1;
	private String contrasena2;
	private String contrasena3;

	public Empleado() {
		this.dni = "";
		this.nombre = "";
		this.contrasena1 = "";
		this.contrasena2 = "";
		this.contrasena3 = "";
	}

	public Empleado(String dni, String nombre, String contrasena1, String contrasena2, String contrasena3) {
		this.dni = dni;
		this.nombre = nombre;
		this.contrasena1 = contrasena1;
		this.contrasena2 = contrasena2;
		this.contrasena3 = contrasena3;
	}

	public Empleado(String dni, String contrasena) {
		this.dni = dni;
		this.contrasena1 = contrasena;
		this.contrasena2 = contrasena;
		this.contrasena3 = contrasena;
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

	public String getContrasena1() {
		return contrasena1;
	}

	public void setContrasena1(String contrasena1) {
		this.contrasena1 = contrasena1;
	}

	public String getContrasena2() {
		return contrasena2;
	}

	public void setContrasena2(String contrasena2) {
		this.contrasena2 = contrasena2;
	}

	public String getContrasena3() {
		return contrasena3;
	}

	public void setContrasena3(String contrasena3) {
		this.contrasena3 = contrasena3;
	}

	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", contrasena1=" + contrasena1 + ", contrasena2="
				+ contrasena2 + ", contrasena3=" + contrasena3 + "]";
	}
}
