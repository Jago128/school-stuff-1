package examLastModel;

public class Mueble {
	private int id;
	private String nombre;
	private double precio;

	public Mueble() {
		this.id = 0;
		this.nombre = "";
		this.precio = 0;
	}

	public Mueble(int id, String nombre, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Mueble [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
}
