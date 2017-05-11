package lab20160901;

import java.util.Random;

public class ItemRecommender {
	Sessioni sessioni;

	public ItemRecommender(int n) {
		sessioni = new Sessioni();
		Random rnd = new Random();
		Prodotto[] prodotti = { new Prodotto("Macintosh", 1050),
				new Prodotto("iPhone", 777), new Prodotto("Apple II", 666),
				new Prodotto("iPod", 99), new Prodotto("MacBook Pro 13", 1100),
				new Prodotto("macbook pro retina", 2400),
				new Prodotto("iLife", 140), new Prodotto("iWork", 900) };

		for (int i = 0; i < n; i++) {
			SessioneLL currentSession = new SessioneLL();

			for (int j = 0; j < (rnd.nextInt(3) + 1); j++) {
				currentSession.acquista(prodotti[rnd.nextInt(prodotti.length)]);
			}

			sessioni.addSessione(currentSession);
		}
	}

	// non sono certo di aver capito cosa sia la cooccorrenza
	public int acquistiAssociati(Prodotto a, Prodotto b) {
		int frequenza = 0;

		for (SessioneLL s : sessioni.listaSessioni) {
			for (Prodotto p : s.prodotti) {
				if (p.nome.compareTo(a.nome) == 0
						|| p.nome.compareTo(b.nome) == 0) {
					frequenza++;
				}
			}
		}
		
		return frequenza;
	}
}
