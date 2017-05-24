package lab20150224;

import java.util.Iterator;

public class WOListLinked implements ListaOrdinata {
	
	private Couple<Comparable> items;
	private int n = 0;

	private class Couple<T> {
		private T elem;
		
		private Couple<T> next;
		
		public Couple(T elem) {
			this.elem = elem;
			next = null;
		}
	}
	
	private class WOListLinkedIterator implements Iterator {

		private Couple<Comparable> items;
		private int n;
		private int pos;
		
		public WOListLinkedIterator(Couple<Comparable> items, int n) {
			this.items = items;
			this.n = n;
			this.pos = 0;
		}
		
		@Override
		public boolean hasNext() {
			return pos < n;
		}

		@Override
		public Comparable next() {
			Comparable elem = items.elem;
			
			items = items.next;
			pos++;
			
			return elem;
		}
		
	}
	
	@Override
	public void insert(Comparable e) {
		if (n == 0) {
			items = new Couple<Comparable>(e);
		} else {
			// controllo la testa
			if (e.compareTo(items.elem) > 0) {
				Couple<Comparable> entry = new Couple<Comparable>(e);
				
				entry.next = items;
				items = entry;
			} else { // controllo il resto degli elementi
				for (Couple<Comparable> pos = items; pos != null; pos = pos.next) {
					if (pos.next == null) {
						pos.next = new Couple<Comparable>(e);
						
						break;
					} else if (e.compareTo(pos.next.elem) > 0) {
						Couple<Comparable> entry = new Couple<Comparable>(e);
						
						entry.next = pos.next;
						pos.next = entry;
						
						break;
					}
				}
			}
		}
		
		n++;
	}

	@Override
	public int numElementi() {
		return n;
	}

	@Override
	public Iterator iterator() {
		return new WOListLinkedIterator(items, n);
	}
	
	public static void main(String... args) {
		ListaOrdinata list = new WOListLinked();
		
		list.insert("80.5 LHM");
		list.insert("55.6 feed");
		list.insert("75.7 thor");
		list.insert("90 LUDUM");
		
		Iterator<Comparable> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("num elementi: " + list.numElementi());
	}

}
