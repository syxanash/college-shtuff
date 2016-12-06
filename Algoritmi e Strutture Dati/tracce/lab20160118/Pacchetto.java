package lab20160118;

public class Pacchetto {
	String utente;
	String mittente;
	int identificativo;
	String dati;
	boolean ultimo;

	public Pacchetto(String utente, String mittente, int identificativo,
			String dati, boolean ultimo) {
		super();
		this.utente = utente;
		this.mittente = mittente;
		this.identificativo = identificativo;
		this.dati = dati;
		this.ultimo = ultimo;
	}

}
