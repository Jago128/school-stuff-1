package if_Else_and_SwitchStuff;

import java.util.Scanner;

public class SwitchProject2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int num1, num2;
		String opcion;

		System.out.println("Introduce el primer numero:");
		num1 = teclado.nextInt();
		System.out.println("Introduce el segundo numero:");
		num2 = teclado.nextInt();

		System.out.println("a. Sumar");
		System.out.println("b. Restar");
		System.out.println("c. Multiplicar");
		System.out.println("d. Dividir");
		System.out.println("e. Resto (%)");
		System.out.println("0. Salir");
		System.out.print("Elige una opcion: ");
		opcion = teclado.next();

		switch (opcion) {
		case "a":
			System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
			break;
		case "b":
			System.out.println(num1 + "-" + num2 + "= " + (num1 - num2));
			break;
		case "c":
			System.out.println(num1 + "*" + num2 + "= " + (num1 * num2));
		case "d":
			System.out.println(num1 + "/" + num2 + "= " + (num1 / num2));
			break;
		case "e":
			System.out.println(num1 + "%" + num2 + "= " + (num1 % num2));
			break;
		case "0":
			System.out.println("Adios!");
			break;
		default:
			System.out.println("Error");
			break;
		}
		teclado.close();
	}
}