package scannerStuff;

import java.util.Scanner;

public class ScannerProject2_Temperaturas {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		double tempC;
		
		System.out.print("Introduce la temperatura en grados Celsius: ");
		tempC = teclado.nextDouble();
		System.out.println("Los grados en Celsius son " + tempC + "ºC");
		System.out.println("Los grados en Farenheit son " + (32 + (tempC * 1.8)) + "ºF");
		System.out.println("Los grados en Kelvin son " + (273 + tempC) + "K");
		teclado.close();
	}
}
