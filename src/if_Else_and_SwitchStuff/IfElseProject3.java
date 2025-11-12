package if_Else_and_SwitchStuff;

import java.util.Scanner;

public class IfElseProject3 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		double num, cuadrado;

		System.out.print("Intruduce el numero: ");
		num = teclado.nextDouble();
		cuadrado = num * num;
		if (cuadrado > 100) {
			System.out.println(cuadrado - 100);
		} else {
			System.out.println("Falta esto para llegar a 100.");
			System.out.println(100 - cuadrado);
		}
		teclado.close();
	}
}