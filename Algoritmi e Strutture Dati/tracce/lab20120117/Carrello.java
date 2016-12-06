package lab20120117;

import java.util.Iterator;

public class Carrello implements AddOnlyList<Item> {
	
	private Record items;
	
	private class Record {
		protected Item elem;
		
		protected Record next, prev;
		
		public Record(Item elem) {
			this.elem = elem;
			
			next = prev = null;
		}
	}
	
	private class CarrelloIterator implements Iterator<Item> {
		
		Record list, pos;
		boolean gotFirst;
		
		public CarrelloIterator(Record items) {
			this.list = items;
			this.pos = this.list;
			
			gotFirst = false;
		}

		@Override
		public boolean hasNext() {
			if (list == pos && gotFirst) {
				return false;
			} else if (list == pos) {
				gotFirst = true;
				
				return true;
			}
			
			return true;
		}

		@Override
		public Item next() {
			Item elem = pos.elem;
			pos = pos.next;
			
			return elem;
			
		}
		
	}

	@Override
	public void add(Item e) {
		Record entry = new Record(e);
		
		if (items == null) {
			items = entry;
			items.next = items.prev = items;
		} else {
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
	public void backword() {
		items = items.prev;
	}

	@Override
	public Iterator<Item> iterator() {
		return new CarrelloIterator(items);
	}

}
