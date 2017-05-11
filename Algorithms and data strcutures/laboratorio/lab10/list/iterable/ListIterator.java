package lab10.list.iterable;

import java.util.Iterator;

import lab10.list.Posizione;

public class ListIterator<T> implements Iterator<T> {
	private Lista<T> list;
	private Posizione p;

	ListIterator(Lista<T> l) {
		list = l;
		p = l.firstList();
	}

	public boolean hasNext() {
		return !list.endList(p);
	}

	public T next() {
		// salvo in una variabile temporanea il valore attuale della posizione p
		// successivamente incremento il valore di p, per una successiva lettura
		
		Posizione q = p;
		p = list.succ(p);

		return list.readList(q);
	}

	public void remove() throws UnsupportedOperationException {
		//throw new UnsupportedOperationException();
		
		list.remove(p);
	}

}
