package fileStuffClases2;

import java.io.Serializable;

public abstract class Staff implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int codeEsc;
	protected String name;
	protected String country;

	public Staff(int codeEsc, String name, String country) {
		this.codeEsc = codeEsc;
		this.name = name;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getCodeEsc() {
		return codeEsc;
	}

	public void setCodeEsc(int codeEsc) {
		this.codeEsc = codeEsc;
	}

	@Override
	public String toString() {
		return "Staff [Nombre: " + name + ", Pais: " + country + ", Codigo de Escuderia:" + codeEsc;
	}

	public abstract void visualizar();
}
