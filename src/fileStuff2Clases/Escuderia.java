package fileStuff2Clases;

import java.io.Serializable;

public class Escuderia implements Serializable {
	private static final long serialVersionUID = 1L;

	private int code;
	private String name;

	public Escuderia(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCod(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Escuderia [Codigo: " + code + ", Nombre: " + name + "]";
	}

}
