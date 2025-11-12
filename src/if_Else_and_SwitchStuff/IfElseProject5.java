package if_Else_and_SwitchStuff;

import java.util.Scanner;

public class IfElseProject5 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		double sueldo;

		System.out.println("Introduce el sueldo.");
		sueldo = teclado.nextDouble();

		if (sueldo < 1000) {
			System.out.println("La retencion es de 10%. " + (sueldo - (sueldo * 0.1)));
		} else if (sueldo == 1000) {
			System.out.println("La retencion es de 12%. " + (sueldo - (sueldo * 0.12)));
		} else {
			System.out.println("La retencion es de 14%. " + (sueldo - (sueldo * 0.14)));
		}
		teclado.close();
	}
}