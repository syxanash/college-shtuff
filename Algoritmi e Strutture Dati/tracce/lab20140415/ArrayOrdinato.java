package lab20140415;

import java.util.Iterator;

public class ArrayOrdinato<V> implements Dictionary<V> {
	
	public Couple<V>[] items = new Couple[0];
	
	private class Couple<E> {
		Comparable key;
		E value;
		
		public Couple(Comparable k, E value) {
			this.key = k;
			this.value = value;
		}
	}
	
	private class ArrayOrdinatoIterator<E> implements Iterator<Comparable> {
		
		ArrayOrdinato<E>.Couple<E>[] items;
		int pos = 0;

		public ArrayOrdinatoIterator(ArrayOrdinato<E>.Couple<E>[] items) {
			this.items = items;
		}

		@Override
		public boolean hasNext() {
			return pos < items.length;
		}

		@Override
		public Comparable next() {
			Comparable key = (Comparable) items[pos].key;
			pos++;
			
			return key;
		}
		
	}

	@Override
	public void insert(V e, Comparable k) {
		Couple<V>[] temp = new Couple[items.length + 1];
		int newPos = items.length;
		
		for (int i = 0; i < items.length; i++)
			temp[i] = items[i];
		
		items = temp;
		
		for (int i = 0; i < items.length - 1; i++) {
			if (k.compareTo(items[i].key) <= 0) {
				newPos = i;
				break;
			}
		}
		
		for (int i = items.length - 1; i > newPos; i--) {
			items[i] = items[i - 1];
		}
		
		items[newPos] = new Couple<V>(k, e);
	}

	@Override
	public void delete(Comparable k) {
		int i = 0;
		int j = items.length;
		
		while(i < j) {
			int m = (i + j) / 2;
			
			if (k.compareTo(items[m].key) == 0) {
				Couple<V>[] temp = new Couple[items.length - 1];
				
				for (int p = 0; p < m; p++) {
					temp[p] = items[p];
				}
				
				for (int p = m; p < items.length - 1; p++) {
					temp[p] = items[p + 1];
				}
				
				items = temp;
				
				return;
			} else {
				if (k.compareTo(items[m].key) < 0) {
					j = m;
				} else {
					i = m + 1;
				}
			}
		}
	}

	@Override
	public V search(Comparable k) {
		int i = 0;
		int j = items.length;
		
		while(i < j) {
			int m = (i + j) / 2;
			
			if (k.compareTo(items[m].key) == 0) {
				return items[m].value;
			} else {
				if (k.compareTo(items[m].key) < 0) {
					j = m;
				} else {
					i = m + 1;
				}
			}
		}
		
		return null;
	}

	@Override
	public Iterator<Comparable> iterator() {
		return new ArrayOrdinatoIterator<V>(items);
	}
	
	public static void main(String... args) {
		Dictionary<Integer> dict = new ArrayOrdinato<Integer>();
		dict.insert(5, "Simone");
		dict.insert(10, "morena");
		dict.insert(2, "morena");
		
		Iterator<Comparable> it = dict.iterator();
		
		while(it.hasNext()) {
			System.out.println(dict.search(it.next()));
		}
		
		
	}

}
