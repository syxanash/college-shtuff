package basicHash;

import java.util.Iterator;

public class TabellaHash<V> implements Dizionario<Comparable, V> {

	private Couple<V>[] items;
	private Hash hFunc;
	private Scansione sFunc;

	private class Couple<E> {
		Comparable key;
		E value;

		public Couple(Comparable k, E v) {
			this.key = k;
			this.value = v;
		}
	}

	public TabellaHash(int n, Hash hFun, Scansione sFun) {
		this.items = new Couple[n];
		this.hFunc = hFun;
		this.sFunc = sFun;
	}

	@Override
	public void add(Comparable key, V value) {
		int hk = this.hFunc.h(key, items.length);
		
		for (int i = 0; i < items.length; i++) {
			int pos = sFunc.c(hk, i, items.length);
			
			if (items[pos] == null) {
				items[pos] = new Couple<V>(key, value);
				return;
			}
		}
		
		System.out.println("array pieno");
		System.exit(1);
		
	}

	@Override
	public void delete(Comparable key) {
		int hk = hFunc.h(key, items.length);
		
		for (int i = 0; i < items.length; i++) {
			int pos = sFunc.c(hk, i, items.length);
			
			if (items[pos] != null && items[pos].key.compareTo(key) == 0) {
				items[pos] = null;
				return;
			} else if (items[pos] == null) {
				break;
			}
		}

	}

	@Override
	public V search(Comparable key) {
		int hk = hFunc.h(key, items.length);
		
		for (int i = 0; i < items.length; i++) {
			int pos = sFunc.c(hk, i, items.length);
			
			if (items[pos] != null && items[pos].key.compareTo(key) == 0)
				return items[pos].value;
		}
		
		return null;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String... args) {
		Dizionario<Comparable, String> table = new TabellaHash<String>(10, new HashDivisione(), new ScansioneLineare());
		table.add(5546, "Simone");
		table.add(2385, "morena");
		table.add(6945, "giovanni");
		
		table.delete(6945);
		
		System.out.println(table.search(6945));
	}

}
