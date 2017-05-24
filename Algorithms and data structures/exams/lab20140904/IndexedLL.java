package lab20140904;

import java.util.Iterator;

public class IndexedLL<T> implements IndexedList<T> {

	private Record head, tail;
	private int size;

	private class Record {
		T elem;
		int index;

		Record next, prev;

		public Record(T e, int i) {
			this.elem = e;
			this.index = i;

			this.next = this.prev = null;
		}
	}

	private class IndexedLLIterator implements Iterator<T> {

		Record list;
		int size, pos;

		public IndexedLLIterator(Record list, int size) {
			this.list = list;
			this.size = size;
			this.pos = 0;
		}

		@Override
		public boolean hasNext() {
			return pos < size;
		}

		@Override
		public T next() {
			T elem = list.elem;
			list = list.next;
			pos++;

			return elem;
		}

	}

	@Override
	public boolean isEmpty(int i) {
		if (head == null) {
			return true;
		} else if (head.index == i) {
			return false;
		} else {
			for (Record rec = head.next; rec != null; rec = rec.next) {
				if (rec.index == i) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public void addItem(T e, int i) {
		if (!this.isEmpty(i))
			throw new ItemAlreadyPresentException();

		Record entry = new Record(e, i);

		if (head == null) {
			head = tail = entry;
		} else {
			if (i <= head.index) {
				entry.next = head;
				head.prev = entry;
				head = entry;
			} else if (i > tail.index) {
				entry.prev = tail;
				tail.next = entry;

				tail = entry;
			} else {
				for (Record rec = head.next; rec != null; rec = rec.next) {
					if (i <= rec.index) {
						entry.next = rec;
						entry.prev = rec.prev;

						rec.prev.next = entry;
						rec.prev = entry;

						break;
					}
				}
			}
		}

		size++;
	}

	@Override
	public void delItem(int i) {
		if (this.isEmpty(i))
			throw new ItemNotPresentException();

		if (head.index == i) {
			head = head.next;
		} else if (tail.index == i) {
			tail = tail.prev;
			tail.next = null;
		} else {
			for (Record rec = head.next; rec != null; rec = rec.next) {
				if (rec.index == i) {
					Record temp = rec.next;
					temp.prev = rec.prev;
					rec.prev.next = temp;

					break;
				}
			}
		}

		size--;
	}

	@Override
	public T getItem(int i) {
		if (this.isEmpty(i))
			throw new ItemNotPresentException();

		if (head.index == i)
			return head.elem;
		else if (tail.index == i)
			return tail.elem;

		for (Record rec = head; rec != null; rec = rec.next) {
			if (rec.index == i) {
				return rec.elem;
			}
		}

		return null;
	}

	@Override
	public int numberItems() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return new IndexedLLIterator(head, size);
	}

	public static void main(String... args) {
		IndexedLL<String> list = new IndexedLL<String>();

		list.addItem("simone", 4);
		list.addItem("morena", 1);
		list.addItem("gianni", 2);
		list.addItem("mirko", 5);
		list.addItem("super", 666);
		
		System.out.println(list.numberItems());

		System.out.println(list.getItem(666));
	}

}
