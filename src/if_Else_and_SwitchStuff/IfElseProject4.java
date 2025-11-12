package if_Else_and_SwitchStuff;

import java.util.Scanner;

public class IfElseProject4 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int a, b;
		System.out.println("Introduce el primer numero:");
		a = teclado.nextInt();
		System.out.println("Intruduce el segundo numero:");
		b = teclado.nextInt();

		if (a > b) {
			System.out.println("El primer numero es mayor que el segundo.");
		} else if (a < b) {
			System.out.println("El segundo numero es mayor que el segundo.");
		} else {
			System.out.println("Los numeros son iguales.");

		}
		teclado.close();
	}
}