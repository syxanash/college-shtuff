package lab20160411;

import java.util.Iterator;

public class VectorList<S> implements AddOnlyList<S> {

	S[] items = (S[]) new Object[1];
	int n = 0;
	
	private class AddOnlyListIterator<T> implements Iterator<T> {
		T[] items;
		int n, pos;
		
		public AddOnlyListIterator(T[] items, int n) {
			this.items = items;
			this.n = n;
			this.pos = 0;
		}

		@Override
		public boolean hasNext() {
			return pos < n;
		}

		@Override
		public T next() {
			return items[pos++];
		}
		
	}
	
	@Override
	public void add(S e) {
		items[n++] = e;
		
		if (n == items.length) {
			S[] temp = (S[]) new Object[items.length * 2];
			
			for (int i = 0; i < n; i++)
				temp[i] = items[i];
			
			items = temp;
		}
	}

	@Override
	public Iterator<S> iterator() {
		return new AddOnlyListIterator<S>(items, n);
	}
	
	public static void main(String... args) {
		AddOnlyList<String> list = new VectorList<String>();
		
		list.add("simone");
		list.add("giovanni");
		list.add("morena");
		
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
