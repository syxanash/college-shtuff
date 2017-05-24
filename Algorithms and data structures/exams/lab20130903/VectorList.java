package lab20130903;

import java.util.Iterator;

public class VectorList<S> implements AddOnlyList<S> {
	
	S[] items = (S[]) new Object[1];
	int n = 0;

	private class VectorListIterator<T> implements Iterator<T> {
		
		T[] items;
		int num = 0;
		int pos = 0;
		
		public VectorListIterator(T[] list, int n) {
			items = list;
			num = n;
		}

		@Override
		public boolean hasNext() {
			return pos < num;
		}

		@Override
		public T next() {
			T elem = items[pos];
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
		return new VectorListIterator<S>(items, n);
	}
	
	public static void main(String... args) {
		AddOnlyList<String> list = new VectorList<String>();
		list.add("simone");
		list.add("morena");
		list.add("giovanni");
		list.add("simone");
		
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
