package hierarchy_ArrayListStuff;
import java.time.LocalDate;

public class Publicacion {
	protected LocalDate date;
	protected String title;
	
	public Publicacion(LocalDate d, String t) {
		this.date=d;
		this.title=t;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Publicacion [date=" + date + ", title=" + title + "]";
	}
}
