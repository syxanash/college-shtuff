package lab20120210;

import java.util.Iterator;

public class Orologio<S> implements CircList<S> {
	
	private S[] items = (S[]) new Object[1];
	private int n = 0;
	private int head = 0;
	
	private class OrologioIterator<T> implements Iterator<T> {
		
		Orologio<T> watch;
		T head;
		boolean gotFirst = false;
		
		public OrologioIterator(Orologio<T> watch) {
			this.watch = watch;
			this.head = this.watch.value();
		}

		@Override
		public boolean hasNext() {
			if (head == watch.value() && gotFirst) {
				return false;
			} else if (head == watch.value()) {
				gotFirst = true;
				
				return true;
			}
			
			return true;
		}

		@Override
		public T next() {
			T elem = watch.value();
			watch.rotateF();
			
			return elem;
		}
		
	}

	@Override
	public void add(S e) {
		for (int i = n; i > head; i--) {
			items[i] = items[i - 1];
		}
		
		items[head] = e;
		
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
		return items[head];
	}

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public void rotateF() {
		if (head < n - 1) {
			head++;
		} else {
			head = 0;
		}
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public boolean equals(CircList<S> s) {
		boolean same = true;
		
		if (s.size() == this.size()) {
			for (int i = 0; i < n; i++) {
				if (!(s.value().equals(this.value()))) {
					same = false;
					break;
				}
				
				s.rotateF();
				this.rotateF();
			}
		} else {
			same = false;
		}
		
		return same;
	}

	@Override
	public Iterator<S> iterator() {
		return new OrologioIterator<S>(this);
	}
	
	public static void main(String... args) {
		CircList<String> watch = new Orologio<String>();
		
		System.out.println("vuota: " + watch.isEmpty());
		
		watch.add("simone");
		watch.add("morena");
		watch.add("giovanni");
		
		watch.rotateF();
		//watch.rotateF();
		
		watch.add("nicola");
		
		Iterator<String> it = watch.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("nums: " + watch.size());
		
		System.out.println("vuota: " + watch.isEmpty());

		
	}

}
