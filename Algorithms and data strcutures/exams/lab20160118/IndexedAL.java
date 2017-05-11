package lab20160118;

import java.util.Iterator;

public class IndexedAL<T> implements IndexedList<T> {

	private T[] items = (T[]) new Object[1];
	private int size = 0;

	private class IndexedALIterator implements Iterator<T> {

		private T[] list;
		private int n, pos, itemCounter;

		public IndexedALIterator(T[] list, int n) {
			this.list = list;
			this.n = n;

			this.itemCounter = 0;
			this.pos = 0;
		}

		@Override
		public boolean hasNext() {
			return itemCounter < n;
		}

		@Override
		public T next() {
			while (list[pos] == null)
				pos++;

			T elem = list[pos++];
			itemCounter++;

			return elem;
		}

	}

	@Override
	public boolean isEmpty(int i) {
		if (i >= items.length) {
			return true;
		} else if (items[i] == null) {
			return true;
		}

		return false;
	}

	@Override
	public void addItem(T e, int i) {
		if (!this.isEmpty(i))
			throw new ItemAlreadyPresentException();

		if (i >= items.length) {
			T[] temp = (T[]) new Object[i + 1];

			for (int j = 0; j < items.length; j++) {
				temp[j] = items[j];
			}

			items = temp;
		}

		items[i] = e;
		size++;

		if (size == items.length) {
			T[] temp = (T[]) new Object[items.length * 2];

			for (int j = 0; j < items.length; j++) {
				temp[j] = items[j];
			}

			items = temp;
		}
	}

	@Override
	public void delItem(int i) {
		if (this.isEmpty(i))
			throw new ItemNotPresentException();

		items[i] = null;
		size--;
	}

	@Override
	public T getElem(int i) {
		if (this.isEmpty(i))
			throw new ItemNotPresentException();

		return items[i];
	}

	@Override
	public int numberItems() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return new IndexedALIterator(items, size);
	}

	public static void main(String... args) {
		IndexedAL<String> list = new IndexedAL<String>();

		list.addItem("simone", 3);
		list.addItem("gianni", 2);
		list.addItem("morena", 4);
		list.addItem("luca", 0);
		list.addItem("mirko", 1);

		list.delItem(0);

		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println(list.numberItems());
	}

}
