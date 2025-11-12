package array_MethodStuff;

import java.util.Scanner;

public class ArrayProject5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String mes[] = { "Enero", "Febrero", "Marzo", "Abril", "Mayo" };
		int litros[] = { 123, 333, 180, 211, 90 };
		int max = 0;
		String highest = "";

		for (int i = 0; i < mes.length; i++) {
			System.out.println("En " + mes[i] + " han llovido " + litros[i] + " litros.");
			if (litros[i] > max) {
				max = litros[i];
				highest = mes[i];
			}
		}
		System.out.println("El mes mas lluvioso ha sido " + highest + " con " + max + "L de lluvia.");
		sc.close();
	}
}
