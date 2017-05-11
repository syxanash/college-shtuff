package lab20140415;

import java.util.Iterator;

public class Bag implements Iterable<String> {

	protected Dictionary<Integer> freqParole;

	private class BagIterator implements Iterator<String> {

		Dictionary<Integer> items;
		Iterator<Comparable> dictIterator;

		public BagIterator(Dictionary<Integer> items) {
			this.items = items;
			this.dictIterator = this.items.iterator();
		}

		@Override
		public boolean hasNext() {
			return this.dictIterator.hasNext();
		}

		@Override
		public String next() {
			return (String) dictIterator.next();
		}

	}

	public Bag() {
		freqParole = new ArrayOrdinato<Integer>();
	}

	public void addItem(String item) {
		int freq = 1;

		if (freqParole.search(item) != null) {
			freq = freqParole.search(item);
			freqParole.delete(item);

			freq++;
		}

		freqParole.insert(freq, item);
	}

	public void delItem(String item) {
		if (freqParole.search(item) != null) {
			freqParole.delete(item);
		}
	}

	public int occurrences(String item) {
		Integer freq = freqParole.search(item);

		if (freq != null)
			return freq;

		return 0;
	}

	public boolean isEmpty() {
		return freqParole == null;
	}

	@Override
	public Iterator<String> iterator() {
		return new BagIterator(freqParole);
	}

	public static void main(String... args) {
		Bag words = new Bag();

		words.addItem("ciao");
		words.addItem("morena");
		words.addItem("ciao");
		words.addItem("ancora!");
		
		for(String e : words) {
			System.out.println(e);
		}
	}

}
