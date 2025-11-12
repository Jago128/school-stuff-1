package exam2Clases;

import java.io.Serializable;
import java.time.LocalDate;

public class Entrenamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	private String code;
	private LocalDate trainingSessionDate;
	private String name;
	private int repetitionCount;

	public Entrenamiento(String code, LocalDate trainingSessionDate, String name, int repetitionCount) {
		this.code = code;
		this.trainingSessionDate = trainingSessionDate;
		this.name = name;
		this.repetitionCount = repetitionCount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDate getTrainingSessionDate() {
		return trainingSessionDate;
	}

	public void setTrainingSessionDate(LocalDate trainingSessionDate) {
		this.trainingSessionDate = trainingSessionDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRepetitionCount() {
		return repetitionCount;
	}

	public void setRepetitionCount(int repetitionCount) {
		this.repetitionCount = repetitionCount;
	}

	@Override
	public String toString() {
		return "\n[Codigo: " + code + ", Fecha que se realizó: " + trainingSessionDate + ", Nombre: " + name
				+ ", Número de repeticiones: " + repetitionCount + "]";
	}
}
