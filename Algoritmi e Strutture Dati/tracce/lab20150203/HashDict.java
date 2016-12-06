package lab20150203;

import java.util.Iterator;
import java.util.LinkedList;

public class HashDict<S> implements Dictionary<S> {

	LinkedList<Couple> s[];
	
	protected class Couple {
		S elem;
		Comparable key;
		
		public Couple(S e, Comparable k) {
			this.elem = e;
			this.key = k;
		}
	}
	
	public HashDict(int n) {
		s = new LinkedList[n];
	}
	
	protected class HashDictIterator implements Iterator<Comparable> {

		LinkedList<Couple>[] list;
		int pos, posList;
		
		public HashDictIterator(LinkedList<Couple>[] s) {
			this.list = s;
			
			pos = 0;
			posList = 0;
		}

		@Override
		public boolean hasNext() {
			while (pos < list.length
					&& (list[pos] == null || list[pos].size() == 0)) {
				pos++;
			}
			
			return pos < list.length;
		}

		@Override
		public Comparable next() {
			Comparable elem = list[pos].get(posList++).key;
			
			if (posList >= list[pos].size()) {
				pos++;
				posList = 0;
			}
			
			return elem;
		}
		
	}
	
	@Override
	public void insert(S e, Comparable k) {
		int pos = this.h(k);
		
		Couple entry = new Couple(e, k);
		
		if (s[pos] == null) {
			s[pos] = new LinkedList();
		}
		
		for (Couple c : (LinkedList<Couple>) s[pos]) {
			if (c.key.compareTo(k) == 0) {
				throw new KeyAlreadyExistException();
			}
		}
		
		s[pos].add(entry);
	}

	@Override
	public void delete(Comparable k) {
		int pos = this.h(k);
		
		if (s[pos] == null) return;
		
		int index = 0;
		
		for (Couple c : (LinkedList<Couple>) s[pos]) {
			if (c.key.compareTo(k) == 0) {
				break;
			}
			
			index++;
		}
		
		if (index >= 0) {
			s[pos].remove(index);
		}
	}

	@Override
	public S search(Comparable k) {
		int pos = this.h(k);
		
		if (s[pos] == null) return null;
		
		for (Couple c : (LinkedList<Couple>) s[pos]) {
			if (c.key.compareTo(k) == 0) {
				return c.elem;
			}
		}
		
		throw new ItemNotFoundException();
	}

	@Override
	public Iterator<Comparable> iterator() {
		return new HashDictIterator(s);
	}
	
	private int h(Comparable k) {
		return Math.abs(k.hashCode()) % s.length;
	}

	public static void main(String... args) {
		HashDict<Integer> dict = new HashDict<Integer>(50);
		
		dict.insert(23, "ciao");
		dict.insert(43, "yo");
		dict.insert(1000, "Simone");
		dict.insert(455, "pippa");
		dict.insert(999, "lagherbert");
		dict.insert(666, "paulaner weiss");
		
		Iterator<Comparable> it = dict.iterator();
		
		dict.delete("yo");
		
		while(it.hasNext()) {
			System.out.println(dict.search(it.next()));
		}		
	}
}
