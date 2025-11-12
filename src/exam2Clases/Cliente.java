package exam2Clases;

import java.time.LocalDate;
import java.util.HashMap;

public class Cliente extends Persona implements Comparable<Cliente> {
	private static final long serialVersionUID = 1L;

	private LocalDate fecAlta;
	private HashMap<String, Entrenamiento> trainings;

	public Cliente(String dni, String name, LocalDate fecAlta, HashMap<String, Entrenamiento> trainings) {
		super(dni, name);
		this.fecAlta = fecAlta;
		this.trainings = trainings;
	}

	public LocalDate getFecAlta() {
		return fecAlta;
	}

	public void setFecAlta(LocalDate fecAlta) {
		this.fecAlta = fecAlta;
	}

	public HashMap<String, Entrenamiento> getTrainings() {
		return trainings;
	}

	public void setTrainings(HashMap<String, Entrenamiento> trainings) {
		this.trainings = trainings;
	}

	@Override
	public void visualizar() {
		System.out.println(super.toString());
		System.out.println("Fecha de alta: " + this.fecAlta);
		System.out.println("Entrenamientos:");
		for (int i = 0; i < this.trainings.size(); i++) {
			System.out.println(this.trainings.toString());
		}
	}

	@Override
	public int compareTo(Cliente o) {
		return o.getName().compareTo(this.name);
	}
}
