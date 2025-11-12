package hierarchy_ArrayListStuffClases;

import java.util.ArrayList;

public class Profesor {
	private String email;
	private String name;
	private String dept;
	private ArrayList<Publicacion> p;

	public Profesor(String e, String n, String d, ArrayList<Publicacion> p) {
		this.email = e;
		this.name = n;
		this.dept = d;
		this.p = p;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public ArrayList<Publicacion> getP() {
		return p;
	}

	public void setP(ArrayList<Publicacion> p) {
		this.p = p;
	}

	@Override
	public String toString() {
		return "Profesor [email=" + email + ", name=" + name + ", dept=" + dept + ", Publicacion=" + p + "]";
	}
}
