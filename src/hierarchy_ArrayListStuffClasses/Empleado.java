package hierarchy_ArrayListStuffClasses;

import java.time.LocalDate;

public class Empleado {

	protected static final String NOM_EMPRESA = "Electrica S.A";
	protected String dni;
	protected String nom_empleado;
	protected int mes_entrada;
	protected int anio;
	protected double incremento;
	protected static double sueldo = 1000;
	protected static int contador = 0;

	public Empleado(String dni, String nom_empleado, int mes_entrada, int anio, double incremento) {
		this.dni = dni;
		this.nom_empleado = nom_empleado;
		this.mes_entrada = mes_entrada;
		this.anio = anio;
		this.incremento = incremento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom_empleado() {
		return nom_empleado;
	}

	public void setNom_empleado(String nom_empleado) {
		this.nom_empleado = nom_empleado;
	}

	public int getMes_entrada() {
		return mes_entrada;
	}

	public void setMes_entrada(int mes_entrada) {
		this.mes_entrada = mes_entrada;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public double getIncremento() {
		return incremento;
	}

	public void setIncremento(double incremento) {
		this.incremento = incremento;
	}

	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nom_empleado=" + nom_empleado + ", mes_entrada=" + mes_entrada + ", anio="
				+ anio + ", incremento=" + incremento + ", Sueldo=" + sueldo + "]";
	}

	public double calcularSueldoTotal() {
		if ((LocalDate.now().getYear() - this.anio) >= 6) {
			return ((sueldo + (sueldo * this.incremento)) + 100);
		} else {
			return ((sueldo + (sueldo * this.incremento)));
		}
	}
}
