package examLastModel;

import java.util.Map;

public interface MueblesTartangaDAO {

	public boolean searchEmp(Empleado e);

	public Empleado getEmpleado(String dni);

	public Map<Integer, Mueble> showMuebles();

	public boolean updatePriceMueble(double newPrice, int id);
}
