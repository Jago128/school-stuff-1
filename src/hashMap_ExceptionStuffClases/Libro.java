package hashMap_ExceptionStuffClases;

public class Libro extends Publicacion {
	private int numPage;

	public Libro(String code, String title, int year, int numPage) {
		super(code, title, year);
		this.numPage = numPage;
	}

	public int getNumPage() {
		return numPage;
	}

	public void setNumPage(int numPage) {
		this.numPage = numPage;
	}

	@Override
	public void visualizar() {
		System.out.println("Libro " + super.toString() + " Numero de paginas:" + numPage + "");
	}
}
