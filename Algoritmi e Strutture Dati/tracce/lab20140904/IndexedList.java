package lab20140904;

public interface IndexedList<T> extends Iterable<T> {
	public boolean isEmpty(int i);
	public void addItem(T e, int i);
	public void delItem(int i);
	public T getItem(int i);
	public int numberItems();
}
