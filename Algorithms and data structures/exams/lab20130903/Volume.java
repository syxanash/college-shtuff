package lab20130903;

public class Volume implements Comparable {
	String titolo, casaEditrice;
	int annoPub;

	AddOnlyList<String> autori;

	public Volume(String titolo, String casaEditrice, int annoPub, AddOnlyList<String> autori) {
		this.titolo = titolo;
		this.casaEditrice = casaEditrice;
		this.annoPub = annoPub;
		this.autori = autori;
	}

	public String toString() {
		return titolo + ":" + casaEditrice + ":" + annoPub;
	}

	@Override
	public int compareTo(Object o) {
		return this.toString().compareTo(((Volume) o).toString());
	}

}
