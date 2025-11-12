package fileStuffClases2;

import java.io.Serializable;

public class Ganadores implements Serializable, Comparable<Ganadores> {
	private static final long serialVersionUID = 1L;

	private String codeEsc;
	private String piloto;
	private String escuderia;
	private String carrera;

	public Ganadores(String code, String piloto, String escuderia, String carrera) {
		this.codeEsc = code;
		this.piloto = piloto;
		this.escuderia = escuderia;
		this.carrera = carrera;
	}

	public String getCodeEsc() {
		return codeEsc;
	}

	public void setCodeEsc(String code) {
		this.codeEsc = code;
	}

	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

	public String getEscuderia() {
		return escuderia;
	}

	public void setEscuderia(String escuderia) {
		this.escuderia = escuderia;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "Ganadores [Codigo de Escuderia: " + codeEsc + ", Piloto: " + piloto + ", Escuderia: " + escuderia
				+ ", Carrera: " + carrera + "]";
	}

	@Override
	public int compareTo(Ganadores o) {
		return this.carrera.compareTo(o.carrera);
	}
}
