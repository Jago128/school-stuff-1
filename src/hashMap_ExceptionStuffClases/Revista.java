package hashMap_ExceptionStuffClases;

public class Revista extends Publicacion {
	private int num;

	public Revista(String code, String title, int year, int num) {
		super(code, title, year);
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public void visualizar() {
		System.out.println("Revista " + super.toString() + ", Numero=" + num + "");
	}
}
