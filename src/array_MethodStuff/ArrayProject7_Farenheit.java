package array_MethodStuff;
import java.util.Scanner;
public class ArrayProject7_Farenheit {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String wDay[]= {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
		double temp[]= new double [7];
		String cDay="", waDay="";
		double avg=0, cold=100, warm=0;

		for (int i=0;i<temp.length;i++) {
			System.out.println("Introduce los grados durante el "+wDay[i]+" en celsius:");
			temp[i]=sc.nextDouble();
		}

		for (int i=0;i<temp.length;i++) {
			avg=avg+temp[i];
			if (warm<temp[i]) {
				warm=temp[i];
				waDay=wDay[i];
			}

			if (cold>temp[i]) {
				cold=temp[i];
				cDay=wDay[i];
			}
		}
		avg=avg/temp.length;
		System.out.println("La media de la semana es "+((avg*9/5)+32)+"ºF");
		System.out.println("El dia mas caluroso es "+waDay+" con "+warm+"ºC.");
		System.out.println("El dia mas frio es "+cDay+" con "+cold+"ºC");

		for (int i=0;i<temp.length;i++) {
			if (temp[i]>avg) {
				System.out.println("El dia "+wDay[i]+" tiene una temperatura encima de la media.");
			}

			if (temp[i]<avg) {
				System.out.println("El dia "+wDay[i]+" tiene una temperatura debajo de la media.");
			}
		}
		sc.close();
	}
}
