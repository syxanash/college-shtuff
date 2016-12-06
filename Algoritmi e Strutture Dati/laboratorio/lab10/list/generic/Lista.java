package lab10.list.generic;

import lab10.list.Posizione;

public interface Lista<T> {
	public boolean isEmpty();

	public boolean endList(Posizione p);

	public T readList(Posizione p);

	public void writeList(T e, Posizione p);

	public Posizione firstList();

	public Posizione succ(Posizione p);

	public Posizione pred(Posizione p);

	public void insert(T e, Posizione p);

	public void remove(Posizione p);
}
