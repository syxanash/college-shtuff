package lab20160901;

import java.util.Iterator;

public abstract class SessioneAbs {
	protected AddOnlyList<Prodotto> prodotti;

	// dobbiamo inventarci noi i metodi per rappresentare la sessione?

	public void acquista(Prodotto p) {
		prodotti.add(p);
	}

	public int quantita(Prodotto p) {
		int quantita = 0;

		for (Prodotto e : prodotti) {
			if (e.nome.compareTo(p.nome) == 0) {
				quantita++;
			}
		}

		return quantita;
	}

	public int numeroProdotti() {
		int q = 0;
		Iterator<Prodotto> it = prodotti.iterator();

		while (it.hasNext()) {
			q++;
		}

		return q;
	}

	public double prezzoTotale() {
		double price = 0;

		for (Prodotto p : prodotti) {
			price += p.prezzo;
		}

		return price;
	}
}
