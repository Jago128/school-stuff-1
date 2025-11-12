package exam2Clases;

public class Trabajador extends Persona {
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private Cargo cargo;

	public Trabajador(String dni, String name, String username, String password, Cargo cargo) {
		super(dni, name);
		this.username = username;
		this.password = password;
		this.cargo = cargo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String user) {
		this.username = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public void visualizar() {
		System.out.println(super.toString());
		System.out.println("Nombre de usuario: " + this.username);
		System.out.println("Contraseña: " + this.password);
		System.out.println("Cargo: " + this.cargo);
	}
}
