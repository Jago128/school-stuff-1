package hierarchy_ArrayListStuff;

import hierarchy_ArrayListStuffClasses.*;

public class HierarchyProject1_StaticVariable {

	public static void main(String[] args) {
		Persona a[] = new Persona[3];
		Persona p1 = new Persona("1234", "Alex");
		Cliente c1 = new Cliente("4321", "Igor", 19);
		Trabajador t1 = new Trabajador("6547", "Alex", 20000);
		a[0] = p1;
		a[1] = c1;
		a[2] = t1;
		Persona.contador = Persona.contador + a.length;
		
		for (int i = 0; i < Persona.contador; i++) {
			if (a[i] instanceof Cliente) {
				a[i].visualizar();
			}
		}
	}
}
