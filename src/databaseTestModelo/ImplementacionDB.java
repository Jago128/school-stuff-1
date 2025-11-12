package databaseTestModelo;

import java.sql.*;
import java.util.*;

public class ImplementacionDB {
	private Connection con;
	private PreparedStatement stmt;
	private ResourceBundle configFile;
	
	@SuppressWarnings("unused")
	private String driverDB;
	private String urlDB;
	private String userDB;
	private String passwordDB;

	final String SQL = "SELECT * FROM usuario WHERE nombre=? AND contraseña=?";
	final String INSERTUSER = "INSERT INTO usuario VALUES (?,?)";
	final String UPDATEUSER = "UPDATE usuario SET password=? WHERE nombre=?";
	final String DELETEUSER = "DELETE FROM usuario WHERE nombre=?";
	final String SHOWALL = "SELECT * FROM usuario";

	public ImplementacionDB() {
		this.configFile = ResourceBundle.getBundle("modelo.configClase");
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

	public boolean comprobarUsuario(Usuario user) {
		boolean existe = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQL);
			stmt.setString(1, user.getNombre());
			stmt.setString(2, user.getContraseña());
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

	public boolean insert(Usuario user) {
		boolean check = false;

		this.openConnection();
		if (!comprobarUsuario(user)) {
			try {
				stmt = con.prepareStatement(INSERTUSER);
				stmt.setString(1, user.getNombre());
				stmt.setString(2, user.getContraseña());
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al verificar credenciales: " + e.getMessage());
			}
		}
		return check;
	}

	public boolean update(Usuario user) {
		boolean check = false;

		try {
			stmt = con.prepareStatement(UPDATEUSER);
			stmt.setString(1, user.getContraseña());
			stmt.setString(2, user.getNombre());
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

	public boolean delete(String nom) {
		boolean check = false;

		try {
			stmt = con.prepareStatement(DELETEUSER);
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

	public Map<String, Usuario> consultaUsuarios() {
		Map<String, Usuario> users = new TreeMap<>();
		Usuario user;
		ResultSet rs = null;
		this.openConnection();
		try {
			stmt = con.prepareStatement(SHOWALL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				user = new Usuario();
				user.setNombre(rs.getString("nombre"));
				user.setContraseña("contraseña");
				users.put(user.getNombre(), user);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
