package if_Else_and_SwitchStuff;

import java.util.Scanner;

public class IfElseProject6 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		double nota;

		System.out.println("Introduce la nota.");
		nota = teclado.nextDouble();

		if (0 >= nota && nota < 3) {
			System.out.println("MEDIOCRE");

		} else if (3 >= nota && nota < 5) {
			System.out.println("INSUFICIENTE");

		} else if (5 >= nota && nota < 6) {
			System.out.println("SUFICIENTE");

		} else if (6 >= nota && nota < 7) {
			System.out.println("BIEN");

		} else if (7 >= nota && nota < 9) {
			System.out.println("NOTABLE");

		} else if (9 >= nota && nota <= 10) {
			System.out.println("SOBRESALIENTE");
		}
		teclado.close();
	}
}