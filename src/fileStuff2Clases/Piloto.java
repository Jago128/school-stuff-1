package fileStuff2Clases;

import java.util.ArrayList;

public class Piloto extends Staff {
	private static final long serialVersionUID = 1L;

	private ArrayList<Carrera> c;

	public Piloto(int codeEsc, String name, String country, ArrayList<Carrera> c) {
		super(codeEsc, name, country);
		this.c = c;
	}

	public ArrayList<Carrera> getC() {
		return c;
	}

	public void setC(ArrayList<Carrera> c) {
		this.c = c;
	}

	@Override
	public void visualizar() {
		System.out.println(super.toString() + " Carreras" + c + "]");
		for (Carrera c : c) {
			System.out.println(c.toString());
		}
	}
}
