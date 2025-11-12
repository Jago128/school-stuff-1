package hierarchy_ArrayListStuffClases;

import java.time.LocalDate;

public class ParejaMedicion {
	private LocalDate date;
	private double weight;

	public ParejaMedicion(LocalDate d, double w) {
		this.date = d;
		this.weight = w;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "ParejaMedicion [date=" + date + ", weight=" + weight + "]";
	}
}
