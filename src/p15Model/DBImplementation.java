package p15Model;

import java.sql.*;
import java.util.*;

public class DBImplementation implements Alumno_AsignaturaDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResourceBundle configFile;
	@SuppressWarnings("unused")
	private String driverDB;
	private String urlDB;
	private String userDB;
	private String passwordDB;

	final String SHOWALUMNOS = "SELECT * FROM alumno";
	final String SHOWASIGNATURAS = "SELECT * FROM asignatura WHERE DNI=?";
	final String INSERTASIGNATURA = "INSERT INTO asignatura VALUES (?,?,?,?)";
	final String CHECK = "SELECT * FROM asignatura WHERE id=?";
	final String UPDATECREDITOSASIGNATURA = "UPDATE asignatura SET creditos=? WHERE id=?";
	final String DELETEASIGNATURA = "DELETE FROM asignatura WHERE nombre=?";

	public DBImplementation() {
		this.configFile = ResourceBundle.getBundle("model.classConfig");
		this.driverDB = this.configFile.getString("Driver");
		this.urlDB = this.configFile.getString("Conn");
		this.userDB = this.configFile.getString("DBUser");
		this.passwordDB = this.configFile.getString("DBPass");
	}

	private void openConnection() {
		try {
			con = DriverManager.getConnection(urlDB, this.userDB, this.passwordDB);
		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la base de datos.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean comprobarAsignatura(Asignatura a) {
		boolean existe = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(CHECK);
			stmt.setInt(1, a.getId());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				existe = true;
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al verificar credenciales: " + e.getMessage());
		}
		return existe;
	}

	@Override
	public Map<String, Alumno> showAlumnos() {
		Map<String, Alumno> alumnos = new TreeMap<>();
		Alumno a;
		ResultSet rs = null;
		this.openConnection();
		try {
			stmt = con.prepareStatement(SHOWALUMNOS);
			rs = stmt.executeQuery();
			while (rs.next()) {
				a = new Alumno();
				a.setDni("dni");
				a.setNom("nom");
				a.setEdad(rs.getInt("edad"));
				alumnos.put(a.getDni(), a);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}

	@Override
	public Map<Integer, Asignatura> showAsignaturas() {
		Map<Integer, Asignatura> alumnos = new TreeMap<>();
		Asignatura a;
		ResultSet rs = null;
		this.openConnection();
		try {
			stmt = con.prepareStatement(SHOWASIGNATURAS);
			rs = stmt.executeQuery();
			while (rs.next()) {
				a = new Asignatura();
				a.setId(rs.getInt("id"));
				a.setNom("nom");
				a.setCreditos(rs.getInt("creditos"));
				a.setDni("dni");
				alumnos.put(a.getId(), a);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}

	@Override
	public Map<Integer, Asignatura> showAsignaturasDNI(String dni) {
		Map<Integer, Asignatura> alumnos = new TreeMap<>();
		Asignatura a;
		ResultSet rs = null;
		this.openConnection();
		try {
			stmt = con.prepareStatement(SHOWASIGNATURAS);
			stmt.setString(1, dni);
			rs = stmt.executeQuery();
			while (rs.next()) {
				a = new Asignatura();
				a.setId(rs.getInt("id"));
				a.setNom("nom");
				a.setCreditos(rs.getInt("creditos"));
				a.setDni("dni");
				alumnos.put(a.getId(), a);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}

	@Override
	public boolean update(Asignatura a) {
		boolean check = false;

		try {
			stmt = con.prepareStatement(UPDATECREDITOSASIGNATURA);
			stmt.setInt(1, a.getCreditos());
			stmt.setInt(2, a.getId());
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean delete(String nom) {
		boolean check = false;

		try {
			stmt = con.prepareStatement(DELETEASIGNATURA);
			stmt.setString(1, nom);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
}
