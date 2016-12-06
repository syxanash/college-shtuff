package lab20131121;

import java.util.Iterator;

public class DizionarioCollegato<V> implements Dictionary<V> {

	private Record<V> items;

	private class Record<T> {
		T elem;
		Comparable key;

		Record<T> next;
		Record<T> prev;

		public Record(Comparable key, T elem) {
			this.elem = elem;
			this.key = key;

			next = prev = null;
		}
	}

	private class DizionarioCollegatoIterator<T> implements	Iterator<Comparable> {

		DizionarioCollegato<T>.Record<T> items;
		DizionarioCollegato<T>.Record<T> pos;
		
		boolean gotFirst;

		public DizionarioCollegatoIterator(DizionarioCollegato<T>.Record<T> diz) {
			this.items = diz;
			this.pos = this.items;
			gotFirst = false;
		}

		@Override
		public boolean hasNext() {
			if (pos == items && gotFirst) {
				return false;
			} else if (pos == items) {
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
	public void insert(Comparable key, V value) {
		if (items == null) {
			items = new Record<V>(key, value);
			items.next = items.prev = items;
		} else {
			Record<V> entry = new Record<V>(key, value);

			entry.next = items.next;
			entry.prev = items;
			items.next.prev = entry;
			items.next = entry;
		}
	}

	@Override
	public void delete(Comparable key) {
		if (items == null) {
			return;
		} else if (items.key.compareTo(key) == 0) {
			if (items == items.next) {
				items = null;
			} else {
				Record<V> temp = items.next;
				temp.prev = items.prev;
				items.prev.next = temp;
				items = temp;
			}
		} else {
			for (Record<V> p = items.next; p != items; p = p.next) {
				if (p.key.compareTo(key) == 0) {
					Record<V> temp = p.next;

					temp.prev = p.prev;
					p.prev.next = temp;
					break;
				}
			}
		}

	}

	@Override
	public V search(Comparable key) {
		if (items == null)
			return null;

		// controllo se l'elemento è il primo

		if (items.key.compareTo(key) == 0)
			return items.elem;

		for (Record<V> p = items.next; p != items; p = p.next) {
			if (p.key.compareTo(key) == 0) {
				return p.elem;
			}
		}

		return null;
	}

	@Override
	public Iterator<Comparable> iterator() {
		return new DizionarioCollegatoIterator<V>(items);
	}

	public static void main(String... args) {
		Dictionary<String> dict = new DizionarioCollegato<String>();
		dict.insert(12, "simone");
		dict.insert(24, "morena");
		dict.insert(2, "giovanni");
		
		dict.delete(24);
		dict.delete(12);

		Iterator<Comparable> it = dict.iterator();
		
		while(it.hasNext()) {
			Comparable item = it.next();
			System.out.println(item + " " + dict.search(item));
		}
	}
}
