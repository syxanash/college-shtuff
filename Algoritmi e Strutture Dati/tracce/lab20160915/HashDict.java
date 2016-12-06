package lab20160915;

import java.util.Iterator;
import java.util.LinkedList;

public class HashDict<S> implements Dictionary<S> {

	private LinkedList<Record<S>>[] s;

	private class Record<T> {
		T elem;
		Comparable key;

		public Record(T e, Comparable k) {
			this.elem = e;
			this.key = k;
		}
	}

	private class HashDictIterator implements Iterator<Comparable> {

		private LinkedList<Record<S>>[] items;
		private int posCounter, innerCounter;

		public HashDictIterator(LinkedList<Record<S>>[] items) {
			this.items = items;

			posCounter = 0;
			innerCounter = 0;
		}

		@Override
		public boolean hasNext() {

			if (posCounter >= items.length)
				return false;

			while (items[posCounter] == null || items[posCounter].size() == 0) {
				posCounter++;

				if (posCounter >= items.length) {
					return false;
				}
			}

			return true;
		}

		@Override
		public Comparable next() {
			Comparable key = items[posCounter].get(innerCounter++).key;

			if (innerCounter >= items[posCounter].size()) {
				innerCounter = 0;

				posCounter++;
			}

			return key;
		}

	}

	public HashDict(int n) {
		s = new LinkedList[n];
	}

	private int h(Comparable k) {
		return Math.abs(k.hashCode()) % s.length;
	}

	@Override
	public void insert(S e, Comparable k) {
		int pos = this.h(k);

		if (s[pos] == null)
			s[pos] = new LinkedList<Record<S>>();

		s[pos].add(new Record<S>(e, k));
	}

	@Override
	public void delete(Comparable k) {
		int pos = this.h(k);

		boolean found = false;

		if (s == null)
			throw new StrutturaVuotaException();

		if (s[pos] == null) {
			throw new ItemNotFoundException();
		} else {
			for (Record<S> rec : s[pos]) {
				if (rec.key.compareTo(k) == 0) {
					s[pos].remove(rec);
					found = true;

					break;
				}
			}
		}

		if (!found) {
			throw new ItemNotFoundException();
		}
	}

	@Override
	public S search(Comparable k) {
		int pos = this.h(k);

		if (s == null)
			throw new StrutturaVuotaException();

		if (s[pos] == null) {
			throw new ItemNotFoundException();
		} else {
			for (Record<S> rec : s[pos]) {
				if (rec.key.compareTo(k) == 0) {
					return rec.elem;
				}
			}
		}

		return null;
	}

	@Override
	public Iterator<Comparable> iterator() {
		return new HashDictIterator(s);
	}

	public static void main(String... args) {
		HashDict<String> dict = new HashDict<String>(10);
		dict.insert("simone", 3);
		dict.insert("morena", 2);
		dict.insert("gianni", 1);
		dict.insert("mirko", 6);

		dict.delete(2);

		Iterator<Comparable> it = dict.iterator();
		while (it.hasNext()) {
			System.out.println(dict.search(it.next()));
		}

	}

}
