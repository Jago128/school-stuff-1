package hashMap_ExceptionStuffClases;

import java.util.ArrayList;

public class Catalogo {
	private ArrayList<Publicacion> list;

	public Catalogo(ArrayList<Publicacion> list) {
		this.list = list;
	}

	public ArrayList<Publicacion> getList() {
		return list;
	}

	public void setList(ArrayList<Publicacion> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Catalogo [list=" + list + "]";
	}

	public void fillData() {
		this.list.add(new Libro("L001", "Java Programming", 2021, 450));
		this.list.add(new Libro("L002", "Data Structures", 2020, 380));
		this.list.add(new Libro("L003", "Operating Systems", 2019, 520));
		this.list.add(new Libro("L004", "Database Systems", 2022, 600));
		this.list.add(new Libro("L005", "Artificial Intelligence", 2023, 700));

		this.list.add(new Revista("R001", "Tech Monthly", 2021, 12));
		this.list.add(new Revista("R002", "Science Weekly", 2023, 52));
		this.list.add(new Revista("R003", "History Digest", 2020, 6));
		this.list.add(new Revista("R004", "Health & Wellness", 2022, 4));
		this.list.add(new Revista("R005", "Art and Culture", 2023, 10));
	}

	public int posicionPublicacion(String code) {
		for (int i = 0; i < this.list.size(); i++) {
			if (this.list.get(i).getCode().equalsIgnoreCase(code)) {
				return i;
			}
		}
		
		return -1;
	}
}
