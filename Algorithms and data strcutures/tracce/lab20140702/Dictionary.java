package lab20140702;

public interface Dictionary<K, V> extends Iterable<K> {
	public void insert(K key, V value);
	public void delete(K key) throws StrutturaVuotaException;
	public V search(K key) throws StrutturaVuotaException;
}
