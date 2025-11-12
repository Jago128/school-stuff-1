package scannerStuff;

import java.util.Scanner;

public class ScannerProject3 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		double cant€, interes;
		int dias;

		System.out.print("Introduce una cantidad de euros: ");
		cant€ = teclado.nextDouble();
		System.out.print("Introduce tipo de interes (solo numero): ");
		interes = teclado.nextDouble();
		System.out.print("Introduce numero de dias: ");
		dias = teclado.nextInt();
		System.out.println("El interes producido es de " + (cant€ * interes * dias) / (360 * 100) + "%");
		teclado.close();
	}
}
