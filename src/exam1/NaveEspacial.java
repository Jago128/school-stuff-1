package exam1;

public class NaveEspacial {
	private String name;
	private int creationYear;
	private int launchYear;
	private int capacity;
	private int necessaryCap;
	
	public NaveEspacial() {
		this.name="";
		this.creationYear=0;
		this.launchYear=0;
		this.capacity=0;
		this.necessaryCap=0;
	}
	
	public NaveEspacial(String n, int c, int l, int cap, int rq) {
		this.name=n;
		this.creationYear=c;
		this.launchYear=l;
		this.capacity=cap;
		this.necessaryCap=rq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCreationYear() {
		return creationYear;
	}

	public void setCreationYear(int creationYear) {
		this.creationYear = creationYear;
	}

	public int getLaunchYear() {
		return launchYear;
	}

	public void setLaunchYear(int launchYear) {
		this.launchYear = launchYear;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getNecessaryCap() {
		return necessaryCap;
	}

	public void setNecessaryCap(int necessaryCap) {
		this.necessaryCap = necessaryCap;
	}

	@Override
	public String toString() {
		return "Nave Espacial: "+name+", Año de Creacion: "+creationYear+", Año de Lanzamiento: "+launchYear+", Capacidad total: "+capacity+", Tripulantes Necesarios: "+necessaryCap+"";
	}
	
	public int calcularAntiguedad(int anioActual) {
		return anioActual-creationYear;
	}
	
	public boolean admitePasajeros() {
		int cap=capacity-necessaryCap;
		if (cap>0) {
			return true;
		}
		return false;
	}
	
}
