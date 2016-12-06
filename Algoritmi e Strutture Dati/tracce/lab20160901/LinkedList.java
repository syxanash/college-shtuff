package lab20160901;

import java.util.Iterator;

public class LinkedList<S> implements AddOnlyList<S> {

	Record head, tail;

	private class Record {
		S elem;
		Record next;

		public Record(S e) {
			this.elem = e;
			this.next = null;
		}
	}

	private class LinkedListIterator implements Iterator<S> {

		Record list;

		public LinkedListIterator(Record items) {
			this.list = items;
		}

		@Override
		public boolean hasNext() {
			return list != null;
		}

		@Override
		public S next() {
			S elem = list.elem;
			list = list.next;

			return elem;
		}

	}

	@Override
	public void add(S e) {
		Record entry = new Record(e);

		if (head == null) {
			head = tail = entry;
		} else {
			if (head == tail) {
				tail = entry;
				head.next = tail;
			} else {
				tail.next = entry;
				tail = entry;
			}
		}
	}

	@Override
	public Iterator<S> iterator() {
		return new LinkedListIterator(head);
	}

	public static void main(String... args) {
		LinkedList<String> list = new LinkedList<String>();

		list.add("simone");
		list.add("morena");
		list.add("giovanni");

		Iterator<String> it = list.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
