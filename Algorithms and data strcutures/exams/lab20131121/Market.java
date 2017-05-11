package lab20131121;

import java.util.Iterator;

public class Market {
	protected Articolo[] merce = {
			new Articolo("Frollini Dixie", "500gr"),
			new Articolo("latte Galactica", "1 lt"),
			new Articolo("Detersivo Macchianera", "2Kg"),
			new Articolo("Acert aspire", "1pz"),
			new Articolo("Acqua Pagna", "50 lt"),
			new Articolo("Nutella", "2pz")
	};

	protected Carrello[] acquisti;

	public Market(int n) {
		acquisti = new Carrello[n];
	}
	
	void stampa() {
		int cNum = 0;
		for (Carrello c : acquisti) {
			System.out.println("---------- CARRELLO N° " + cNum + " ----------");
			
			Iterator<Articolo> it = c.iterator();
			
			while(it.hasNext()) {
				System.out.println(it.next());
			}
			
			cNum++;
		}
	}
	
	void istogramma() {
		int cNum = 0;
		for (Carrello c : acquisti) {
			System.out.println("---------- CARRELLO N° " + cNum + " ----------");
			for (Articolo art : merce) {
				if (c.appartiene(art)) {
					int quantita = c.quantita(art);
					
					System.out.println(art.toString() + " quantità: " + quantita);
				}
			}
			cNum++;
		}
	}
}
