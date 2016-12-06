package lab20141120;

import java.util.Iterator;

public class ArrayDict<K, V> implements Dictionary<K, V> {

	private Couple<K, V>[] S = new Couple[1];
	int n = 0;

	private class Couple<C, E> {
		public C chiave;
		public E elem;

		public Couple(C chiave, E elem) {
			this.chiave = chiave;
			this.elem = elem;
		}
	}

	private class ArrayDictIterator<V> implements Iterator<V> {

		ArrayDict<K, V>.Couple<K, V>[] iterS;
		int elements = 0;

		int pos = 0;

		public ArrayDictIterator(ArrayDict<K, V>.Couple<K, V>[] s, int n) {
			this.iterS = s;
			this.elements = n;

		}

		@Override
		public boolean hasNext() {
			return pos < elements;
		}

		@Override
		public V next() {
			return iterS[pos++].elem;
		}

	}

	@Override
	public void insert(K key, V value) {
		S[n] = new Couple<K, V>(key, value);
		n++;

		if (n == S.length) {
			Couple<K, V>[] temp = new Couple[S.length * 2];

			for (int i = 0; i < n; i++)
				temp[i] = S[i];

			S = temp;
		}
	}

	@Override
	public void delete(K key) {
		for (int i = 0; i < n; i++) {
			if (S[i].chiave.equals(key)) {
				S[i] = S[n - 1];
			}
		}

		n--;

		if (n > 1 && n <= S.length / 4) {
			Couple<K, V>[] temp = new Couple[S.length / 2];

			for (int i = 0; i < n; i++)
				temp[i] = S[i];

			S = temp;
		}
	}

	@Override
	public V search(K key) {
		for (int i = 0; i < n; i++) {
			if (S[i].chiave.equals(key)) {
				return S[i].elem;
			}
		}

		return null;
	}

	@Override
	public Iterator<K> iterator() {
		return new ArrayDictIterator(S, n);
	}

	public static void main(String[] args) {
		Dictionary<Integer, String> diz = new ArrayDict<Integer, String>();
		diz.insert(45, "simone");
		diz.insert(2, "morena");
		diz.insert(88, "giovanni");
		diz.insert(45, "mike");
		diz.delete(2);

		Iterator<Integer> it = diz.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
