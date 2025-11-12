package hashMap_ExceptionStuffClases;

public abstract class Publicacion {
	protected String code;
	protected String title;
	protected int year;
	protected Tipo type;

	public Publicacion(String code, String title, int year) {
		this.code = code;
		this.title = title;
		this.year = year;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Publicacion [Codigo=" + code + ", Titulo=" + title + ", Año=" + year + "]";
	}

	public abstract void visualizar();
}
