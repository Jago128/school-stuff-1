package fileStuffClases2;

public class Mecanico extends Staff {
	private static final long serialVersionUID = 1L;

	private Puesto post;

	public Mecanico(int codeEsc, String name, String country, Puesto post) {
		super(codeEsc, name, country);
		this.post = post;
	}

	public Puesto getPost() {
		return post;
	}

	public void setPost(Puesto post) {
		this.post = post;
	}

	@Override
	public void visualizar() {
		System.out.println(super.toString() + " Puesto: " + post + "]");
	}
}
