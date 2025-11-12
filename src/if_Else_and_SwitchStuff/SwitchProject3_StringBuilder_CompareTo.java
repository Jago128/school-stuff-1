package if_Else_and_SwitchStuff;

import java.util.Scanner;

public class SwitchProject3_StringBuilder_CompareTo {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String nombre, word, word1, word2, palabra, count;
		int opcion, repeatc;

		System.out.print("Escribe tu nombre: ");
		nombre = teclado.next();
		System.out.println("Bienvenido, " + nombre + " ¿Que quieres hacer?");
		System.out.println("1. Dar la vuelta a una palabra.");
		System.out.println("2. Comparar dos palabras.");
		System.out.println("3. Numero de letras.");
		System.out.println("4. Repetir palabra.");
		System.out.println("5. Salir del programa.");
		opcion = teclado.nextInt();

		switch (opcion) {
		case 1:
			System.out.print("Introduce una palabra: ");
			word = teclado.next();
			System.out.println("Original: " + word);
			String invert = new StringBuilder(word).reverse().toString();
			System.out.println("Invertido: " + invert);
			break;
			
		case 2:
			System.out.println("Introduce dos palabras: ");
			word1 = teclado.next();
			word2 = teclado.next();
			System.out.println(word1);
			System.out.println(word2);
			int comparison = word1.compareTo(word2);

			if (comparison == 0) {
				System.out.println("Las dos palabras son iguales.");
			} else {
				System.out.println("Las dos palabras no son iguales.");
			}
			break;
			
		case 3:
			System.out.print("Introduce una palabra para despues decir su lengitud: ");
			count = teclado.next();
			System.out.println("La palabra tiene " + (count.length()));
			if (count.length() > 7) {
				System.out.println("La palabra es larga");
			} else {
				System.out.println("La palabra es corta");
			}
			break;
			
		case 4:
			System.out.print("Introduzca la palabra que quieras repetir: ");
			palabra = teclado.next();
			System.out.print("Introduce el numero de veces que quieres que se repita: ");
			repeatc = teclado.nextInt();
			int i = 0;

			while (i < repeatc) {
				System.out.println(palabra.toUpperCase());
				i++;
			}
			break;

		case 5:
			System.out.println("Adios!");
			break;
			
		default:
			System.out.println("ERROR");
		}
		teclado.close();
	}

}
