package lab20120705;

import java.util.Iterator;

public class IndexedList<T> implements ListaIndicizzata<T> {

	private T[] items = (T[]) new Object[1];
	private int n = 0;

	private class IndexedListIterator<S> implements Iterator<S> {

		S[] items;
		int pos;

		public IndexedListIterator(S[] items) {
			this.items = items;
			this.pos = 0;
		}

		@Override
		public boolean hasNext() {
			return pos < items.length;
		}

		@Override
		public S next() {
			return items[pos++];
		}

	}

	@Override
	public boolean isEmpty(int i) {
		if (i >= items.length)
			return true;
		
		if (items[i] == null)
			return true;

		return false;
	}

	@Override
	public void addElement(T e, int i) {
		if (i < items.length) {
			items[i] = e;

		} else {
			T[] temp = (T[]) new Object[i + 1];

			for (int j = 0; j < items.length; j++)
				temp[j] = items[j];

			items = temp;
			items[i] = e;
		}

		n++;
	}

	@Override
	public T getElement(int i) throws UndefinedElementException {
		if (isEmpty(i)) {
			throw new UndefinedElementException();
		}

		return items[i];
	}

	@Override
	public int numberElements() {
		return n;
	}

	@Override
	public Iterator<T> iterator() {
		return new IndexedListIterator<T>(items);
	}

	public static void main(String... args) {

		ListaIndicizzata<String> list = new IndexedList<String>();

		list.addElement("simone", 0);
		list.addElement("morena", 1);
		list.addElement("gianni", 2);
		list.addElement("gianfranco", 5);
		list.addElement("eleono", 4);

		Iterator<String> it = list.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
