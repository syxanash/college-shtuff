package lab20150702;

import java.util.Iterator;

public class AddOnlyLinkedList<S> implements AddOnlyList<S> {
	
	Record items;
	int n = 0;
	
	private class Record {
		S item;
		Record next;
		
		public Record(S item) {
			this.item = item;
			next = null;
		}
	}
	
	private class AddOnlyLinkedListIterator implements Iterator<S> {

		Record items;
		int n;
		int pos;
		
		public AddOnlyLinkedListIterator(Record items, int n) {
			this.items = items;
			this.n = n;
			this.pos = 0;
		}
		
		@Override
		public boolean hasNext() {
			return pos < n;
		}

		@Override
		public S next() {
			S elem = items.item;
			pos++;
			items = items.next;
			
			return elem;
		}
		
	}

	@Override
	public void add(S e) {
		if (n == 0) {
			items = new Record(e);
		} else {
			Record entry = new Record(e);
			
			entry.next = items;
			items = entry;
		}
		
		n++;
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public Iterator<S> iterator() {
		return new AddOnlyLinkedListIterator(items, n);
	}
	
	public static void main(String... args) {
		AddOnlyList<String> list = new AddOnlyLinkedList<String>();
		
		list.add("simone");
		
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
