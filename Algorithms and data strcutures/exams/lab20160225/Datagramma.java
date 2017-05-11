package lab20160225;

import java.net.InetAddress;

public class Datagramma {
	private String sorgente;
	private String destinazione;
	private int identificativo;
	private String dati;
	private boolean ultimo;
	
	public Datagramma(String sorgente, String destinazione,
			int identificativo, String dati, boolean ultimo) {
		this.sorgente = sorgente;
		this.destinazione = destinazione;
		this.identificativo = identificativo;
		this.dati = dati;
		this.ultimo = ultimo;
	}
	public String getSorgente() {
		return sorgente;
	}
	public void setSorgente(String sorgente) {
		this.sorgente = sorgente;
	}
	public String getDestinazione() {
		return destinazione;
	}
	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}
	public int getIdentificativo() {
		return identificativo;
	}
	public void setIdentificativo(int identificativo) {
		this.identificativo = identificativo;
	}
	public String getDati() {
		return dati;
	}
	public void setDati(String dati) {
		this.dati = dati;
	}
	public boolean isUltimo() {
		return ultimo;
	}
	public void setUltimo(boolean ultimo) {
		this.ultimo = ultimo;
	}
}
