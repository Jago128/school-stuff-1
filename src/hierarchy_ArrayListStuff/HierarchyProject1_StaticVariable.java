package hierarchy_ArrayListStuff;

import hierarchy_ArrayListStuffClases.Cliente;
import hierarchy_ArrayListStuffClases.PersonaP1;
import hierarchy_ArrayListStuffClases.Trabajador;

public class HierarchyProject1_StaticVariable {

	public static void main(String[] args) {
		PersonaP1 a[] = new PersonaP1[3];
		PersonaP1 p1 = new PersonaP1("1234", "Alex");
		Cliente c1 = new Cliente("4321", "Igor", 19);
		Trabajador t1 = new Trabajador("6547", "Alex", 20000);
		a[0] = p1;
		a[1] = c1;
		a[2] = t1;

		PersonaP1.contador = PersonaP1.contador + 3;
		for (int i = 0; i < PersonaP1.contador; i++) {
			if (a[i] instanceof Cliente) {
				a[i].visualizar();
			}
		}
	}
}
