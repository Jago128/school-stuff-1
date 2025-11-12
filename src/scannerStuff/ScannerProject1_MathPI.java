package scannerStuff;

import java.util.Scanner;

public class ScannerProject1_MathPI {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String nombre;
		double radio,ladoC, ladoCorto, ladoLargo, altura, base;

		System.out.println("¡Hola!");
		System.out.println("¿Cuál es tu nombre?");
		nombre = teclado.next();
		System.out.println("Bienvenid@ " + nombre + ". Vamos a realizar diferentes cálculos.");
		System.out.println("*************************");

		System.out.println("CÍRCULO");
		System.out.print("Introduce el valor del radio:");
		radio = teclado.nextDouble();
		System.out.println("El área del círculo es " + Math.PI * Math.pow(radio, 2));
		System.out.println("*************************");

		System.out.println("CUADRADO");
		System.out.print("Introduce el valor del lado:");
		ladoC = teclado.nextDouble();
		System.out.println("El área del cuadrado es " + Math.pow(ladoC, 2) + "m2");
		System.out.println("*************************");

		System.out.println("RECTANGULO");
		System.out.print("Introduce el valor del lado más corto:");
		ladoCorto = teclado.nextDouble();
		System.out.print("Introduce el valor del lado más largo:");
		ladoLargo = teclado.nextDouble();
		System.out.println("El área del rectangulo es " + ladoCorto * ladoLargo + "m2");
		System.out.println("*************************");

		System.out.println("TRIÁNGULO");
		System.out.print("Introduce el valor de la altura:");
		altura = teclado.nextDouble();
		System.out.print("Introduce el valor de la base:");
		base = teclado.nextDouble();
		System.out.println("El área del triangulo es " + (altura * base) / 2 + "m2");
		System.out.println("*************************");
		teclado.close();
	}
}
