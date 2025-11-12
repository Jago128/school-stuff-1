package reto1;

import java.util.Scanner;

public class RetoAct4_powWithoutMathpow {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String exit = " ", opcion;
		int num1, num2, mcd, mcm, resultA = 1, resultB = 1, result = 1;

		do {
			do {
				exit = " ";
				System.out.println("Introduce dos numeros mayor o igual a 0.");
				System.out.println("Primer numero:");
				num1 = sc.nextInt();
				System.out.println("Segundo numero:");
				num2 = sc.nextInt();

				if (num1 < 0 || num2 < 0) {
					System.out.println("Opcion invalida. ¿Quieres salir? SI/NO");
					exit = sc.next();
					while (!exit.equalsIgnoreCase("NO") && !exit.equalsIgnoreCase("SI")) {
						System.out.println("ERROR. Di SI o NO.");
						exit = sc.next();
					}
				}
			} while (exit.equalsIgnoreCase("NO"));

			if (!exit.equals("NO")) {
				System.out.println("a) MCD");
				System.out.println("b) MCM");
				System.out.println("c) Factorial de ambos");
				System.out.println("d) División");
				System.out.println("e) Elevar el primer numero al segundo sin usar la librería Math");
				System.out.println("f) Salir");
				do {
					System.out.print("Elija una opcion: ");
					opcion = sc.next();

					switch (opcion) {
					case "a":
						int a = Math.max(num1, num2);
						int b = Math.min(num1, num2);

						do {
							mcd = b;
							b = a % b;
							a = mcd;

						} while (b != 0);
						System.out.println("El MCD de " + num1 + " y " + num2 + " es: " + mcd);

						System.out.println("¿Quieres salir? SI/NO");
						exit = sc.next();
						while (!exit.equalsIgnoreCase("NO") && !exit.equalsIgnoreCase("SI")) {
							System.out.print("ERROR. Di SI o NO: ");
							exit = sc.next();
							if (exit.equals("SI")) {
								System.out.println("Adios!");
							}
						}
						break;

					case "b":
						mcm = (num1 > num2) ? num1 : num2;

						while (true) {
							if (mcm % num1 == 0 && mcm % num2 == 0) {
								System.out.println("El MCM de " + num1 + " y " + num2 + " es " + mcm);
								break;
							}
							++mcm;
						}
						System.out.println("¿Quieres salir? SI/NO");
						exit = sc.next();
						while (!exit.equalsIgnoreCase("NO") && !exit.equalsIgnoreCase("SI")) {
							System.out.print("ERROR. Di SI o NO: ");
							exit = sc.next();
						}
						break;

					case "c":
						for (int i = 1; i <= num1; i++) {
							resultA = resultA * i;
						}
						System.out.println("El factorial de " + num1 + " es " + resultA);

						for (int i = 1; i <= num2; i++) {
							resultB = resultB * i;
						}
						System.out.println("El factorial de " + num2 + " es " + resultB);
						System.out.println("¿Quieres salir? SI/NO");
						exit = sc.next();
						while (!exit.equalsIgnoreCase("NO") && !exit.equalsIgnoreCase("SI")) {
							System.out.print("ERROR. Di SI o NO: ");
							exit = sc.next();
						}
						break;

					case "d":
						System.out.println("La division de " + num1 + " y " + num2 + " es " + num1 / num2);
						System.out.println("¿Quieres salir? SI/NO");
						exit = sc.next();
						while (!exit.equalsIgnoreCase("NO") && !exit.equalsIgnoreCase("SI")) {
							System.out.print("ERROR. Di SI o NO: ");
							exit = sc.next();
						}
						break;

					case "e":
						while (num2 != 0) {
							result = result * num1;
							num2--;
						}
						System.out.println("La potencia de " + num1 + " y " + num2 + " es " + result);
						System.out.println("¿Quieres salir? SI/NO");
						exit = sc.next();
						while (!exit.equalsIgnoreCase("NO") && !exit.equalsIgnoreCase("SI")) {
							System.out.print("ERROR. Di SI o NO: ");
							exit = sc.next();
						}
						break;

					case "f":
						System.out.println("Adios!");
						break;

					default:
						System.out.println("ERROR. Elija otra opcion.");
						break;
					}
				} while (!opcion.equalsIgnoreCase("a") && !opcion.equalsIgnoreCase("b") && !opcion.equalsIgnoreCase("c")
						&& !opcion.equalsIgnoreCase("d") && !opcion.equalsIgnoreCase("e")
						&& !opcion.equalsIgnoreCase("f"));
			} else if (exit.equals("SI")) {
				System.out.println("Adios!");
			}
		} while (exit.equals("NO"));
		sc.close();
	}
}
