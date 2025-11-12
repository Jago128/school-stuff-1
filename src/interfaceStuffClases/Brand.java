package interfaceStuffClases;

public enum Brand {
	JUVER("Juver"), RAMON_BILBAO("Ramon Bilbao"), FANTA("Fanta"), BODEGAS_BILBAO("Bodegas Bilbao"),
	PATERNINA("Paternina");

	private String name;

	private Brand(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
