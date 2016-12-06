package lab20120403;

import java.util.Iterator;

public class CollDict<S> implements Dictionary<S> {

	Couple<S> items;

	private class Couple<T> {
		T elem;
		Comparable key;

		Couple<T> next, prev;

		public Couple(T e, Comparable k) {
			this.elem = e;
			this.key = k;

			next = prev = null;
		}
	}
	
	private class CollDictIterator<T> implements Iterator<Comparable> {

		Couple<T> list, pos;
		boolean gotFirst;
		
		public CollDictIterator(Couple<T> items) {
			this.list = items;
			this.pos = this.list;
			
			this.gotFirst = false;
		}

		@Override
		public boolean hasNext() {
			if (items == pos && gotFirst) {
				return false;
			} else if (items == pos) {
				gotFirst = true;
				
				return true;
			}
			
			return true;
		}

		@Override
		public Comparable next() {
			Comparable key = pos.key;
			pos = pos.next;
			
			return key;
		}
		
	}

	@Override
	public void insert(S e, Comparable k) {
		if (items == null) {
			items = new Couple<S>(e, k);
			items.next = items.prev = items;
		} else {
			Couple<S> entry = new Couple<S>(e, k);
			entry.next = items.next;
			entry.prev = items;
			items.next.prev = entry;
			items.next = entry;
		}
	}

	@Override
	public void delete(Comparable k) {
		if (items == null) {
			return;
		} else if (items.key.compareTo(k) == 0) {
			if (items.next == items) {
				items = null;
			} else {
				Couple<S> temp = items.next;
				temp.prev = items.prev;
				items.prev.next = temp;

				items = temp;
			}
		} else {
			for (Couple<S> rec = items.next; rec != items; rec = rec.next) {
				if (rec.key.compareTo(k) == 0) {
					Couple<S> temp = rec.next;
					temp.prev = rec.prev;
					rec.prev.next = temp;
				}
			}
		}
	}

	@Override
	public S search(Comparable k) {
		if (items == null)
			return null;

		if (items.key.compareTo(k) == 0) {
			return items.elem;
		} else {
			for (Couple<S> rec = items.next; rec != items; rec = rec.next) {
				if (rec.key.compareTo(k) == 0) {
					return rec.elem;
				}
			}
		}
		
		return null;
	}

	@Override
	public Iterator<Comparable> iterator() {
		return new CollDictIterator<S>(items);
	}
	
	public static void main(String... args) {
		Dictionary<String> dict = new CollDict<String>();
		
		dict.insert("simone", 65);
		dict.insert("morena", 4);
		dict.insert("gianni", 5);
		dict.insert("franco", 100);
		
		dict.delete(100);
		
		Iterator<Comparable> it = dict.iterator();
		
		while(it.hasNext()) {
			System.out.println(dict.search(it.next()));
		}
	}

}
