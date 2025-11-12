package hashMap_ExceptionStuffClases;

public class Cuenta {
	private String dni;
	private String name;
	private double salary;

	public Cuenta(String dni, String name, double salary) {
		this.dni = dni;
		this.name = name;
		this.salary = salary;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Cuenta [dni=" + dni + ", name=" + name + ", salary=" + salary + "]";
	}
}
