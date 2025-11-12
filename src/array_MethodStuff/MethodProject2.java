package array_MethodStuff;

import java.util.Scanner;

public class MethodProject2 {

	public static void num() {
		int a[] = new int[10];
		int b[] = new int[10];
		Scanner s = new Scanner(System.in);
		int set, e = 1, f = 1;

		System.out.println("Introduzca su nombre:");
		System.out.println(s.next().toUpperCase());
		for (int i = 0; i < a.length; i++) {
			do {
				System.out.println("Introduzca un numero entre 10 y 500:");
				set = s.nextInt();
				if (set < 10 || set > 500) {
					System.out.println("ERROR. Numero invalido.");
				} else {
					a[i] = set;
					b[i] = set * 2;
				}
			} while (set < 10 || set > 500);
		}

		for (int numN : a) {
			System.out.println("Numero " + e + ": " + numN);
			e++;
		}

		for (int numTwo : b) {
			System.out.println("Numero " + f + ": " + numTwo);
			f++;
		}
		s.close();
	}

	public static void pos() {
		Scanner s = new Scanner(System.in);
		int sum = 0, num, count = 0;
		String choice;
		do {
			System.out.println("Introduzca un numero:");
			num = s.nextInt();
			if (num >= 0) {
				sum = sum + num;
				count++;
				for (int i = 0; i < num; i++) {
					System.out.print("*");
				}
			} else {
				System.out.println("?");
			}
			System.out.println("¿Quiere introducir otro numero? (SI/NO)");
			choice = s.next();
			while (!choice.equalsIgnoreCase("SI") && !choice.equalsIgnoreCase("NO")) {
				System.out.println("ERROR. Di SI o NO.");
				choice = s.next();
			}
		} while (choice.equalsIgnoreCase("SI"));

		System.out.println("Se han introducido " + count + " numeros positivos y la media es " + sum / count);
		s.close();
	}

	public static void repe() {
		Scanner s = new Scanner(System.in);
		int n[] = new int[10];
		int num, temp;

		for (int i = 0; i < n.length; i++) {
			do {
				System.out.println("Introduzca el numero " + (i + 1) + ":");
				num = s.nextInt();
			} while (num < 1 || num > 10);
			n[i] = num;
		}
		for (int i = 0; i < n.length - 1; i++) {
			for (int j = 0; j < n.length - i - 1; j++) {
				if (n[j + 1] < n[j]) {
					temp = n[j + 1];
					n[j + 1] = n[j];
					n[j] = temp;
				}
			}
		}
		System.out.print("Se han introducido:");
		for (int i = 0; i < n.length; i++) {

		}
		s.close();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String menu;

		do {
			System.out.println(
					"A. Introducir diez numeros entre 10 y 500 y tu nombre\nB. Introducir numeros positivos y hacer media al acabar introduciondo numeros\nC. Introducir diez numeros entre 1 y 10 y mostrar los no repetidos\n4. Salir");
			menu = sc.next();

			switch (menu) {
			case "A":
				num();
				break;

			case "B":
				pos();
				break;

			case "C":
				repe();
				break;

			case "D":
				System.out.println("Adios!");
				break;

			default:
				System.out.println("ERROR. Introduzca otra opcion.");
				break;

			}
		} while (!menu.equalsIgnoreCase("D"));
		sc.close();
	}
}
