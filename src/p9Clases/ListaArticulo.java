package p9Clases;

import java.util.ArrayList;

public class ListaArticulo {
	private ArrayList<Articulo> list;

	public ListaArticulo() {
		this.list = new ArrayList<>();
	}

	public ArrayList<Articulo> getList() {
		return list;
	}

	public void setList(ArrayList<Articulo> list) {
		this.list = list;
	}

	public void fillData() {
		list.add(new Vino("a1", "Bilbao", Brand.RAMON_BILBAO, 8.5, 100, "Tinto", "Rioja", 1990, "Garnacha"));
		list.add(new Vino("a2", "Banda Azul", Brand.PATERNINA, 6.5, 75, "Tinto", "Rioja", 2001, "Garnacha"));
		list.add(new Vino("a3", "Ramon Bilbao", Brand.BODEGAS_BILBAO, 5.0, 30, "Tinto", "Rioja", 1997, "Garnacha"));
		list.add(new Refresco("a9", "Naranja", Brand.FANTA, 1.5, 64, "Cola", false, true, 50));
		list.add(new Refresco("a10", "Zumo piña", Brand.JUVER, 1.0, 40, "piña", true, false, 40));
		list.add(new Refresco("a11", "Zumo manzana", Brand.JUVER, 1.5, 64, "Cola", false, true, 35));
	}

	public ArrayList<Articulo> reponer() {
		ArrayList<Articulo> l = new ArrayList<>();
		for (Articulo a : this.list) {
			if (a.getStock() < 50) {
				l.add(a);
			}
		}
		return list;
	}

	public ArrayList<Articulo> masCaro() {
		ArrayList<Articulo> caro = new ArrayList<Articulo>();
		int c = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPrice() > c) {
				c = i;
			}
		}
		caro.add(list.get(c));
		return caro;
	}

	public int posArticulo(String code) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCode().equalsIgnoreCase(code)) {
				return i;
			}
		}
		return -1;
	}

	public ArrayList<Articulo> equivalentes(String code) {
		double price = precio(code);
		ArrayList<Articulo> equiv = new ArrayList<Articulo>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPrice() == price) {
				equiv.add(list.get(i));
			}
		}
		return equiv;
	}

	public double precio(String code) {
		double price = -1;
		for (int i = 0; i < this.list.size() && price == -1; i++) {
			if (this.list.get(i).getCode().equalsIgnoreCase(code)) {
				price = this.list.get(i).getPrice();
			}
		}
		return price;
	}
}
