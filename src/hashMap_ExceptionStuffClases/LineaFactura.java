package hashMap_ExceptionStuffClases;

public class LineaFactura {
	private String code; // Product Code
	private int quantity;
	private double lineTotal;

	public LineaFactura() {
		this.code = "";
		this.quantity = 0;
		this.lineTotal = 0;
	}

	public LineaFactura(String code, int quantity, double lineTotal) {
		this.code = code;
		this.quantity = quantity;
		this.lineTotal = lineTotal;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(double lineTotal) {
		this.lineTotal = lineTotal;
	}

	@Override
	public String toString() {
		return "LineaFactura [code=" + code + ", quantity=" + quantity + ", lineTotal=" + lineTotal + "]";
	}
}
