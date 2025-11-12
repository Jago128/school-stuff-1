package if_Else_and_SwitchStuff;

import java.util.Scanner;

public class SwitchProject1 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int num1, num2, opcion;

		System.out.println("Introduce el primer numero:");
		num1 = teclado.nextInt();
		System.out.println("Introduce el segundo numero:");
		num2 = teclado.nextInt();

		System.out.println("1. Sumar");
		System.out.println("2. Restar");
		System.out.println("3. Multiplicar");
		System.out.println("4. Dividir");
		System.out.println("5. Resto (%)");
		System.out.println("0. Salir");
		System.out.print("Elige una opcion: ");
		opcion = teclado.nextInt();

		switch (opcion) {
		case 1:
			System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
			break;
			
		case 2:
			System.out.println(num1 + "-" + num2 + "= " + (num1 - num2));
			break;
			
		case 3:
			System.out.println(num1 + "*" + num2 + "= " + (num1 * num2));
			break;
			
		case 4:
			System.out.println(num1 + "/" + num2 + "= " + (num1 / num2));
			break;
			
		case 5:
			System.out.println(num1 + "%" + num2 + "= " + (num1 % num2));
			break;
			
		case 0:
			System.out.println("Adios!");
			break;
			
		default:
			System.out.println("Error");
			break;
		}
		teclado.close();
	}
}