package exam1;
import java.time.LocalDate;
import java.util.Scanner;
public class Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NaveEspacial[] n=new NaveEspacial[50];
		Scanner sc= new Scanner(System.in);
		/*n[0]=new NaveEspacial("Apollo",2002,2003,10,9);
		 *n[1]=new NaveEspacial("e",2004,2004,15,15);
		 */
		int menu, count=0;
		do {
			menu=menu(sc);
			switch (menu) {

			case 1:
				count=add(sc,n,count);
				break;

			case 2:
				if (count>0) {
					showHigherAge(sc,n,count);
				} else {
					System.out.println("No hay naves espaciales introducidas");
				}
				break;

			case 3:
				if (count>0) {
					orderLaunchD(sc,n,count);
				} else {
					System.out.println("No hay naves espaciales introducidas");
				}
				break;

			case 4:
				if (count>0) {
					modifyAdmitCap(sc,n,count);
				} else {
					System.out.println("No hay naves espaciales introducidas");
				}
				break;

			case 5:
				if (count>0) {
					show(n,count);
				} else {
					System.out.println("No hay naves espaciales introducidas");
				}
				break;

			case 6:
				if (count>0) {
					count=delete(sc,n,count);
				} else {
					System.out.println("No hay naves espaciales introducidas");
				}
				break;

			case 7:
				System.out.println("Adios!");
				break;

			default:
				System.out.println("ERROR. Introduzca una opcion valida.");
			}
		} while (menu!=7);

		sc.close();
	}

	public static int menu(Scanner sc) {
		int menu;
		System.out.println("1. Añadir naves espaciales");
		System.out.println("2. Mostrar naves con antiguedad mayor que la introducida");
		System.out.println("3. Ordenar naves por año de lanzamiento");
		System.out.println("4. Modificar Capacidad Total de naves que admitan pasajeros");
		System.out.println("5. Mostrar todas las naves espaciales");
		System.out.println("6. Eliminar una nave espacial");
		System.out.println("7. Salir");
		menu=sc.nextInt();
		return menu;
	}

	public static int searchName(String name, NaveEspacial[] n, int count) {
		for (int i=0;i<count;i++) {
			if (name.equalsIgnoreCase(n[i].getName())) {
				return i;
			}
		}
		return -1;
	}

	public static int add(Scanner sc, NaveEspacial[] n, int count) {
		String next="";
		boolean cont=false;
		String name;
		int launchD, creationD, cap, necessaryCap;
		for (int i=0;i<n.length&&!cont;i++) {
			if (count>n.length-1) {
				System.out.println("No se pueden añadir mas naves espaciales en el momento");
				cont=true;
			} else {
				System.out.println("Introduzca el nombre de la nave espacial:");
				name=sc.next();
				if (searchName(name,n,count)==-1) {
					do {
						System.out.println("Introduzca el año de creación:");
						creationD=sc.nextInt();
						System.out.println("Introduzca el año de lanzamiento:");
						launchD=sc.nextInt();
						if (launchD<creationD) {
							System.out.println("El año de lanzamiento no puede ser anterior a el de lanzamiento:");
						}
					} while (launchD<creationD);
					do {
						System.out.println("Introduzca la capacidad total de personas:");
						cap=sc.nextInt();
						System.out.println("Introduzca la capacidad necesaria de personas:");
						necessaryCap=sc.nextInt();
						if (necessaryCap>cap) {
							System.out.println("No se puede tener una capacidad necesaria mas alta que la capacidad normal.");
						}
					} while (necessaryCap>cap);
					NaveEspacial nI= new NaveEspacial(name, creationD, launchD, cap, necessaryCap);
					n[i]=nI;
					count++;
				} else {
					System.out.println("Ya hay una nave espacial con ese nombre.");
				}
				do {
					System.out.println("Quiere acabar de añadir naves espaciales? (SI/NO)");
					next=sc.next();
					if (!next.equalsIgnoreCase("NO")&&!next.equalsIgnoreCase("SI")) {
						System.out.println("ERROR. Introduzca una opcion valida.");
					}
				} while (!next.equalsIgnoreCase("NO")&&!next.equalsIgnoreCase("SI"));
				if (next.equalsIgnoreCase("SI")) {
					cont=true;
				}
			}
		}
		return count;
	}

	public static void showHigherAge(Scanner sc, NaveEspacial[] n, int count) {
		boolean found=false;
		System.out.println("Introduzca la antiguedad minima:");
		int age=sc.nextInt();
		int year=LocalDate.now().getYear();
		for (int i=0;i<count;i++) {
			if (n[i].calcularAntiguedad(year)>=age) {
				System.out.println(n[i].toString());
				found=true;
			}
		}
		if (!found) {
			System.out.println("No se han encontrado naves con antiguedad mayor a la introducida.");
		}

	}

	public static void orderLaunchD(Scanner sc, NaveEspacial[] n, int count) {
		NaveEspacial temp= new NaveEspacial("",0,0,0,0);
		for (int i=0;i<count;i++) {
			for (int j=0;j<count-1-i;j++) {
				if (n[j].getLaunchYear()<n[j+1].getLaunchYear()) {
					temp=n[j+1];
					n[j+1]=n[j];
					n[j]=temp;
				}
			}
		}
		show(n,count);
	}

	public static void modifyAdmitCap(Scanner sc, NaveEspacial[] n, int count) {
		boolean check=false;
		String next="";
		int newCap;
		for (int i=0;i<count;i++) {
			if (n[i].admitePasajeros()) {
				check=true;
				System.out.println(n[i].toString());
				do {
					System.out.println("¿Quiere modificar la capacidad total? (SI/NO)");
					next=sc.next();
					if (!next.equalsIgnoreCase("NO")&&!next.equalsIgnoreCase("SI")) {
						System.out.println("ERROR. Introduzca una opcion valida.");
					}
				} while (!next.equalsIgnoreCase("NO")&&!next.equalsIgnoreCase("SI"));
				if (next.equalsIgnoreCase("SI")) {
					do {
						System.out.println("Introduce la nueva capacidad:");
						newCap=sc.nextInt();
						if (newCap<n[i].getNecessaryCap()) {
							System.out.println("ERROR. La capacidad no puede ser menor que la capacidad total. Introduzcalo de nuevo.");
						}
					} while (newCap<n[i].getNecessaryCap());
					n[i].setCapacity(newCap);
					System.out.println("La capacidad ha sido modificada correctamente.");
				}
			}
		}
		if (!check) {
			System.out.println("No hay naves donde se pueda modificar la capacidad total.");
		}
	}

	public static void show(NaveEspacial[] n, int count) {
		for (int i=0;i<count;i++) {
			System.out.println(n[i].toString());
		}
	}

	public static int delete(Scanner sc, NaveEspacial[] n, int count) {
		System.out.println("Introduce el nombre de la nave para eliminar:");
		String name=sc.next();
		int pos=searchName(name,n,count);
		if (pos!=-1) {
			n[pos]=null;
			for (int i=1;i<n.length;i++) {
				n[i-1]=n[i];
			}
			n[n.length-1]=null;
			count--;
			System.out.println("Nave eliminada correctamente.");
		} else {
			System.out.println("No hay naves con el nombre introducido.");
		}
		return count;
	}
}
