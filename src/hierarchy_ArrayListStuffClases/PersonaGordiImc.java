package hierarchy_ArrayListStuffClases;

public class PersonaGordiImc implements Comparable<PersonaGordiImc> {
	private String classif;
	private int num;

	public PersonaGordiImc() {
		this.classif = "";
		this.num = 0;
	}

	public PersonaGordiImc(String c, int n) {
		this.classif = c;
		this.num = n;
	}

	public String getClassif() {
		return classif;
	}

	public void setClasificacion(String clasificacion) {
		this.classif = clasificacion;
	}

	public int getNumero() {
		return num;
	}

	public void setNumero(int numero) {
		this.num = numero;
	}

	@Override
	public String toString() {
		return "Gordis {Clasificación: " + classif + ", Numero: " + num + "}";
	}

	@Override
	public int compareTo(PersonaGordiImc o) {
		return Integer.compare(this.num, o.getNumero());
	}
}
