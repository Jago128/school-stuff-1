package examLastModel;

public class Vende {
	private String dni;
	private int id;
	private int cantidad;

	public Vende() {
		this.dni = "";
		this.id = 0;
		this.cantidad = 0;
	}

	public Vende(String dni, int id, int cantidad) {
		this.dni = dni;
		this.id = id;
		this.cantidad = cantidad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "vende [dni=" + dni + ", id=" + id + ", cantidad=" + cantidad + "]";
	}
}
