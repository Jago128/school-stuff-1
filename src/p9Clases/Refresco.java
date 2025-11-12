package p9Clases;

public class Refresco extends Articulo {
	private String flavour;
	private boolean juice;
	private boolean gas;
	private int sugar;

	public Refresco() {
		super();
		this.flavour = "";
		this.juice = false;
		this.gas = false;
		this.sugar = 0;
	}

	public Refresco(String c, String n, Brand b, double p, int s, String f, boolean j, boolean g, int sugar) {
		super(c, n, b, p, s);
		this.flavour = f;
		this.juice = j;
		this.gas = g;
		this.sugar = sugar;
	}

	public String getFlavour() {
		return flavour;
	}

	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}

	public boolean isJuice() {
		return juice;
	}

	public void setJuice(boolean juice) {
		this.juice = juice;
	}

	public boolean isGas() {
		return gas;
	}

	public void setGas(boolean gas) {
		this.gas = gas;
	}

	public int getSugar() {
		return sugar;
	}

	public void setSugar(int sugar) {
		this.sugar = sugar;
	}

	@Override
	public String toString() {
		return "Refresco [" + super.toString() + " Sabor: " + flavour + ", Zumo: " + juice + ", Gas: " + gas
				+ ", Azucar: " + sugar + "]";
	}

	@Override
	public void printCaracteristicas() {
		System.out.println(this.toString());
	}

	@Override
	public boolean sano() {
		return this.sugar < 25;
	}
}
