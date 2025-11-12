package array_MethodStuff;

import java.util.Scanner;

public class ArrayProject6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name[] = { "Jon", "Sara", "Ander", "Marta", "Jone", "Mikel" };
		int age[] = { 18, 20, 26, 21, 17, 24 };
		String oldestN = "", youngestN = "";
		int oldest = 0, youngest = 30;

		for (int i = 0; i < age.length; i++) {
			if (youngest > age[i]) {
				youngest = age[i];
				youngestN = name[i];
			}

			if (oldest < age[i]) {
				oldest = age[i];
				oldestN = name[i];
			}

		}
		System.out.println("El nombre y edad del mas joven es " + youngestN + " con " + youngest + " años.");
		System.out.println("El nombre y edad del mas mayor es " + oldestN + " con " + oldest + " años.");
		sc.close();
	}
}
