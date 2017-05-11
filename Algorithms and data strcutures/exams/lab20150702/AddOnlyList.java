package lab20150702;

public interface AddOnlyList<S> extends Iterable<S> {
	public void add(S e);
	public int size();
}
