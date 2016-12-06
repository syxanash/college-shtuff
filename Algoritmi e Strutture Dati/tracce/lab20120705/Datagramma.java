package lab20120705;

public class Datagramma {
	String sorgente;
	String destinazione;
	int identificativo;
	String dati;
	boolean ultimo;
	
	public Datagramma(String sorg, String dest, int id, String dati, boolean ultimo) {
		this.sorgente = sorg;
		this.destinazione = dest;
		this.identificativo = id;
		this.dati = dati;
		this.ultimo = ultimo;
	}
}
