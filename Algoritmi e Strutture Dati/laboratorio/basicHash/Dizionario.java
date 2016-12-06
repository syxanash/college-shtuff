package basicHash;

public interface Dizionario<K, V> extends Iterable<V> {
	void add(K key, V value);
	void delete(K key);
	V search(K key);
}
