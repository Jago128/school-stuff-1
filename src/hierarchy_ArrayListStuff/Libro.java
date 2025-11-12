package hierarchy_ArrayListStuff;
import java.time.LocalDate;

public class Libro extends Publicacion {
	private String ISBN;
	private boolean prized;
	
	public Libro(LocalDate d, String t, String i, boolean p) {
		super(d,t);
		this.ISBN=i;
		this.prized=p;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	public boolean isPrized() {
		return prized;
	}

	public void setPrized(boolean prized) {
		this.prized = prized;
	}

	@Override
	public String toString() {
		return "Libro [ISBN=" + ISBN + ", prized=" + prized + ", toString()=" + super.toString() + "]";
	}
}