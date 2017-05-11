package lab20140702;

import java.util.Iterator;

public class VectorList<S> implements AddOnlyList<S> {
	
	private S[] items = (S[]) new Object[1];
	private int n = 0;
	
	private class VectorListIterator<T> implements Iterator<T> {
		T[] list;
		int pos;
		
		public VectorListIterator(T[] items) {
			this.list = items;
			pos = 0;
		}

		@Override
		public boolean hasNext() {
			return pos < n;
		}

		@Override
		public T next() {
			T elem = list[pos];
			pos++;
			
			return elem;
		}
		
	}

	@Override
	public void add(S e) {
		items[n] = e;
		n++;
		
		if (n == items.length) {
			S[] temp = (S[]) new Object[items.length * 2];
			
			for (int i = 0; i < n; i++)
				temp[i] = items[i];
			
			items = temp;
		}
	}

	@Override
	public Iterator<S> iterator() {
		return new VectorListIterator<S>(items);
	}
	
	public static void main(String... args) {
		AddOnlyList<String> list = new VectorList<String>();
		
		list.add("simone");
		list.add("francesco");
		list.add("maraia");
		
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
