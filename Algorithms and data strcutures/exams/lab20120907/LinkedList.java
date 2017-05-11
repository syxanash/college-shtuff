package lab20120907;

import java.util.Iterator;

public class LinkedList<T> implements Lista<T> {
	
	private Posizione<T> items;
	
	private class LinkedListIterator<S> implements Iterator<S> {
		
		LinkedList<S> list;
		Posizione<S> pos;

		public LinkedListIterator(LinkedList<S> linkedList) {
			this.list = linkedList;
			this.pos = list.firstList();
		}

		@Override
		public boolean hasNext() {
			return !list.endList(pos);
		}

		@Override
		public S next() {
			S elem = list.read(pos);
			
			pos = list.succ(pos);
			
			return elem;
		}
		
	}

	@Override
	public boolean isEmpty() {
		return items == null;
	}

	// per convenzione il primo elemento sarà null
	@Override
	public Posizione firstList() {
		return null;
	}

	@Override
	public boolean endList(Posizione<T> p) {
		if (isEmpty())
			return true;
		
		// se p sarà uguale a null (cioè il primo elemento)
		// allora sicuramente avrà un valore e quindi non saremo alla fine
		
		if (p == firstList())
			return false;
		else // controllo i valori successivi alla posizione p altrimenti
			return ((Pointer<T>) p).next == null;
	}

	@Override
	public Posizione succ(Posizione<T> p) {
		if (isEmpty())
			throw new IndexOutOfBoundsException("Lista vuota");
		
		if (endList(p))
			throw new IndexOutOfBoundsException("Posizione fine lista nonvalida");
		
		// poichè firstlist ritorna null, se p è l'elemento
		// in prima posizione (null) allora ritorno la testa che sarebbe
		// items
		if (p == firstList())
			return items;
			
		return ((Pointer<T>) p).next;
	}

	@Override
	public Posizione pred(Posizione<T> p) {
		if (isEmpty())
			throw new IndexOutOfBoundsException("Lista vuota");
		
		if (p == firstList())
			throw new IndexOutOfBoundsException("Posizione fine lista nonvalida");
		
		for (Pointer<T> rec = (Pointer<T>) items; rec != null; rec = rec.next) {
			if (rec.next == p)
				return rec;
		}
		
		return null;
	}

	@Override
	public void insert(T e, Posizione<T> p) {
		Pointer<T> entry = new Pointer<T>(e);
		
		if (items == null) {
			items = entry;
		} else {
			if (p == firstList()) {
				entry.next = ((Pointer<T>) items);
				items = entry;
			} else {
				entry.next = ((Pointer<T>) p).next;
				((Pointer<T>) p).next = entry;
			}
		}
	}

	@Override
	public T read(Posizione<T> p) {
		if (isEmpty())
			throw new IndexOutOfBoundsException("Lista vuota");
		
		if (p == firstList())
			return ((Pointer<T>) items).elem;
		
		// dato che il primo elmento verrà letto con il controllo
		// precedente allora ritorno l'elemento successivo alla posizione p.
		return ((Pointer<T>) p).next.elem;
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator<T>(this);
	}
	
	public static void main(String... args) {
		Lista<String> list = new LinkedList<String>();
		
		list.insert("simone", list.firstList());
		list.insert("morena", list.firstList());
		list.insert("gianni", list.firstList());
		
		list.insert("luca", list.succ(list.firstList()));
		
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		/*
		for (Posizione<String> p = list.firstList(); !list.endList(p); p = list.succ(p)) {
			System.out.println(list.read(p));
		}*/
	}

}
