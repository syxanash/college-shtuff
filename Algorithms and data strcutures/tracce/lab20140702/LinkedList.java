package lab20140702;

import java.util.Iterator;

public class LinkedList<K, V> implements Dictionary<K, V> {

	Couple<K, V> list;

	private class Couple<C, E> {
		C key;
		E elem;

		Couple<C, E> next, prev;

		public Couple(C key, E elem) {
			this.key = key;
			this.elem = elem;

			next = prev = null;
		}
	}

	private class LinkedListIterator<C, E> implements Iterator<C> {

		LinkedList<C, E>.Couple<C, E> list;
		LinkedList<C, E>.Couple<C, E> pos;
		
		boolean gotHead = false;

		public LinkedListIterator(LinkedList<C, E>.Couple<C, E> list) {
			this.list = list;

			pos = this.list;
		}

		@Override
		public boolean hasNext() {
			if (pos == list && gotHead) {
				return false;
			} else if (pos == list) {
				gotHead = true;
				
				return true;
			}
			
			return true;
		}

		@Override
		public C next() {
			C elem = pos.key;

			pos = pos.next;

			return elem;
		}

	}

	@Override
	public void insert(K key, V value) {
		Couple<K, V> entry = new Couple<K, V>(key, value);

		if (list == null) {
			list = entry;

			list.next = list.prev = list;
		} else {
			entry.prev = list;
			entry.next = list.next;
			list.next.prev = entry;
			list.next = entry;
		}
	}

	@Override
	public void delete(K key) throws StrutturaVuotaException {
		if (list == null) {
			throw new StrutturaVuotaException();
		} else if (list.next == list) {
			list = null;
		} else if (list.key.equals(key)) {
			Couple<K, V> temp = list.next;
			temp.prev = list.prev;
			list.prev.next = temp;

			list = temp;
		} else {
			for (Couple<K, V> cursor = list.next; cursor != list; cursor = cursor.next) {
				if (cursor.key.equals(key)) {
					Couple<K, V> temp = cursor.next;
					temp.prev = cursor.prev;
					cursor.prev.next = temp;
				}
			}
		}
	}

	@Override
	public V search(K key) throws StrutturaVuotaException {
		if (list == null)
			throw new StrutturaVuotaException();

		if (list.key.equals(key))
			return list.elem;

		for (Couple<K, V> cursor = list.next; cursor != list; cursor = cursor.next) {
			if (cursor.key.equals(key))
				return cursor.elem;
		}

		return null;
	}

	@Override
	public Iterator<K> iterator() {
		return new LinkedListIterator<K, V>(list);
	}

	public static void main(String... args) throws StrutturaVuotaException {
		Dictionary<Integer, String> dict = new LinkedList<Integer, String>();

		dict.insert(45, "simone");
		dict.insert(6, "morena");

		Iterator<Integer> it = dict.iterator();
		
		while(it.hasNext()) {
			System.out.println(dict.search(it.next()));
		}
	}

}
