package lab20151119;

import java.util.Iterator;

public class Orologio<S> implements CircQueue<S> {

	private Record items;
	private int size;

	public class Record {
		S elem;
		Record next, prev;

		public Record(S e) {
			this.elem = e;
			next = prev = null;
		}
	}

	private class OrologioIterator implements Iterator<S> {
		Record list;
		int n, pos;

		public OrologioIterator(Record list, int size) {
			this.list = list;
			this.n = size;
			this.pos = 0;
		}

		@Override
		public boolean hasNext() {
			return pos < n;
		}

		@Override
		public S next() {
			S elem = list.elem;
			pos++;
			list = list.next;

			return elem;
		}

	}

	@Override
	public void add(S e) {
		Record entry = new Record(e);

		if (items == null) {
			items = new Record(e);
			items.next = items.prev = items;
		} else {
			entry.next = items;
			entry.prev = items.prev;
			items.prev.next = entry;
			items.prev = entry;
		}

		size++;
	}

	@Override
	public S value() {
		return items.elem;
	}

	@Override
	public boolean isEmpty() {
		return items == null;
	}

	@Override
	public void rotateF() {
		items = items.next;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean equals(CircQueue<S> s) {
		Iterator<S> it = this.iterator();
		Iterator<S> otherIt = s.iterator();

		if (this.size() != s.size())
			return false;

		while (it.hasNext() && otherIt.hasNext()) {
			if (it.next() != otherIt.next()) {
				return false;
			}
		}

		return true;
	}

	@Override
	public Iterator<S> iterator() {
		return new OrologioIterator(items, size);
	}

	public static void main(String... args) {
		Orologio<String> oro = new Orologio<String>();

		oro.add("simone");
		oro.add("morena");
		oro.add("gianni");

		Orologio<String> secondo = new Orologio<String>();
		secondo.add("simone");
		secondo.add("morena");
		secondo.add("gianni");

		System.out.println(oro.equals(secondo));
	}

}
