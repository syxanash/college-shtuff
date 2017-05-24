package lab20130221;

import java.util.Iterator;

public class Carrello implements AddOnlyList<Item> {
	
	Record<Item> items;
	
	private class Record<T> {
		T elem;
		
		Record<T> next, prev;
		
		public Record(T e) {
			elem = e;
			next = prev = null;
		}
	}
	
	private class CarelloIterator<T> implements Iterator<T> {
		
		Record<T> items;
		Record<T> pos;
		boolean gotFirst;
		
		public CarelloIterator(Record<T> list) {
			items = list;
			pos = items;
			
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
		public T next() {
			T elem = pos.elem;
			pos = pos.next;
			
			return elem;
		}
		
	}

	@Override
	public void add(Item e) {
		if (items == null) {
			items = new Record<Item>(e);
			items.next = items.prev = items;
		} else {
			Record<Item> entry = new Record<Item>(e);
			entry.next = items;
			entry.prev = items.prev;
			items.prev.next = entry;
			items.prev = entry;
		}
	}

	@Override
	public void forward() {
		items = items.next;
	}

	@Override
	public void backward() {
		items = items.prev;
	}

	@Override
	public Iterator<Item> iterator() {
		return new CarelloIterator<Item>(items);
	}
	
	public static void main(String... args) {
		AddOnlyList<Item> list = new Carrello();
		
		list.add(new Item(new Articolo("ciao"), 3));
		list.add(new Item(new Articolo("cotoletta"), 4));
		list.add(new Item(new Articolo("test"), 12));
		
		list.forward();
		
		Iterator<Item> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next().getArticolo().getNome());
		}
		
	}
	
}
