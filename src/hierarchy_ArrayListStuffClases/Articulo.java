package hierarchy_ArrayListStuffClases;

import java.time.LocalDate;

public class Articulo extends Publicacion {
	private String media;

	public Articulo(LocalDate d, String t, String m) {
		super(d, t);
		this.media = m;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	@Override
	public String toString() {
		return "Articulo [media=" + media + ", toString()=" + super.toString() + "]";
	}
}
