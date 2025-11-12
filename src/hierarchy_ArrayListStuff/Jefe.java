package hierarchy_ArrayListStuff;

public class Jefe extends Empleado {
	private static int plus= 250;
	private String nom_dep;
	public Jefe(String dni, String nom_empleado, int mes_entrada, int anio, double incremento, String nom_dep) {
		super(dni, nom_empleado, mes_entrada, anio, incremento);
		this.nom_dep = nom_dep;
	}
	public static int getPlus() {
		return plus;
	}
	public static void setPlus(int plus) {
		Jefe.plus = plus;
	}
	public String getNom_dep() {
		return nom_dep;
	}
	public void setNom_dep(String nom_dep) {
		this.nom_dep = nom_dep;
	}
	@Override
	public String toString() {
		return "Jefe [nom_dep=" + nom_dep + ", toString()=" + super.toString() + "]";
	}
	@Override
	public double calcularSueldoTotal() {
		return (super.calcularSueldoTotal()+plus);
	}
}