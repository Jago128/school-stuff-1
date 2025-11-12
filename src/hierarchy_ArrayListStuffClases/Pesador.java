package hierarchy_ArrayListStuffClases;

import java.time.LocalDate;

public class Pesador extends Persona {
	private LocalDate joinDate;

	public Pesador(String n, LocalDate bD, LocalDate jD) {
		super(n, bD);
		this.joinDate = jD;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "Pescador [joinDate=" + joinDate + ", toString()=" + super.toString() + "]";
	}
}
