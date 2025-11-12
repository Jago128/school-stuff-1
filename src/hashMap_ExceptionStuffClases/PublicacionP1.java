package hashMap_ExceptionStuffClases;

public class PublicacionP1 {
	private int id;
	private String name;
	private Tipo type;

	public PublicacionP1(int id, String name, Tipo type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Tipo getType() {
		return type;
	}

	public void setType(Tipo type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Publicacion [id=" + id + ", name=" + name + "]";
	}
}
