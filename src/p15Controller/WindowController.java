package p15Controller;

import java.util.Map;

import p15Model.*;
import p15Windows.WindowButtons;

public class WindowController {
	Alumno_AsignaturaDAO dao = new DBImplementation();

	public void visualizarPantalla() {
		WindowButtons ven = new WindowButtons(this);
		ven.setVisible(true);
	}

	public boolean comprobarAsignatura(Asignatura a) {
		return dao.comprobarAsignatura(a);
	}

	public Map<String, Alumno> showAlumnos() {
		return dao.showAlumnos();
	}

	public Map<Integer, Asignatura> showAsignaturas() {
		return dao.showAsignaturas();
	}

	public Map<Integer, Asignatura> showAsignaturasDNI(String dni) {
		return dao.showAsignaturasDNI(dni);
	}

	public boolean update(Asignatura a) {
		return dao.update(a);
	}

	public boolean delete(String nom) {
		return dao.delete(nom);
	}
}
