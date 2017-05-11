package lab20141120;

public class Volume {
	public String titolo;
	public String casaEditrice;
	public int annoPub;
	public AddOnlyList<String> autori;
	
	public Volume(String casaEditrice, int annoPub, AddOnlyList<String> autori) {
		this.annoPub = annoPub;
		this.casaEditrice = casaEditrice;
		this.autori = autori;
	}
	
	// confronta se due volumi sono uguali	
	public boolean uguali(Volume o) {
		return this.equals(o);
	}
}
