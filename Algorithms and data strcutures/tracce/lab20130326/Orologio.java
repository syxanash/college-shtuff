package lab20130326;

import java.util.Iterator;

public class Orologio<S> implements CircQueue<S> {
	
	private S[] items = (S[]) new Object[1];
	private int pos = 0;
	private int n = 0;
	
	boolean stopped = false;
	
	private class OrologioIterator implements Iterator<S> {

		private S[] list;
		private int size;
		private int curr;
		
		public OrologioIterator(S[] list, int size) {
			this.list = list;
			this.size = size;
			this.curr = 0;
		}
		
		@Override
		public boolean hasNext() {
			return curr < size;
		}

		@Override
		public S next() {
			return list[curr++];
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
	public S value() {
		return items[pos];
	}

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public void rotateF() {
		if (stopped)
			return;
		
		if (pos + 1 >= n)
			pos = 0;
		
		pos++;
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public boolean equals(CircQueue<S> s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void stop() {
		stopped = true;
	}

	@Override
	public void restart() {
		stopped = false;
	}

	@Override
	public Iterator<S> iterator() {
		return new OrologioIterator(items, n);
	}
	
	public static void main(String... args) {
		CircQueue<String> list = new Orologio<String>();
		list.add("simone");
		list.add("morena");
		list.add("gianni");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.value());
			list.rotateF();
		}
		
	}

}
