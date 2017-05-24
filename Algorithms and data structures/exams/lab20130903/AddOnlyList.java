package lab20130903;

public interface AddOnlyList<S> extends Iterable<S> {
	public void add(S e);
	public String toString();
}
