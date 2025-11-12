package if_Else_and_SwitchStuff;

import java.util.Scanner;

public class IfElseProject1 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int edad;

		System.out.println("¿Cuantos años tienes?");
		edad = teclado.nextInt();
		if (edad < 6) {
			System.out.println("Acceso no autorizado.");
			System.out.println("He llamado a tus padres.");
		} else if (edad < 18) {
			System.out.println("Acceso no autorizado.");
		} else {
			System.out.println("Bienvenido.");
			System.out.println("¿Como estas?");
		}
		teclado.close();
	}
}