package array_MethodStuff;

import java.util.Scanner;
import java.util.Random;

public class ArrayProject3_Random {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[10];
		int menu, avg = 0, sum = 0, max = 0, min = 101, temp;
		Random rng = new Random();

		for (int i = 0; i < a.length; i++) {
			a[i] = rng.nextInt(101);
		}

		do {
			System.out.println(
					"1. Salir\n2. Mostrar suma\n3. Mostrar el maximo\n4. Mostrar el minimo\n5. Mostrar la media\n6. Rellenarlo con nuevos numeros\n7. Ordenar el array con el metodo de la burbuja y ver el resultado");
			System.out.print("Introduzca una opcion: ");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				System.out.println("Adios!");
				break;

			case 2:
				for (int i = 0; i < a.length; i++) {
					sum = sum + a[i];
				}
				System.out.println("La suma es: " + sum);
				break;

			case 3:
				for (int i = 0; i < a.length; i++) {
					if (a[i] > max) {
						max = a[i];
					}
				}
				System.out.println(max);
				break;

			case 4:
				for (int i = 0; i < a.length; i++) {
					if (a[i] < min) {
						min = a[i];
					}
				}
				System.out.println(min);
				break;

			case 5:
				for (int i = 0; i < a.length; i++) {
					avg = avg + a[i];
				}
				System.out.println("La media es " + avg / a.length);
				break;

			case 6:
				for (int i = 0; i < a.length; i++) {
					a[i] = rng.nextInt(101);
				}
				System.out.println("Los numeros han sido reasignados.");
				break;

			case 7:
				for (int i = 0; i < a.length - 1; i++) {
					for (int j = 0; j < a.length - i - 1; j++) {
						if (a[j + 1] < a[j]) {
							temp = a[j + 1];
							a[j + 1] = a[j];
							a[j] = temp;
						}
					}
				}

				for (int i = 0; i < a.length; i++) {
					System.out.println(a[i]);
				}
				break;

			default:
				System.out.println("ERROR. Elija otra opcion.");
				break;
			}
		} while (menu != 1 || menu == 7);
		sc.close();
	}
}
