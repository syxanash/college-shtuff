package lab20120907;

public interface Lista<T> extends Iterable<T> {
	public boolean isEmpty();
	public Posizione<T> firstList();
	public boolean endList(Posizione<T> p);
	public Posizione<T> succ(Posizione<T> p);
	public Posizione<T> pred(Posizione<T> p);
	public void insert(T e, Posizione<T> p);
	public T read(Posizione<T> p);
}
