package p9Exception;

public class NegativeStockException extends Exception {
	private static final long serialVersionUID = 1L;

	public NegativeStockException(String message) {
		super(message);
	}
}
