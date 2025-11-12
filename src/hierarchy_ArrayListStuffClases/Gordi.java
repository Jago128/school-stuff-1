package hierarchy_ArrayListStuffClases;

import java.time.LocalDate;
import java.util.ArrayList;

import utilidades.Utilidades;

public class Gordi extends Persona {
	private String codeG;
	private double height;
	private ArrayList<ParejaMedicion> m = new ArrayList<ParejaMedicion>();

	public Gordi(String n, LocalDate bD, double h, ArrayList<ParejaMedicion> m) {
		super(n, bD);
		this.codeG = generateCodeG(n, bD);
		this.height = h;
		this.m = m;
	}

	public String getCodeG() {
		return codeG;
	}

	public void setCodeG(String codeG) {
		this.codeG = codeG;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public ArrayList<ParejaMedicion> getM() {
		return m;
	}

	public void setM(ArrayList<ParejaMedicion> m) {
		this.m = m;
	}

	@Override
	public String toString() {
		return "Gordi [codeG=" + codeG + ", height=" + height + ", toString()=" + super.toString() + "]";
	}

	public String generateCodeG(String name, LocalDate birthDate) {
		String letters = name.substring(0, 2).toUpperCase();
		String year = Utilidades.fechaToString(birthDate).substring(8, 10);
		return letters + "-" + year;
	}
}
