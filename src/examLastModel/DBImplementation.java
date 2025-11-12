package examLastModel;

import java.sql.*;
import java.util.*;

public class DBImplementation implements MueblesTartangaDAO {
	private Connection con;
	private PreparedStatement stmt;

	private ResourceBundle configFile;
	@SuppressWarnings("unused")
	private String driverBD;
	private String urlBD;
	private String userBD;
	private String passwordBD;

	final String SEARCHEMP = "SELECT * FROM EMPLEADO WHERE DNI=? AND (contrasena1=? OR contrasena2=? OR contrasena3=?)";
	final String GETEMPLEADO = "SELECT * FROM EMPLEADO WHERE DNI=?";
	final String GETMUEBLES = "SELECT * FROM MUEBLE";
	final String UPDATEPRICE = "UPDATE MUEBLE SET precio=? WHERE id=?";

	public DBImplementation() {
		this.configFile = ResourceBundle.getBundle("model.classConfig");
		this.driverBD = this.configFile.getString("Driver");
		this.urlBD = this.configFile.getString("Conn");
		this.userBD = this.configFile.getString("DBUser");
		this.passwordBD = this.configFile.getString("DBPass");
	}

	private void openConnection() {
		try {
			con = DriverManager.getConnection(urlBD, this.userBD, this.passwordBD);
		} catch (SQLException e) {
			System.out.println("Error when attempting to open the DB.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean searchEmp(Empleado emp) {
		boolean exists = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SEARCHEMP);
			stmt.setString(1, emp.getDni());
			stmt.setString(2, emp.getContrasena1());
			stmt.setString(3, emp.getContrasena2());
			stmt.setString(4, emp.getContrasena3());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				exists = true;
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exists;
	}

	@Override
	public Empleado getEmpleado(String dni) {
		Empleado emp = new Empleado();

		this.openConnection();
		try {
			stmt = con.prepareStatement(GETEMPLEADO);
			stmt.setString(1, dni);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				emp.setDni(rs.getString("dni"));
				emp.setNombre(rs.getString("nombre"));
				emp.setContrasena1(rs.getString("contrasena1"));
				emp.setContrasena2(rs.getString("contrasena2"));
				emp.setContrasena3(rs.getString("contrasena3"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public Map<Integer, Mueble> showMuebles() {
		Map<Integer, Mueble> mu = new TreeMap<>();
		this.openConnection();
		try {
			stmt = con.prepareStatement(GETMUEBLES);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Mueble m = new Mueble();
				m.setId(rs.getInt("id"));
				m.setNombre(rs.getString("nombre"));
				m.setPrecio(rs.getDouble("precio"));
				mu.put(m.getId(), m);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mu;
	}

	@Override
	public boolean updatePriceMueble(double newPrice, int id) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(UPDATEPRICE);
			stmt.setDouble(1, newPrice);
			stmt.setInt(2, id);
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
