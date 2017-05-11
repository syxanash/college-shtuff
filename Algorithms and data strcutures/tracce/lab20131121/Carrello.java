package lab20131121;

import java.util.Iterator;

public class Carrello implements Iterable<Articolo> {
	
	private class CarrelloIterator implements Iterator<Articolo> {
		
		private Dictionary<Integer> items;
		private Iterator<Comparable> it;

		public CarrelloIterator(Dictionary<Integer> carrello) {
			items = carrello;
			it = items.iterator();
		}

		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		@Override
		public Articolo next() {
			Articolo art = (Articolo) it.next();
			
			return art;
		}
		
	}

	protected Dictionary<Integer> carrello;
	private int numArticoli = 0;

	public Carrello() {
		carrello = new DizionarioCollegato<Integer>();
	}

	public void aggArticolo(Articolo art) {
		if (this.appartiene(art)) {
			int quantita = this.quantita(art);

			carrello.delete(art);
			carrello.insert(art, quantita + 1);
		} else {
			carrello.insert(art, 1);

			numArticoli++;
		}

	}

	public void togliArticolo(Articolo art) {
		if (this.appartiene(art)) {
			int quantita = this.quantita(art);

			carrello.delete(art);

			if (quantita <= 1) {
				numArticoli--;
			} else {
				carrello.insert(art, quantita - 1);				
			}
		}

	}

	public boolean eVuoto() {
		return numArticoli == 0;
	}

	public int quantita(Articolo art) {
		return carrello.search(art);
	}

	public boolean appartiene(Articolo art) {
		return carrello.search(art) != null;

	}

	public int numArticoliDistinti() {
		return numArticoli;
	}

	@Override
	public Iterator<Articolo> iterator() {
		return new CarrelloIterator(carrello);
	}

	public static void main(String... args) {
		Carrello shop = new Carrello();

		//System.out.println(shop.eVuoto());

		shop.aggArticolo(new Articolo("Frollini Dixie", "500gr"));
		shop.aggArticolo(new Articolo("latte Galactica", "1 lt"));
		shop.aggArticolo(new Articolo("latte Galactica", "1 lt"));
		shop.aggArticolo(new Articolo("Detersivo Macchianera", "2Kg"));
		
		Iterator<Articolo> it = shop.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
