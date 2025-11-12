package for_doWhile_WhileStuff;

import java.util.Scanner;

public class FibonacciSerie {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int n, num1 = 0, num2 = 1, veces = 0, sigNum;

		System.out.print("Introduzca un numero entero: ");
		n = teclado.nextInt();
		System.out.println("Serie Fibonacci hasta " + n + " veces: ");

		while (veces < n) {
			System.out.println(num1 + " ");
			sigNum = num1 + num2;
			num1 = num2;
			num2 = sigNum;
			veces++;
		}
		teclado.close();
	}
}
