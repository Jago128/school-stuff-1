package p15Model;

import java.util.Map;

public interface Alumno_AsignaturaDAO {
	public boolean comprobarAsignatura(Asignatura a);

	public Map<String, Alumno> showAlumnos();

	public Map<Integer, Asignatura> showAsignaturas();

	public Map<Integer, Asignatura> showAsignaturasDNI(String dni);

	public boolean update(Asignatura a);

	public boolean delete(String nom);
}
