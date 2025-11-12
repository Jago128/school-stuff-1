package objectStuffClasses;

public class Asignatura {

	private String name;
	private String course;
	private int students;
	private int Cfailed;

	public Asignatura(String n, String c) {
		this.name = n;
		this.course = c;
		this.students = 0;
		this.Cfailed = 0;
	}

	public Asignatura(String n, String c, int s, int f) {
		this.name = n;
		this.course = c;
		this.students = s;
		this.Cfailed = f;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getStudents() {
		return students;
	}

	public void setStudents(int students) {
		this.students = students;
	}

	public int getCfailed() {
		return Cfailed;
	}

	public void setCfailed(int cfailed) {
		Cfailed = cfailed;
	}

	@Override
	public String toString() {
		return "Asignatura [Nombre: " + name + ", Curso: " + course + ", Alumnos: " + students + ", Suspensos: "
				+ Cfailed + "]";
	}

	public double porcentajeAprobados() {
		return (obtenerNumeroAprobados() * 100) / this.students;
	}

	public int obtenerNumeroAprobados() {
		return this.students - this.Cfailed;
	}
}
