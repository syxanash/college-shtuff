package lab20140904;

public class Pacchetto {
	String mittente;
	String destinatario;
	int identificativo;
	String dati;
	boolean ultimo;
	
	public Pacchetto(String mitt, String dest, int id, String dati, boolean ultimo) {
		this.mittente = mitt;
		this.destinatario = dest;
		this.identificativo = id;
		this.dati = dati;
		this.ultimo = ultimo;
	}
}
