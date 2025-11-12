package if_Else_and_SwitchStuff;

import java.util.Scanner;

public class IfElseProject2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		double cant€;

		System.out.print("Introduce una cantidad de euros: ");
		cant€ = teclado.nextDouble();
		if (cant€ < 20000) {
			System.out.println("El IVA es de 7%.");
		} else {
			System.out.println("El IVA es de 16%.");
		}
		teclado.close();
	}
}