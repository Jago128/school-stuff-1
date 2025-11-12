package hashMap_ExceptionStuffExceptions;

public class NegativeSalaryException extends Exception {
	private static final long serialVersionUID = 1L;

	public void NegativeSalaryExceptionMessage(double salario) {
		System.out.println("La cuenta queda en negativos, operacion invalida.");
	}
}
