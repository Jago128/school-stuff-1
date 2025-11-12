package p15Model;

public class Alumno {
	private String dni;
	private String nom;
	private int edad;

	public Alumno(String dni, String nom, int edad) {
		this.dni = dni;
		this.nom = nom;
		this.edad = edad;
	}

	public Alumno() {
		this.dni = "";
		this.nom = "";
		this.edad = 0;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nom=" + nom + ", edad=" + edad + "]";
	}
}
