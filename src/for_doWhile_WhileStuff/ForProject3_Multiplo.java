package for_doWhile_WhileStuff;

public class ForProject3_Multiplo {

	public static void main(String[] args) {
		int num = 0;
		for (int i = 0; i < 5; i++) {
			if (num % 2 == 0) {
				System.out.println(num);
			} else {
				i--;
			}
			num++;
		}
	}
}
