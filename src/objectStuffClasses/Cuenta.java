package objectStuffClasses;

public class Cuenta {

	private String title;
	private double cant;

	public Cuenta() {
		this.title = "";
		this.cant = 0;
	}

	public Cuenta(String t) {
		this.title = t;
		this.cant = 0;
	}

	public Cuenta(String t, double c) {
		this.cant = c;
		this.title = t;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getCant() {
		return cant;
	}

	public void setCant(double cant) {
		this.cant = cant;
	}

	@Override
	public String toString() {
		return "Cuenta: [Nombre=" + title + ", Cantidad=" + cant + "]";
	}

	public void ingresar(double add) {
		if (add > 0) {
			this.cant = this.cant + add;
		}
	}

	public void retirar(double remove) {
		this.cant = this.cant - remove;
		if (this.cant < 0) {
			this.cant = 0;
		}
	}
}
