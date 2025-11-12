package p15Model;

public class Asignatura {
	private int id;
	private String nom;
	private int creditos;
	private String dni;

	public Asignatura() {
		this.id = 0;
		this.nom = "";
		this.creditos = 0;
		this.dni = "";
	}

	public Asignatura(int id, String nom, int creditos, String dni) {
		this.id = id;
		this.nom = nom;
		this.creditos = creditos;
		this.dni = dni;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nom=" + nom + ", creditos=" + creditos + "]";
	}
}
