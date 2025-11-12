package reto1;

import java.util.Scanner;

public class RetoAct3_BuscarEspecificoMul {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int can, b500, b200, b100, b50, b20, b10, b5, m2, m1;

		do {
			System.out.print("Inserte la cantidad para pagar: ");
			can = sc.nextInt();
			if (can < 0) {
				System.out.println("ERROR. Introduce un numero valido.");
			}
		} while (can < 0);

		System.out.println("La cantidad para pagar: " + can);

		b500 = (can - can % 500) / 500;
		can = can % 500;
		b200 = (can - can % 200) / 200;
		can = can % 200;
		b100 = (can - can % 100) / 100;
		can = can % 100;
		b50 = (can - can % 50) / 50;
		can = can % 50;
		b20 = (can - can % 20) / 20;
		can = can % 20;
		b10 = (can - can % 10) / 10;
		can = can % 10;
		b5 = (can - can % 5) / 5;
		can = can % 5;
		m2 = (can - can % 2) / 2;
		can = can % 2;
		m1 = can;

		if (b500 > 0) {
			System.out.println("Billetes de 500: " + b500);
		}
		if (b200 > 0) {
			System.out.println("Billetes de 200: " + b200);
		}
		if (b100 > 0) {
			System.out.println("Billetes de 100: " + b100);
		}
		if (b50 > 0) {
			System.out.println("Billetes de 50: " + b50);
		}
		if (b20 > 0) {
			System.out.println("Billetes de 20: " + b20);
		}
		if (b10 > 0) {
			System.out.println("Billetes de 10: " + b10);
		}
		if (b5 > 0) {
			System.out.println("Billetes de 5: " + b5);
		}
		if (m2 > 0) {
			System.out.println("Monedas de 2: " + m2);
		}
		if (m1 > 0) {
			System.out.println("Monedas de 1: " + m1);
		}
		sc.close();
	}
}
