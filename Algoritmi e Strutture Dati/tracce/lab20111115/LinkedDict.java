package lab20111115;

import java.util.Iterator;

public class LinkedDict<S> implements Dictionary<S> {
	
	private Couple items;
	
	private class Couple {
		S elem;
		Comparable key;
		
		Couple next, prev;
		
		public Couple(S elem, Comparable key) {
			this.elem = elem;
			this.key = key;
			
			next = prev = null;
		}
	}
	
	private class LinkedDictIterator implements Iterator<S> {
		
		Couple list, pos;
		boolean gotFirst;
		
		public LinkedDictIterator(Couple items) {
			list = items;
			pos = list;
			gotFirst = false;
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
		public S next() {
			S elem = pos.elem;
			pos = pos.next;
			
			return elem;
		}
		
	}

	@Override
	public void insert(S e, Comparable k) {
		if (items == null) {
			items = new Couple(e, k);
			items.next = items.prev = items;
		} else {
			Couple entry = new Couple(e, k);
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
				Couple temp = items.next;
				temp.prev = items.prev;
				items.prev.next = temp;
				items = temp;
			}
		} else {
			for (Couple rec = items.next; rec != items; rec = rec.next) {
				if (rec.key.compareTo(k) == 0) {
					Couple temp = rec.next;
					temp.prev = rec.prev;
					rec.prev.next = temp;
				}
			}
		}
	}

	@Override
	public S search(Comparable k) {
		if (items == null) {
			return null;
		} else if (items.key.compareTo(k) == 0) {
			return items.elem;
		} else {
			for (Couple rec = items.next; rec != items; rec = rec.next) {
				if (rec.key.compareTo(k) == 0) {
					return rec.elem;
				}
			}
		}
		
		return null;
	}

	@Override
	public Iterator<S> iterator() {
		return new LinkedDictIterator(items);
	}
	
	public static void main(String... args) {
		Dictionary<String> dict = new LinkedDict();
		
		dict.insert("simone", 45);
		dict.insert("morena", 23);
		dict.insert("gianni", 69);
		dict.insert("test", 22);
		
		dict.delete(22);
		
		Iterator<String> it = dict.iterator();
		System.out.println(dict.search(23));
		
		
		while(it.hasNext()) {
			
		}
	}

}
