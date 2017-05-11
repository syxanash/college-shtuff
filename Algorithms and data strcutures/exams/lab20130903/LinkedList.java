package lab20130903;

import java.util.Iterator;

public class LinkedList<K, V> implements Dictionary<K, V> {

	Couple<K, V> items;

	private class Couple<C, E> {
		C key;
		E elem;

		Couple<C, E> next, prev;

		public Couple(C key, E elem) {
			this.key = key;
			this.elem = elem;

			next = prev = this;
		}
	}

	private class LinkedListIterator<C, E> implements Iterator<C> {

		Couple<C, E> items;
		Couple<C, E> pos;
		boolean gotFirst;

		public LinkedListIterator(Couple<C, E> list) {
			this.items = list;
			this.pos = this.items;
			this.gotFirst = false;
		}

		@Override
		public boolean hasNext() {
			if (items == null) {
				return false;
			} else if (items == pos && gotFirst) {
				return false;
			} else if (items == pos) {
				gotFirst = true;

				return true;
			}

			return true;
		}

		@Override
		public C next() {
			C key = pos.key;
			pos = pos.next;

			return key;
		}

	}

	@Override
	public void insert(K key, V value) {
		if (items == null) {
			items = new Couple<K, V>(key, value);
			items.next = items.prev = items;
		} else {
			Couple<K, V> entry = new Couple<K, V>(key, value);
			entry.next = items.next;
			entry.prev = items;
			items.next.prev = entry;
			items.next = entry;
		}
	}

	@Override
	public void delete(K key) {
		if (items == null) {
			return;
		} else if (items.key.equals(key)) {
			// se l'elemento cercato è il primo
			// ed è l'unico azzero la lista
			if (items.next == items) {
				items = null;
			} else {
				// altrimenti sostituisco il primo
				// con il successivo
				Couple<K, V> temp = items.next;
				temp.prev = items.prev;
				items.prev.next = temp;

				items = temp;
			}
		} else {
			// se l'elemento cercato non è in testa
			// allora scorro tutti gli altri elementi
			// finchè non trovo quello interessato
			for (Couple<K, V> pos = items.next; pos != items; pos = pos.next) {
				if (pos.key.equals(key)) {
					Couple<K, V> temp = pos.next;
					temp.prev = pos.prev;
					pos.prev.next = temp;

					break;
				}
			}
		}

	}

	@Override
	public V search(K key) {
		if (items == null) {
			return null;
		} else if (items.key.equals(key)) {
			return items.elem;
		} else {
			for (Couple<K, V> pos = items.next; pos != items; pos = pos.next) {
				if (pos.key.equals(key)) {
					return pos.elem;
				}
			}
		}

		return null;
	}

	@Override
	public Iterator<K> iterator() {
		return new LinkedListIterator<K, V>(items);
	}

	public static void main(String... args) {
		Dictionary<String, String> dict = new LinkedList<String, String>();

		dict.insert("Simone Marz", "0068541236");
		dict.insert("Morena deL", "3384521063");

		dict.delete("Simone Marz");
		dict.delete("Morena deL");

		Iterator<String> it = dict.iterator();

		while (it.hasNext()) {
			String key = it.next();

			System.out.println(dict.search(key) + " " + key);
		}

	}
}
