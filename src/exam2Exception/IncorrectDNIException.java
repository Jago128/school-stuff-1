package exam2Exception;

public class IncorrectDNIException extends Exception {
	private static final long serialVersionUID = 1L;

	public IncorrectDNIException(String mensaje) {
		super(mensaje);
	}
}
