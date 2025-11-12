package examLastController;

import java.util.Map;

import examLastModel.*;
import examLastWindows.LoginWindow;

public class LoginController {
	MueblesTartangaDAO dao = new DBImplementation();

	public void launchWindow() {
		LoginWindow frame = new LoginWindow();
		frame.setVisible(true);
	}

	public boolean searchEmp(Empleado e) {
		return dao.searchEmp(e);
	}

	public Empleado getEmpleado(String dni) {
		return dao.getEmpleado(dni);
	}

	public Map<Integer, Mueble> showMuebles() {
		return dao.showMuebles();
	}

	public boolean updatePriceMueble(double newPrice, int id) {
		return dao.updatePriceMueble(newPrice, id);
	}
}
