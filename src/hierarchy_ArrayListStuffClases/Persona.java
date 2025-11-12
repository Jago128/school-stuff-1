package hierarchy_ArrayListStuffClases;

import java.time.LocalDate;

public class Persona {
	protected String name;
	protected LocalDate birthDate;

	public Persona(String n, LocalDate bD) {
		this.name = n;
		this.birthDate = bD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Persona [name=" + name + ", birthDate=" + birthDate + "]";
	}
}
