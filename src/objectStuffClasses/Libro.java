package objectStuffClasses;

public class Libro {
	private String ISBN;
	private String title;
	private String author;
	private int sold;
	private double price;

	public Libro() {
		this.ISBN = "";
		this.title = "";
		this.author = "";
		this.sold = 0;
		this.price = 0;
	}

	public Libro(String t) {
		this.ISBN = "";
		this.title = t;
		this.author = "";
		this.sold = 0;
		this.price = 0;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "El libro con el título " + title + " e ISBN " + ISBN + ", creado por el autor " + author
				+ " ha vendido " + sold + " ejemplares a un precio de " + price + "€";
	}

	public boolean esSuperVentas() {
		if (this.sold > 18000) {
			return true;
		}
		
		return false;
	}

	public double obtenerBeneficioTotal() {
		return (this.price * this.sold) * 1.04;
	}
}
