package lab20160118;

public interface IndexedList<T> extends Iterable<T> {
	public boolean isEmpty(int i);
	public void addItem(T e, int i);
	public void delItem(int i);
	public T getElem(int i);
	public int numberItems();
}
