package array_MethodStuff;

import java.util.Scanner;

public class ArrayProject1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[10];
		int num = 0, cant = 0;

		while (num >= 0 && cant != a.length) {
			System.out.println("Introduce el valor entre 0 y 9:");
			num = sc.nextInt();
			while (num >= 10) {
				System.out.println("ERROR! Introduce un numero entre 0 y 9:");
				num = sc.nextInt();
			}
			if (num > 0) {
				a[cant] = num;
				cant++;
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		sc.close();
	}
}
