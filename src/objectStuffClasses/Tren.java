package objectStuffClasses;

public class Tren {

	private String type;
	private String ref;
	private int occupiedS;
	private double km;
	private int durMin;

	public Tren(String t) {
		this.type = t;
		this.ref = "";
		this.km = 0;
		this.occupiedS = 0;
		this.durMin = 0;
	}

	public Tren(String t, String r, int o, int k, int d) {
		this.type = t;
		this.ref = r;
		this.km = k;
		this.occupiedS = o;
		this.durMin = d;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public int getOccupiedS() {
		return occupiedS;
	}

	public void setOccupiedS(int occupiedS) {
		this.occupiedS = occupiedS;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public int getDurMin() {
		return durMin;
	}

	public void setDurMin(int durMin) {
		this.durMin = durMin;
	}

	@Override
	public String toString() {
		return "Tren [Tipo: " + type + ", Referencia: " + ref + ", Asientos ocupados: " + occupiedS + ", KM: " + km
				+ ", Duracion (en Minutos): " + durMin + "]";
	}

	public boolean trenLleno() {
		if (this.occupiedS == 400) {
			return true;
		}
		
		return false;
	}

	public double obtenerVelocidadtotal() {
		return this.km / (this.durMin / 60);
	}
}
