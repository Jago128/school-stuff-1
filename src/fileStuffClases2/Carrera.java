package fileStuffClases2;

public class Carrera {
	private int code;
	private String name;
	private boolean win;

	public Carrera(int code, String name, boolean win) {
		this.code = code;
		this.name = name;
		this.win = win;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean hasWon() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	@Override
	public String toString() {
		return "Carrera [Codigo: " + code + ", Nombre " + name + ", Ganador de la carrera: " + win + "]";
	}
}
