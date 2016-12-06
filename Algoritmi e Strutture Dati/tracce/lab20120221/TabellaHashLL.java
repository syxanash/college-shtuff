package lab20120221;

import java.util.Iterator;
import java.util.LinkedList;

public class TabellaHashLL<S> implements Dictionary<S> {

	LinkedList<Couple>[] elementi;
	Hash fHash;

	private class Couple {
		S elem;
		Comparable key;

		public Couple(S e, Comparable k) {
			elem = e;
			key = k;
		}
	}

	private class TabellaHashLLIterator implements Iterator<S> {

		private LinkedList<Couple>[] items;
		private int size, pos, posList;

		public TabellaHashLLIterator(LinkedList<Couple>[] items) {
			this.items = items;
			this.size = items.length;

			this.pos = 0;
			this.posList = 0;
		}

		@Override
		public boolean hasNext() {
			while (pos < size
					&& (items[pos] == null || items[pos].size() == 0)) {
				pos++;
			}

			return pos < size;
		}

		@Override
		public S next() {
			S elem = items[pos].get(posList++).elem;

			if (posList >= items[pos].size()) {
				posList = 0;
				pos++;
			}

			return elem;
		}

	}

	public TabellaHashLL(int n, Hash f) {
		elementi = new LinkedList[n];
		fHash = f;
	}

	@Override
	public void insert(S e, Comparable k) {
		int pos = fHash.h(k, elementi.length);

		if (elementi[pos] == null)
			elementi[pos] = new LinkedList<Couple>();

		for (Couple c : elementi[pos])
			if (c.key.compareTo(k) == 0)
				throw new ItemAlreadyPresent();

		elementi[pos].add(new Couple(e, k));
	}

	@Override
	public void delete(Comparable k) {
		int pos = fHash.h(k, elementi.length);

		for (Couple c : elementi[pos]) {
			if (c.key.compareTo(k) == 0) {
				elementi[pos].remove(c);
				return;
			}
		}

		throw new ItemNotFoundException();
	}

	@Override
	public S search(Comparable k) {
		int pos = fHash.h(k, elementi.length);

		for (Couple c : elementi[pos]) {
			if (c.key.compareTo(k) == 0) {
				return c.elem;
			}
		}

		throw new ItemNotFoundException();
	}

	@Override
	public Iterator<S> iterator() {
		return new TabellaHashLLIterator(elementi);
	}

	public static void main(String... args) {
		TabellaHashLL<String> table = new TabellaHashLL<String>(2,
				new HashDivisione());

		table.insert("Simone", 3);
		table.insert("gianni", 4);
		table.insert("morena", 1);
		table.insert("luka", 2);
		

		Iterator<String> it = table.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
