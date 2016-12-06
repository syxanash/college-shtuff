package lab20141120;

import java.util.Iterator;

public class DoubleLinkedList<S> implements AddOnlyList<S> {
	
	public Record list;
	
	private class Record {
		public S elem;
		
		public Record next;
		public Record prev;
		
		public Record(S elem) {
			this.elem = elem;
			
			next = prev = this;
		}
	}
	
	private class DoubleLinkedListIterator<S> implements Iterator<S> {
		
		private DoubleLinkedList<S>.Record iterList;
		private DoubleLinkedList<S>.Record pos = null;

		public DoubleLinkedListIterator(DoubleLinkedList<S>.Record list) {
			iterList = list;
			pos = iterList;
		}

		@Override
		public boolean hasNext() {
			return pos.next != iterList;
		}

		@Override
		public S next() {
			S elem = pos.elem;
			pos = pos.next;
			
			return elem;
		}
		
	}

	@Override
	public void add(S e) {
		if (list == null) {
			list = new Record(e);
		} else {
			Record item = new Record(e);
			
			item.next = list.next;
			list.next = item;
			item.prev = list;
			item.next.prev = item;
		}
	}

	@Override
	public Iterator<S> iterator() {
		return new DoubleLinkedListIterator(list);
	}
	
	public static void main(String... args) {
		AddOnlyList<String> list = new DoubleLinkedList<String>();
		
		list.add("simone");
		list.add("francesco");
		list.add("giovanni");
		
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println(it.next());
	}

}
