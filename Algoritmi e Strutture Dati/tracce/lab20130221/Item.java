package lab20130221;

public class Item {
	private Articolo articolo;
	private int quantita;
	
	public Item(Articolo articolo, int quantita) {
		this.articolo = articolo;
		this.quantita = quantita;
	}

	public Articolo getArticolo() {
		return articolo;
	}

	public int getQuantita() {
		return quantita;
	}
}
