package p9Clases;

import p9Exception.NegativeStockException;

public abstract class Articulo {
	protected String code;
	protected String name;
	protected Brand brand;
	protected double price;
	protected int stock;

	public Articulo() {
		this.code = "";
		this.name = "";
		this.brand = Brand.JUVER;
		this.price = 0;
		this.stock = 0;
	}

	public Articulo(String code, String name, Brand brand, double price, int stock) {
		this.code = code;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.stock = stock;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Codigo: " + code + ", Nombre: " + name + ", Marca: " + brand + ", Precio: " + price + ", Stock: "
				+ stock + "";
	}

	public int sumarStock(int stock) {

		if (stock <= 0) {
			System.out.println("ERROR. No se puede añadir una cantidad negativa o de 0");
			return this.stock;
		}
		return this.stock += stock;
	}

	public int quitarStock(int stock) throws NegativeStockException {
		int PHstock = this.stock;
		if (stock <= 0) {
			System.out.println("La cantidad a quitar no puede ser 0 o negativa");
		} else if (this.stock - stock < 0) {
			throw new NegativeStockException("La cantidad máxima que puede quitar es " + this.stock);
		} else {
			PHstock -= stock;
			System.out
					.println("Se han quitado " + stock + " unidades del stock correctamente. Stock actual: " + PHstock);
			return this.stock -= stock;
		}
		return this.stock;
	}

	public abstract void printCaracteristicas();

	public abstract boolean sano();
}
