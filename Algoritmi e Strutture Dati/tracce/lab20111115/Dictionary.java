package lab20111115;

public interface Dictionary<S> extends Iterable<S> {
	public void insert(S e, Comparable k);
	public void delete(Comparable k);
	public S search(Comparable k);
}
