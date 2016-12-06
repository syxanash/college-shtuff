package lab20120403;

import java.util.Iterator;

public class Bag implements Iterable<String> {
	protected Dictionary<Integer> freqParole;
	
	private class BagIterator implements Iterator<String> {

		Iterator<Comparable> it;
		
		public BagIterator(Dictionary<Integer> items) {
			this.it = items.iterator();
		}
		
		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		@Override
		public String next() {
			return (String) it.next();
		}
		
	}

	public Bag() {
		freqParole = new CollDict<Integer>();
	}

	public void addItem(String item) {
		if (this.occurrences(item) > 0) {
			int currentNum = this.occurrences(item);

			freqParole.delete(item);
			freqParole.insert(currentNum + 1, item);
		} else {
			freqParole.insert(1, item);
		}
	}

	public void delItem(String item) {
		if (this.occurrences(item) <= 0)
			return;

		if (this.occurrences(item) == 1) {
			freqParole.delete(item);
		} else {
			int currentNum = this.occurrences(item);

			freqParole.delete(item);
			freqParole.insert(currentNum - 1, item);
		}
	}

	public int occurrences(String item) {
		int occ = 0;
		
		Object result = freqParole.search(item);
		
		if (result != null)
			occ = (int) result;
		
		return occ;
	}

	@Override
	public Iterator<String> iterator() {
		return new BagIterator(freqParole);
	}

	public static void main(String[] args) {
		Bag stats = new Bag();

		String[] words = new String(
				"ciao come va ciao che dici che ciao bella ciao")
				.split(" ");
		
		for(String w : words) {
			stats.addItem(w);
		}
		
		Iterator<String> it = stats.iterator();
		
		while(it.hasNext()) {
			String word = it.next();
			System.out.println(word + " - " + stats.occurrences(word));
		}

	}

}
