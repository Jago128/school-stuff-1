package objectStuff;

import java.util.Scanner;

import objectStuffClasses.Cuenta;

public class ObjectProject1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Cuenta acc1 = new Cuenta();
		Cuenta acc2 = new Cuenta("Victor");
		Cuenta acc3 = new Cuenta("Alicia", 12);
		double money;

		acc1.ingresar(10);
		acc3.ingresar(12000);
		System.out.println(acc3.toString());
		System.out.println("¿Cuanto queieres ingresar a Victor?");
		money = sc.nextDouble();
		acc2.ingresar(money);
		System.out.println(acc2.toString());
		acc2.retirar(200);
		System.out.println(acc2.toString());

		sc.close();
	}
}
