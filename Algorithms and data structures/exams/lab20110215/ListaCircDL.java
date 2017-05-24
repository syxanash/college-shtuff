package lab20110215;

import java.util.Iterator;

public class ListaCircDL<T> implements CircList<T> {

	private Cella<T> items;
	private int n;
	private Direzione dir;
	
	private class ListaCircDLIterator<S> implements Iterator<S> {
		
		Cella<S> items;
		int n;
		int pos;

		public ListaCircDLIterator(Cella<S> items, int n) {
			this.items = items;
			this.n = n;
			this.pos = 0;
		}

		@Override
		public boolean hasNext() {
			return pos < n;
		}

		@Override
		public S next() {
			S elem = items.elem;
			items = items.next;
			pos++;
			
			return elem;
		}
		
	}
	
	@Override
	public void addCircList(T item) {
		Cella<T> entry = new Cella<T>(item);
		
		if (items == null) {
			items = entry;
			items.next = items.prev = items;
		} else {
			entry.next = items;
			entry.prev = items.prev;
			items.prev.next = entry;
			items.prev = entry;
		}
		
		n++;
	}

	@Override
	public void delCircList() {
		if (items.next == items) {
			items = null;
		} else {
			Cella<T> temp = items.next;
			temp.prev = items.prev;
			items.prev.next = temp;
			items = temp;
		}
		
		n--;
	}

	@Override
	public T value() {
		return items.elem;
	}

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public int numItem() {
		return n;
	}

	@Override
	public void setDir(Direzione direction) {
		this.dir = direction;
	}

	@Override
	public void ruota() {
		if (dir == Direzione.forward) {
			items = items.next;
		} else if (dir == Direzione.backward) {
			items = items.prev;
		} else {
			items = items.next;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new ListaCircDLIterator<T>(items, n);
	}

}
