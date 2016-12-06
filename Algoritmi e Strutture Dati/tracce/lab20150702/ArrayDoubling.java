package lab20150702;

import java.util.Iterator;

public class ArrayDoubling<S> implements Dictionary<S> {
	
	Record<S>[] S = new Record[1];
	int n = 0;
	
	private class Record<T> {
		T elem;
		Comparable key;
		
		public Record(T e, Comparable k) {
			elem = e;
			key = k;
		}
	}
	
	private class ArrayDoublingIterator implements Iterator<Comparable> {

		Record<S>[] items;
		int n;
		int pos;
		
		public ArrayDoublingIterator(Record<S>[] items, int n) {
			this.items = items;
			this.n = n;
			
			this.pos = 0;			
		}
		
		@Override
		public boolean hasNext() {
			return pos < n;
		}

		@Override
		public Comparable next() {
			Comparable elem = items[pos].key;
			pos++;
			
			return elem;
		}
		
	}

	@Override
	public void insert(S e, Comparable k) {
		S[n] = new Record<S>(e, k);
		
		n++;
		
		if (n == S.length) {
			Record<S>[] temp = new Record[S.length * 2];
			
			for (int i = 0; i < n; i++) {
				temp[i] = S[i];
			}
			
			S = temp;
		}
	}

	@Override
	public void delete(Comparable k) throws StrutturaVuotaException {
		if (n == 0)
			throw new StrutturaVuotaException();
		
		int newPos = n;
		
		for (int i = 0; i < n; i++) {
			if (S[i].key.compareTo(k) == 0) {
				newPos = i;
				n--;
				break;
			}
		}
		
		for (int i = newPos; i < n; i++) {
			S[i] = S[i + 1];
		}
		
		if (n > 1 && n <= S.length / 4) {
			Record<S>[] temp = new Record[S.length / 2];
			
			for (int i = 0; i < n; i++) {
				temp[i] = S[i];
			}
			
			S = temp;
		}
		
	}

	@Override
	public S search(Comparable k) throws StrutturaVuotaException {
		if (n == 0)
			throw new StrutturaVuotaException();
		
		for (int i = 0; i < n; i++) {
			if (S[i].key.compareTo(k) == 0) {
				return S[i].elem;
			}
		}
		
		return null;
	}

	@Override
	public Iterator<Comparable> iterator() {
		return new ArrayDoublingIterator(S, n);
	}
	
	public static void main(String... args) throws StrutturaVuotaException {
		Dictionary<String> dict = new ArrayDoubling<String>();
		
		dict.insert("simone", 45);
		dict.insert("giovanni", 23);
		dict.insert("morena", 666);
		
		Iterator<Comparable> it = dict.iterator();
		
		while(it.hasNext()) {
			Comparable item = it.next();
			
			System.out.println(dict.search(item) + " " + item);
		}
	}

}
