package lab20150903;

import java.util.Iterator;

public class ArrList<S> implements AddOnlyList<S> {

	private S[] items = (S[]) new Object[1];
	private int n = 0;
	
	private class ArrListIterator implements Iterator<S> {
		private S[] list;
		private int size, pos;
		
		public ArrListIterator(S[] l, int s) {
			list = l;
			size = s;
			pos = 0;
		}
		
		@Override
		public boolean hasNext() {
			return pos < size;
		}

		@Override
		public S next() {
			return list[pos++];
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
		return new ArrListIterator(items, n);
	}
	
	public static void main(String... args) {
		ArrList<String> test = new ArrList<String>();
		
		test.add("simone");
		test.add("morena");
		test.add("gianni");
		
		for (String t : test) {
			System.out.println(t);
		}
	}

}
