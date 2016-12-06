package lab20120221;

public class Volume {
	private String titolo;
	private String autore;
	private String anno;
	private boolean stato;
	
	public Volume(String titolo, String autore, String anno, boolean prestato) {
		this.titolo = titolo;
		this.autore = autore;
		this.anno = anno;
		this.stato = prestato;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public String getAutore() {
		return autore;
	}
	
	public String getAnno() {
		return anno;
	}
	
	public boolean getStato() {
		return stato;
	}
	
	public void setStato(boolean prestato) {
		this.stato = prestato;
	}
}
