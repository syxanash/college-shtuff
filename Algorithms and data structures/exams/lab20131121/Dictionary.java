package lab20131121;

public interface Dictionary<V> extends Iterable<Comparable> {
	public void insert(Comparable key, V value);
	public void delete(Comparable key);
	public V search(Comparable key);
}
