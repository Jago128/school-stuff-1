package for_doWhile_WhileStuff;

import java.util.Scanner;

public class WhileProject3 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int num, num1 = 0;
		
		System.out.print("Introduzca un numero entero: ");
		num = teclado.nextInt();
		while (num >= num1) {

			if (num1 % 2 == 0) {
				System.out.println(num1);
			}
			num1++;

			teclado.close();
		}
	}
}
