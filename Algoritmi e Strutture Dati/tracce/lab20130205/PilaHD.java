package lab20130205;

import java.util.Iterator;

public class PilaHD<T> implements Pila<T> {
	
	T[] S = (T[]) new Object[1];
	int n = 0;
	
	private class PilaHDIterator<S> implements Iterator<S> {
		
		S[] items;
		int n;
		int pos;
		
		public PilaHDIterator(S[] items, int n) {
			this.items = items;
			this.n = n;
			this.pos = n - 1;
		}

		@Override
		public boolean hasNext() {
			return pos >= 0;
		}

		@Override
		public S next() {
			return items[pos--];
		}
		
	}

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public void push(T e) {
		S[n] = e;
		n++;
		
		if (n == S.length) {
			T[] temp = (T[]) new Object[S.length * 2];
			
			for (int i = 0; i < n; i++)
				temp[i] = S[i];
			
			S = temp;
		}
	}

	@Override
	public T top() {
		if (!isEmpty())
			return S[n - 1];
		
		return null;
	}

	@Override
	public void pop() {
		n--;
		
		if (n > 1 && n <= S.length / 4) {
			T[] temp = (T[]) new Object[S.length / 2];
			
			for (int i = 0; i < n; i++)
				temp[i] = S[i];
			
			S = temp;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new PilaHDIterator<T>(S, n);
	}
	
	public static void main(String... args) {
		Pila<String> stack = new PilaHD<String>();
		
		stack.push("simone");
		stack.push("morena");
		stack.push("ettore");
		stack.push("luisa");
		stack.push("fedele");
		
		//System.out.println(stack.top());
		
		Iterator<String> it = stack.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
