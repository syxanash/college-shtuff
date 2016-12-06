package lab20160411;

import java.util.Iterator;

public class LinkedDict<K, V> implements Dictionary<K, V> {

	Couple<K, V> items;

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
	
	private class LinkedDictIterator<C, E> implements Iterator<C> {

		Couple<C, E> items;
		Couple<C, E> pos;
		boolean gotFirst;
		
		public LinkedDictIterator(Couple<C, E> items) {
			this.items = items;
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
			if (items.next == items) {
				items = null;
			} else {
				Couple<K, V> temp = items.next;
				
				temp.prev = items.prev;
				items.prev.next = temp;
				
				items = temp;
			}
		} else {
			for (Couple<K, V> rec = items.next; rec != items; rec = rec.next) {
				if (rec.key.equals(key)) {
					Couple<K, V> temp = rec.next;

					temp.prev = rec.prev;
					rec.prev.next = temp;
				}
			}
		}

	}

	@Override
	public V search(K key) {
		if (items.key.equals(key)) {
			return items.elem;
		} else {
			for (Couple<K, V> rec = items.next; rec != items; rec = rec.next) {
				if (rec.key.equals(key))
					return rec.elem;
			}
		}

		return null;
	}

	@Override
	public Iterator<K> iterator() {
		return new LinkedDictIterator<K, V>(items);
	}
	
	public static void main(String... args) {
		Dictionary<String, Integer> list = new LinkedDict<String, Integer>();
		list.insert("simone", 45);
		list.insert("morena", 4);
		list.insert("gianni", 21);
		
		list.delete("simone");
		
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(list.search(it.next()));
		}
		
	}

}
